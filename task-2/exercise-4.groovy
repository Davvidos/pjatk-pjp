// Uogólnić funkcję z zadania 2, tak by wprowadzane mogły być dowolne liczby i słowa (napisy rozdzielone białymi znakami), a ich poprawność weryfikowana za pomocą przekazanego funkcji domknięcia.
// Niech funkcja nazywa sie getData.
// Przykładowe wywołania:

// getData(Integer) { it > 0 }            // liczby całkowite większe od 0
// println getData() { it.size() > 3 }    // słowa o długości większej od 3 (domyślny typ: String)
// println getData()                      // dowolne napisy (słowa)
// println getData(BigDecimal)            // dowolne liczby

import javax.swing.*

println getData(Integer) {
    it > 0
}

println getData() {
    it.size() > 3
}

println getData()

println getData(BigDecimal)

def getData(arg1 = null, arg2 = null) {
    def values = []
    def error = false

    while (true) {
        def dialogMessage = "Podaj wartość"
        if (error) {
            error = false
            dialogMessage = "Błąd. $dialogMessage"
        }

        def input = JOptionPane.showInputDialog(null, dialogMessage, "")
        if (input == null)
            break

        if (arg1 instanceof Class) {
            try {
                input = input.asType(arg1)
                if (arg2 instanceof Closure && !validateData(arg2, input)) {
                    error = true
                    continue
                }
            }
            catch (ex) {
                error = true
                continue
            }
        }

        if (arg1 instanceof Closure && !validateData(arg1, input)) {
            error = true
            continue
        }

        values.push input
    }

    return values
}

def validateData(argument, value) {
    return argument(value)
}
