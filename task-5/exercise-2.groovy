// Utwórz posortowany zbiór słów z pliku. Słowa mają być uporządkowane według ich długości, jeśli długość jest taka sama należy zastosować porządek alfabetyczny.

def text = 'lorem ipsum dolor sit amet consectetur adipiscing elit nullam efficitur mauris sed dictum rhoncus Sed at dui tellus vestibulum mattis pretium ante in dictum mi consectetur vel sed vitae eleifend nulla vivamus consequat eu tortor ut maximus'
text = text.split()

def comparator = { String a, String b ->
    {
        def comparedTo = a.length().compareTo(b.length())
        if (comparedTo == 0) {
            return a.compareTo(b)
        } else return comparedTo
    }
}
SortedSet sortedSet = new TreeSet(comparator)
sortedSet.addAll(text)

println("sorted words: ${sortedSet}")
