// EXERCISE
// a,b
// def isVovel(ch: Char) = ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
def isVovel(ch: Char) = "aeiou".contains(ch)
isVovel('e')

// c
def vowels1(s: String) = {
  var result: String = ""
  for (ch <- s) if (isVovel(ch)) result += ch
  result
}
vowels1("adieu")
vowels1("Nicaragua")

// d
def vowels2(s: String) = for (ch <- s if isVovel(ch)) yield ch
vowels2("adieu")
vowels2("Nicaragua")

// e
def vowels3(s: String): String = {
  if (s.length == 0) ""
  else {
    val ch = s(0)
    val rest = vowels3(s.substring(1))
    if (isVovel(ch)) ch + rest else rest
  }
}
vowels3("adieu")
vowels3("Nicaragua")

// f
def vowels4(s: String) = {
  var i = 0
  var result = ""
  while( i < s.length) {
    val ch = s(i)
    if (isVovel(ch)) result += ch
    i += 1
  }
  result
}
vowels4("adieu")
vowels4("Nicaragua")

// g
def isVowel2(vowels: String, ch: Char) = vowels.contains(ch)
def vowels5(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true) =
  for (ch <- (if (ignoreCase) s.toLowerCase else s) if isVowel2(vowelChars, ch)) yield ch
vowels5("AdiEu")
vowels5("AdiEu", ignoreCase = false)

def vowels6(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true): String =
  if (ignoreCase) vowels6(s.toLowerCase, vowelChars, false)
  else for (ch <- s if isVowel2(vowelChars, ch)) yield ch
vowels6("AdiEu")
vowels6("AdiEu", ignoreCase = false)

vowels6("Übeltätergehör", "aeiouäöü")
vowels6("Übeltätergehör", "aeiouäöü", false)
