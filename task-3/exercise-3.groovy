// Daty w tekście maja postać YYYY-MM-DD (rok- miesiac- dzien). Wypisać wszystkie poprawne daty.
// czyli: po wyróżnieniu wszystkich fragmentów, które mogą być datami sprawdzić ich poprawność (np. czy właściwa jest liczba dni w miesiącu)

import java.text.ParseException
import java.text.SimpleDateFormat

def text = "Lorem ipsum dolor 2004-02-13 sit amet, consectetur adipiscing elit. 2012-02-08 Pellentesque eget volutpat lectus, at 23-05-2013 tristique nisi. Quisque ultrices 2019-07-22 dictum eros, at viverra orci dictum at. Aliquam egestas at neque ut lacinia. Morbi maximus 21-12-2019 scelerisque tellus ut egestas. Nulla egestas neque eu cursus tristique. Maecenas quis tellus viverra, auctor tortor quis, sagittis lectus. Aenean ornare suscipit sem, in eleifend lectus pellentesque eget. Phasellus dictum iaculis nibh, sed molestie mauris sollicitudin eget. Integer maximus enim vel arcu lobortis varius."

def allDates = text =~ /[0-9]{4}-[0-9]{2}-[0-9]{2}/
def validDates = allDates.findAll({
    def valid = true

    try {
        def dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        dateFormat.setLenient(false)
        dateFormat.parse(it)
    } catch(ParseException e) {
        valid = false
    }

    return valid
})

println validDates
