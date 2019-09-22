// PART 1
import java.awt._
val r = new Rectangle(5, 10, 20, 30)
r.translate(10, 20)
r

import java.awt.geom._

trait RectangleLike {
  def setFrame(x: Double, y: Double, w: Double, h: Double)
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def translate(dx: Double, dy: Double): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
  override def toString = f"(${getX}, ${getY})"
}

val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.translate(10, 20)
egg


// PART 2
//in TraitAndMixins

// PART 3 - Buffering
trait Log {
  def log(msg: String) {}
}

trait ConsoleLog extends Log {
  override def log(msg: String) = println(msg)
}

import java.io._
trait Buffered extends InputStream with Log {
  val SIZE = 2014
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {
      log("Buffer was empty")
      end = super.read(buffer, 0, SIZE)
      pos = 0
    }
    if (pos == end) -1
    else {
      pos += 1
      buffer(pos - 1)
    }
  }
}
val myStream = new FileInputStream("/GIT/ScalaForTheImpatient/resources/alice30.txt") with Buffered with ConsoleLog
myStream.read()
myStream.read()
myStream.read()
myStream.read()
myStream.read()
