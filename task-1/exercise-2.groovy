// Napisy wprowadzane w kolejnych dialogach mają formę: pozycja = koszt.
// Zsumuj wszystkie koszty dla tych samych pozycji (np. mleko, chleb). (5)

def items = getItemsAndPrices()

def getItemsAndPrices() {
    def map = [:]

    while (true) {
        def rawProduct = getUserProduct()
        if (rawProduct == "")
            break

        def parts = rawProduct.split(" = ")
        def product = parts[0]
        def price = new BigDecimal(parts[1])

        if (map.containsKey(product)) {
            def sum = map.get(product)
            sum += price
            map.replace(product, sum)
        }
        else
            map.put(product, price)
    }

    return map
}

def getUserProduct() {
    def prompt = true
    def scanner = new Scanner(System.in)
    def input = ""

    while (prompt) {
        prompt = false
        print "Wprowadź produkt z ceną. \n"
        print "Format: produkt = 0.00, np. kasza = 5.00 \n"

        input = scanner.nextLine()
        if (input == "")
            break

        if (!input.matches("[a-zA-Z]* = [0-9]*.[0-9]{2}")) {
            prompt = true
            println "Błędny zapis. \n"
        }
        print "Dodano pomyślnie! \n"
    }

    return input
}

items.each { key, value ->
    println "$key: $value"
}
