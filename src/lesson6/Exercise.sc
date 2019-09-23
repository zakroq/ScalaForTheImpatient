// PART 1: Life Without Loops
// a - all available TimeZones
val zones = java.util.TimeZone.getAvailableIDs

// b - remove '/'
zones.map(s => s.split("/"))

// c - just get first index - just the city names without continent
//zones.map(s => s.split("/")).map(a => a(1)) // ArrayIndexOutOfBoundsException - some doe snot have '/'

// d - remove those without '/', return just city names
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1))

// e - grouped them by 10th
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).toArray

// f - get first from each group
zones.map(s => s.split("/")).filter(_.length > 1).map(a => a(1)).grouped(10).toArray.map(a => a(0))


// PART 2: Reductions
// a - factorial (silnia)
1.to(10).reduceLeft(_ * _) // factorial ((...(1 * 2) * 3) * ... *9)
// b
def fac(n: Int) = 1.to(n).reduceLeft(_ * _)
fac(10)

// d - power
1.to(10).map(n => 2).reduceLeft(_ * _) // each element is map to '2' => 10 copies of 2: (2 * 2 * .. * 2) = 1024

// e
def pow(a: Int, b: Int) = 1.to(b).map(n => a).reduceLeft(_ * _)
pow(2, 10)

// f - concatenate strings
def concat(strings: Seq[String], separator: String) = strings.reduceLeft(_ + separator + _)
concat(Array("Mary", "had", "a", "little", "lamb"), " ")


// PART 3: Do-It-Yourself - While

// function consumes 2 functions:
// 'cond' for the condition: no parameters and yielding (returning) a boolean
// 'body': no parameters and returning nothing
def While(cond: () => Boolean, body: () => Unit) {
  if (cond()) {
    body(); While(cond, body)
  }
}
val n = 10
var i = 1
var f = 1
While(() => i < n, () => { f *= i; i+=1 })
f

// a little better looking - avoid the unsightly () => "call by name" notation
def While2(cond: => Boolean, body: => Unit) {
  if (cond) {
    body; While2(cond, body)
  }
}
i = 1
f = 1
While2(i < n, { f *= i; i+=1 })
f

// modify to call like normal while loop - def syntax for currying
def While3(cond: => Boolean)(body: => Unit) {
  if (cond) {
    body; While3(cond)(body)
  }
}
i = 1
f = 1
While3(i < n) { f *= i; i+=1 }
f
