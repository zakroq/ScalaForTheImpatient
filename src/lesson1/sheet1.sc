util.Properties.versionString

2 + 2

val answer = 8 * 5 + 2
answer

var response = 42
response = 21

var greeting: String = null
greeting = "hello"

val range = 1.to(10) //RichInt

"Hello".intersect("World") //StringOps

val x: BigInt = 123456789
x * x * x * x

1.to(10) //dot notation
1 to 10 //infix notation: only for method with 1 parameters

// ++ ,-- does not exists in Scala
var counter = 2
counter += 1
counter

import scala.math._
sqrt(2) //function
BigInt.probablePrime(100, scala.util.Random) // static method

"Hello".distinct //method without parameters does not use () - only when not mutate the value
"Hello".length

"Hello"(4) //shortcut for apply method
"Hello".apply(4)


//exercise
val b: BigInt = 6 * 7
b.pow(1000)

import scala.math._
sqrt(10) * sqrt(10)
1 to 10
1.to(10).map(sqrt(_))


"Mississippi".distinct
"Rhine".permutations
"Rhine".permutations.toArray

"ABC".sum
"ABC".sum.toInt
'A' + 'B' + 'C'
('A' + 'B' + 'C').toChar
198.toChar
