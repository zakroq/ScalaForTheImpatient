class Point(val x: Double, val y: Double) { // immutable class: x, y cannot be changed
  def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)
  def distanceFromOrigin = math.sqrt(x * x + y * y)
  override def toString = f"(${x}, ${y})" // override needed when overriding methods (Object.toString), string interpolation
}

val p = new Point(3, 4)
p.distanceFromOrigin
p.x
p.y

val pbis = p.move(10, 20)
p.x
p.y
pbis.x
pbis.y

class Point2(var x: Double, var y: Double) { // mutable class: x, y can be changed
  def move(dx: Double, dy: Double) = {x = x + dx; y = y + dy} // modify the x and y
  def distanceFromOrigin = math.sqrt(x * x + y * y)
  override def toString = f"(${x}, ${y})" // override needed when overriding methods (Object.toString), string interpolation
}

val p2 = new Point2(3, 4)
p2.move(10,20)
p2.x
p2.y
p2.x = 3
p2.y = 4

// constructors
class Point3(val x: Double, val y: Double) { // primary constructor
  def this() { this(0,0) } // auxiliary constructor
}
val p3 = new Point3()
p3.x
p3.y

class Point4(val x: Double = 0, val y: Double = 0) { // primary constructor with defaulted
  println(f"Welcome to (${x}, ${y})") // arbitrary code - part of primary constructor
}
val p4 = new Point4()
p4.x
p4.y

// methods
1 to 10 map (3 * _) filter (_ % 5 == 2) // infix notation
1.to(10).map(3 * _).filter(_ % 5 == 2) // dot notation

class Point5(val x: Double, val y: Double) {
  def ***(factor: Double) = new Point5(x * factor, y * factor)
  def apply(factor: Double) = new  Point5(x * factor * factor, y * factor * factor)
}
val p5 = new Point5(3, 4)
val p5bis = p5 *** 2 // infix notation
p5bis.x
p5bis.y
val p5bis2 = p5(2) // call apply method
p5bis2.x
p5bis2.y
