// Posortuj listę liczb w porządku malejącym.
// a) napisz własny komparator
// b) zajrzyj do klasy Collections i zobacz czy nie ma tam cos ciekawego nt. odwrotnego porządku sortowania

def listOfNumber = [13, 12, 15, 14, 223, 156, 300, 30, 21, 4, 5]
def newListOfNumber = listOfNumber.sort()
newListOfNumber = newListOfNumber.reverse()
println(newListOfNumber);


Collections.sort(listOfNumber, Collections.reverseOrder())
println(listOfNumber)
