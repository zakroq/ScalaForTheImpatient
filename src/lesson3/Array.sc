// ARRAYS - is a Java array (int[], java.lang.String[])
val nums = new Array[Int](10) // all 10 elements initialized with 0
for (a <- nums) print(a) // traverses the array elements
for (i <- 0 until nums.length) { print(i); nums(i) = i * i} // traverses the array indexes and fill the array
nums

val strings = Array("Hello", "World") // without 'new' - type is inferred
strings(1)

// ARRAY BUFFER - analog for Java ArrayList/C++ vector
import scala.collection.mutable.ArrayBuffer
val buffer = new ArrayBuffer[Int]()
buffer += 1
buffer += (2,3,5)
buffer ++= Array(8, 13, 21)
buffer.insert(1, 6, 10)
buffer
buffer.remove(0)
buffer
buffer.trimEnd(4)
buffer

// conversion between buffers and arrays
val a = buffer.toArray
val b = nums.toBuffer

// transforming arrays - result a new array, not mutate the old
val array = Array(2, 3, 5, 7, 11)
val result = for (elem <- array if elem %2 != 0) yield 2 * elem

// common algorithms
Array(1,7,2,9).sum
ArrayBuffer("Mary", "had", "a", "little", "lamb").max
ArrayBuffer(1,7,2,9).sorted
ArrayBuffer(1,7,2,9).reverse

nums.toString
nums.mkString(" | ")
strings.toString
strings.mkString(" | ")
buffer.toString
buffer.mkString(" | ")

