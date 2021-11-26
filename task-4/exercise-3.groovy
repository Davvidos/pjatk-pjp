// Wylistować pełne nazwy wszystkich plików html z podanego katalogu i wzystkich jego podkatalogów w postaci:
// 1 nazwa
// 2 nazwa

def directory = new File('html')
def counter = 1
directory.eachFileRecurse {
    if (it.isFile() && it.name.endsWith('.html')) {
        println(counter + " " + it)
        counter++
    }
}
