// a) Napisać wyrażenie regularne, za pomocą którego można odnaleźć w tekście dowolne liczby rzeczywiste.
// b) zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN, w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)

import groovy.json.JsonSlurper

// Zadanie a
def realNumberRegex = /\-?[0-9]+\.[0-9]+|\-?[0-9]+/
def inputText = "Lorem ipsum dolor 1.23 sit amet, consectetur adipiscing elit. 4.56 Pellentesque eget volutpat lectus, at -123.456 tristique nisi."
def matches = inputText =~ realNumberRegex
matches.each {
    println it
}

// Zadanie b
def text = "Chleb 5.50 PLN, ciasto 20.99 PLN lub ciasto 5 EUR lub 12.35 EUR za zabawke"
def plnPriceRegex = /(\-?[0-9]+\.[0-9]+|\-?[0-9]+)\ [P][L][N]/

def euroRate = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
def plnToEuroRate = 1/euroRate

println text
def updatedPricesText = text.replaceAll(plnPriceRegex, {
    def price = (it[0] =~ realNumberRegex)[0] as BigDecimal
    return String.format("%.2f", price * plnToEuroRate) + " EUR"
})
println updatedPricesText
