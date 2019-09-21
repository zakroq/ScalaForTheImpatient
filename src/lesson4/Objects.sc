// use objects for singletons, static methods
object Accounts {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber} // Aside: use () since it mutates state!
}

Accounts
Accounts.newUniqueNumber()
Accounts.newUniqueNumber()


// companion Objects - like static methods, object name with the same name as class
class Point6(val x: Double, val y: Double) {
  def *(factor: Double) = new Point6(x * factor, y * factor)
  override def toString = f"(${x}, ${y})"
}

object Point6 {
  def apply(x: Double, y: Double): Point6 = new Point6(x, y)

}

val factor = 2
val p = Point6(3, 4) * factor // we create an object using static method apply from object Point and multiply by factor
p.x
p.y
