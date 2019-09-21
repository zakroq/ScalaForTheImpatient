// EXERCISE
import scala.collection.mutable.ArrayBuffer

// PART 1
// a
val buf = ArrayBuffer(1, 2, -3, 4, -5, 6, -7, 8)
def removeAllNegativeExceptFirst(b: ArrayBuffer[Int]) {
  var first = true
  var i = 0
  while (i < b.length) {
    if (b(i) < 0) {
      if (first) {
        first = false
        i += 1
      }
      else
        b.remove(i)
    }
    else i += 1
  }
}
removeAllNegativeExceptFirst(buf)
buf

// b
val buf2 = ArrayBuffer(1, 2, -3, 4, -5, 6, -7, 8)
def removeAllButFirstNegative(buf: ArrayBuffer[Int]) {
  val indexes = for (i <- 0 until buf2.length if buf2(i) < 0) yield i // indexes of negative values
  val indexesToRemove = indexes.drop(1)
  for (i <- indexesToRemove.reverse) buf2.remove(i) // remove from the last index
}
removeAllButFirstNegative(buf2)
buf2

val buf3 = ArrayBuffer(1, 2, -3, 4, -5, 6, -7, 8)
def removeAllButFirstNegativeAndReturn(buf: ArrayBuffer[Int]) = {
  val indexes = for (i <- 0 until buf2.length if buf2(i) < 0) yield i // indexes of negative values
  val indexesToRemove = indexes.drop(1)
  for (i <- 0 until buf.length if !indexesToRemove.contains(i)) yield buf(i)
}
val buf4 = removeAllButFirstNegativeAndReturn(buf3)
buf3

// PART 2
// a

/* help to get to the file
import java.io.File
def getListOfFiles(dir: String):List[File] = {
  val d = new File(dir)
  if (d.exists && d.isDirectory) {
    d.listFiles.filter(_.isFile).toList
  } else {
    List[File]()
  }
}
val files = getListOfFiles("/GIT/ScalaForTheImpatient/resources")
*/

// mutable map
val file = scala.io.Source.fromFile("/GIT/ScalaForTheImpatient/resources/alice30.txt").mkString.split(" ").toIterator
val count = scala.collection.mutable.Map[String, Int]()
while (file.hasNext) {
  val word = file.next()
  count(word) = count.getOrElse(word, 0) + 1
}
count("Alice")
count("Rabbit")

// b - immutable map
val file2 = scala.io.Source.fromFile("/GIT/ScalaForTheImpatient/resources/alice30.txt").mkString.split(" ").toIterator
var count2 = Map[String, Int]()
while (file2.hasNext) {
  val word = file2.next()
  count2 = count2 + (word -> (count2.getOrElse(word, 0) + 1))
}
count2("Alice")
count2("Rabbit")

// PART 3 - Grouping
val words = Array("Mary", "had", "a", "little", "lamb", "its", "fleece", "was", "white", "as",
  "snow", "and", "everywhere", "that", "Mary", "went", "the", "lamb", "was", "sure", "to", "go")
// a
words.groupBy(_.substring(0, 1))

// b
words.groupBy(_.length)

// PART 4 Partitions and Zips - Tuples
// a
"New York".partition(_.isUpper) // returns (String, String): first with "NY" (upper case letters), second with "ew ork" (lower case)

// b
val buf5 = ArrayBuffer(1, 2, -3, 4, -5, 6, -7, 8)
val (neg, pos) = buf5.partition(_ < 0)
val result = pos
result += neg(0)
result

// c
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

// d
for ((s, n) <- pairs) print(s * n)


