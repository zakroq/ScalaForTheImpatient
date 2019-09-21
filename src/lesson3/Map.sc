// MAPS - construct from key/value pairs
val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // immutable
val mscores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // mutable
"Alice" -> 10

val bobsScore = scores("Bob")
//val fredsScore = scores("Fred") // NoSuchElementException: key not found: "Fred"
val fredsScore = scores.getOrElse("Fred", 0)

// modify mutable map
mscores("Bob") = 20
mscores

// add new elements to map
mscores("Fred") = 20
mscores += ("Alex" -> 2, "Tom" -> 5)
mscores -= "Alice"

val newScores = scores + ("Alex" -> 2, "Tom" -> 5) // adding to immutable map creates a new map
scores
newScores

// iterating over maps
for ((k, v) <- scores)
  println(k + " has score " + v)

for ((k, v) <- scores) yield (v, k) // return a new map

for (k <- scores.keySet)
  println(k + " has score " + scores(k))

for (v <- scores.values)
  println(v + " is a key for ")

// TUPLES - aggregates values of different types, position start with 1
val t = (1, 3.14, "Fred")
val second_value  = t._2
val third_value = t._3
val first_value = t _1

// pattern matching
val (_, second, third) = t

// when a function return more than one result, it is worth to return them as a tuple


