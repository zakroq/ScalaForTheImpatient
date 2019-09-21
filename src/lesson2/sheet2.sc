val a = 4
val result1 = if (a > 0) "something" else -1 // result type of supertype Any

val result2 = if (a < 0) "something" // no else but else occurred: result a () type of Unit
val result3 = ()

// BLOCKS
import scala.math._
val x = 5
val x0 = 3
val y = 4
val y0 = 1
val distance = {
  val dx = x - x0
  val dy = y - y0
  sqrt(dx * dx + dy * dy) //value of block is the value of last expression, if missing: () of type Unit
}

// FOR-EACH
val n = 10
for (i <- 1 to n) print(i)
for (c <- "Hello") print(c)
for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
val result4 = for (i <- 1 to 10) yield i % 3 // collection of result [Vector similar to Array/ArrayList

// FUNCTIONS
def abs(x: Double) = if (x >= 0) x else -x //return Double inferred from input parameter

def fac(n: Int): Int = if (n <= 0 ) 1 else n * fac(n - 1) //recursive function - inferred result type not works
fac(10)

//def box(s: String): Unit = {
def box(s: String) { // procedure - no '=' - we do not care about result, can be defined as above
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}
box("Hello")

def fac2(n: Int) = {
  var r = 1
  for (i <- 1 to n) r = r * i
  r
}
fac2(10)

// FUNCTION ARGUMENTS
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
decorate("Hello") // default parameters for left and right
decorate("Hello", ">>>[", "]<<<")
decorate("Hello", "##[") // default parameter for right
decorate("Hello", right = "]##") // named parameters

def sum(args: Int*) = { // variable number of arguments
  var result = 0
  for (arg <- args) result += arg
  result
}
sum(2,3,4)
sum(2,3,4,5,6,7)
sum(1,2)
sum(1 to 10 : _*) // ':' - consider this as a ..., '_*' - a sequence of something

def recursiveSum(args: Int*): Int = { // recursive function with varargs
  if (args.length == 0) 0
  else args.head + // take the first element (head) and then
  recursiveSum(args.tail : _*) // call function recursively with rest of elements (tail) but convert it to something that can be passed to a function with varargs
}
recursiveSum(2,3,4,5,6,7)
