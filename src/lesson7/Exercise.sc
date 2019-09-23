// PART 1: Pattern matching
// a: swap pair of ints
def swap(p: (Int, Int)) = p match { case (x, y) => (y, x) }
swap((3, 4))

// b: swap just first 2 elements from Array of ints
def swap2(a: Array[Int]) = a match {
  case Array(x, y, rest @ _*) => Array(y, x) ++ rest
  case _ => a
}
swap2(Array(2, 1, 7, 9))
swap2(Array(2))

// PART 2: case classes: Articles and Bundles
// A store sells items. Some are articles. Others are bundles of articles - stuff that you buy together for a discount
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item

// a: article of book
val book = Article("Scala for the Impatient", 39.95)

// b: declare a bundle, sold at a $10 discount: the book from a and a bottle of whisky
val gift = Bundle("xmas special", 10, book, Article("Old Potrero Straight Rye Whiskey", 79.96))

// c: compute the price of an item
def price(it: Item): Double = it match {
  case Article(_, p) => p
  case Bundle(_, disc, its @ _*) => its.map(price).sum - disc
}
price(book)
price(gift)

// f: write a one-line assigment that extracts the description and price of the first article
val special =
  Bundle("Father's day special", 20.0,
    Article("Scala for the Impatient", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.96),
      Article("Junipero Gin", 32.95)))

val Bundle(_, _, Article(descr, pr), _* ) = special


// PART 3: Option Type
// a: reimplement Option type for Double values: provide classes DoubleOption, SomeDouble and NoDouble
abstract class DoubleOption
case class SomeDouble(value: Double) extends DoubleOption
case object NoDouble extends DoubleOption

// b: write a function 'inv' that maps 'x' into its inverse (1/x) returning a DoubleOption.
// Return NoDouble when 'x' id 0.
def inv(x: Double) = if ( x == 0 ) NoDouble else SomeDouble( 1/x )
inv(5)
inv(0)

// c: write a function that composes two functions of type Double => DoubleOption, yielding another function of the same type.
// The composition should yield NoDouble if either function does
import scala.math._
def f(x: Double) = if ( x <= 1) SomeDouble(sqrt( 1 - x)) else NoDouble

def compose(f: Double => DoubleOption, g: Double => DoubleOption) =
  (x: Double) => g(x) match {
    case SomeDouble(result) => f(result)
    case NoDouble => NoDouble
  }
val h = compose(f, inv)
h(0)
h(1)
h(2)  // output: g(x) => 1 / 2 = 0.5, f(g(x)) = f(0.5) = sqrt (1-0.5) = 0.7071067811
h(0.5) // output: g(x) => 1 / 0.5 = 2, f(g(x)) = f(2) = sqrt (1-2) = NoDouble

// d: define a method isEmpty that returns true for NoDouble and false for SomeDouble
def isEmpty(opt: DoubleOption) = opt match {
  case NoDouble => true
  case _ => false
}

// e: defile a method get that return a NoSuchElementException is noDouble, and value if SomeDouble
def get(opt: DoubleOption) = opt match {
  case NoDouble => throw new NoSuchElementException
  case SomeDouble(value) => value
}


// f: write all above using class polymorphism
abstract class DoubleOption2 {
  def isEmpty: Boolean
  def get: Double
}
class SomeDouble2(val value: Double) extends DoubleOption2 {
  def isEmpty = false
  def get = value
}
object NoDouble2 extends DoubleOption2 {
  def isEmpty = true
  def get = throw new NoSuchElementException
}

