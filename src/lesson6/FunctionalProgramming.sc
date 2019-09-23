import scala.math._
val num = 3.14
val fun = ceil _    // type: (Double) => Double

// calling a function
fun(num)

// .map apply the function to every element in the collection
// map function is a higher-order function - it consumes another function
Array(3.14, 1.42, 2.0).map(fun)

// anonymous function
// if you need a function only once - do not named it - use as anonymous function
Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)

// function stored as a value
val triple1 = (x: Double) => 3 * x
Array(3.14, 1.42, 2.0).map(triple1)

// method
def triple2(x: Double) = 3 * x
Array(3.14, 1.42, 2.0).map(triple2)

// function as a parameter:
// name of the function is 'func' and has a type (Double) => Double: eats a double and produce a double
def valueAtOneQuarter(func: (Double) => Double) = func(0.25)

valueAtOneQuarter(ceil _)  // 1.0 because ceil(0.25) = 1.0
valueAtOneQuarter(sqrt _)  // 0.25 because 0.5 * 0.5 = 0.25
valueAtOneQuarter(triple1) // 0.75 because 3 x 0.25 = 0.75 -- no need of '_' -> triple1 is a val, not def
valueAtOneQuarter(triple2 _) // 0.75 because 3 x 0.25 = 0.75 -- needs '_' -> triple2 is a def

// function that eats a number (parameter of type Double) and produces a function that consumes double and returns a double
// '(x: Double) => factor * x' is a code of returning function
def mulBy(factor: Double) = (x: Double) => factor * x
// mulBy(3) returns (x: Double) => 3 * x

val triple3 = mulBy(3)
triple3(20)
// A function has access to any variable from any enclosing scope
// even if the variable is no longer around when you call the function!
// 1. when calling 'mulBy(3)', 'factor' is set to 3
// 2. when 'mulBy(3)' returns, triple3 is set to the function...
// 3. ... and the parameter variable 'factor' is gone
// 4. when triple3(20) is called, 'factor * 20' is computer
// The function 'captures' the variables that it needs
// Function + values for free variables ('factor') = closure


// parameter inference
valueAtOneQuarter((x: Double) => 3 * x)
valueAtOneQuarter((x) => 3 * x) // scala knows that x is a type of double because valueAtOneQuarter takes a function of type double
valueAtOneQuarter(x => 3 * x) // if one parameter -> you can omit ()
valueAtOneQuarter(3 * _) // if parameter variable occurs just once, can replace with '_'


// CURRYING - turning a function that takes two arguments into a function that takes one argument
// --> that function returns a function that consumes the second argument
def mul(x: Int, y: Int) = x * y
def mulOneAtATime(x: Int) = (y: Int) => x * y // curried version
mulOneAtATime(3) // y => 3 * y
mulOneAtATime(3)(14) // 3 * 14 --> (3) - first level of invocation, (14) - second level of invocation
// syntactic sugar
def mulOneAtATime2(x: Int)(y: Int) = x * y
mulOneAtATime2(3)(14)

// currying in practice
val first = Array("Hello", "World")
val second = Array("hello", "world")
first.corresponds(second)(_.equalsIgnoreCase(_)) // corresponds method compares whether two sequences are the same under some comparison criterion
// def corresponds[B](that: GenSeq[B])(p: (A,B) => Boolean): Boolean
// first.corresponds(second) --> compiler can infer the type B (second) as a sequence of Strings because A (first) is a sequence of Strings
// compiler knows that function 'p: (A,B) => Boolean' must compare two Strings
