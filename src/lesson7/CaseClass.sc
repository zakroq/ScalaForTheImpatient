// case class: class that optimized for use in pattern matching
// all of the constructor parameters becomes a val
// the companion object get an 'apply' factory method
// the methods are also generated:
// - toString,
// - equals,
// - hashCode,
// - unapply: makes extractors work,
// - copy: lets you copy values
abstract class Amount
case class Dollar(value: Double) extends Amount // case class can be defined when the extraction works
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount // singleton

val amt = Currency(1000, "EUR")

def output(a: Amount): String = a match {
  case Dollar(v) => "$" + v
  case Currency(_, u) => "Oh noes, I got " + u
  case Nothing => ""
}
output(amt)

val price = amt.copy()
val price2 = amt.copy(unit = "CHF")


// Option[T] - safe alternative to providing a value of type T or null (instead of NullPointerException)
// case class Some[T] that wraps a value
// case object None that indicated that there is no value
val scores = Map("Alice" -> 1, "Bob" -> 2)
scores.get("Alice") match {
  case Some(score) => println(score)
  case None => println("No score")
}

// recursive data structures
// an expression is either a number, sum or product
abstract class Expr
case class Num(value: Int) extends Expr
case class Sum(left: Expr, right: Expr) extends Expr // recursive data type: left and right are type Expr
case class Product(left: Expr, right: Expr) extends Expr

val e = Product(Num(3), Sum(Num(4), Num(5)))

def eval(e: Expr): Int = e match {
  case Num(v) => v
  case Sum(l, r) => eval(l) + eval(r)
  case Product(l, r) => eval(l) * eval(r)
}
eval(e)

// Polymorphism is appropriate for an open-ended collection of subclasses
// case classes and pattern patching are best for a bounded collection - code is more concise and all cases are in one place

