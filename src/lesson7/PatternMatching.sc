// match is a deluxe version of the switch statement
// no break, expression like if

// value matching
val multiply = '*'
val plus = '+'
def sign(ch: Char) = ch match {
  case '+' => 1
  case '-' => -1
  //case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
  case _ => 0 //case something else, like default
}
sign(multiply)
sign(plus)

// type matching - preferred over var.isInstanceOf[Type]
val obj = "5"
def parse(b: Any) = b match {
  case x: Int => x
  case s: String => Integer.parseInt(s)
  case _: BigInt => Int.MaxValue
  case _ => 0
}
parse(obj)

import java.io.IOException
try {
  println("done")
} catch {
  case e: IOException => println("Caught IOException " + e)
  case _: Throwable => println("Oh noes!")  // use 'wildcard '_' if you do not care about the exception object
}

// match can "extract" contents from tuples
val tuple1 = (5, 0)
val tuple2 = (0, "A")
val tuple3 = ("A", 5)
def pair(e: Any) = e match {
  case (0, _) => "0 ..." // starts with 0 followed by something
  case (y, 0) => y + " 0" // starts with some 'y' (this is bind to variable 'y') and then followed by 0
  case _ => "neither is 0"
}
pair(tuple1)
pair(tuple2)
pair(tuple3)

// also with arrays
val arr1 = Array(0, 1, 2, 3)
val arr2 = Array(0)
val arr3 = Array(5, 6)
val arr4 = Array(5, 6, 7)
def arrMatch(a: Array[Int]) = a match {
  case Array(0) => "0" // if yours array matches the array constructed as Array(0) - array contains only one 0 value
  case Array(x, y) => x + " " + y // matches an array contains exactly 2 elements - bind those elements to variables x and y
  case Array(0, _*) => "0 ..." // matches any array that starts with 0 and it is followed by 0 or more value
  case _ => "something else"
}
arrMatch(arr1)
arrMatch(arr2)
arrMatch(arr3)
arrMatch(arr4)

// extraction
val (uppercase, lowercase) = "Hello, World".partition(Character.isUpperCase(_)) // partition returns a pair
val arr = Array(0, 1, 2, 3)
val Array(first1, second1, _*) = arr
val Array(first2, second2, rest @ _*) = arr // special syntax for binding to _*
