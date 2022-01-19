// Policz liczbę wystąpień poszczególnych słów w pliku.
// Wypisz słowa alfabetycznie wraz z informacją o liczbie wystąpień każdego słowa
// Uwagi:
// a) co to są słowa? - uwzględnić znaki interpunkcji (+1 p.)
// b) co to jest alfabetycznie? - uwzględnić porządek alfabetyczny dla danego języka (+2 p.)

static void main(String[] args)
{
    TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    Scanner txtFile = new Scanner(new File("words.txt"));
    while(txtFile.hasNext()) {
        String word = txtFile.next();
        if(map.containsKey(word)) {
            int count = map.get(word) + 1;
            map.put(word, count);
        } else {
            map.put(word, 1);
        }
    }

    txtFile.close();
    map = map.sort()
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
        println(entry);
    }
}
