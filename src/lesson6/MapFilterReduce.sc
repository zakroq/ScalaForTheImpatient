// 'map' applies a function to each element of a sequence
(1 to 9).map(0.1 * _) // output: 0.1, 0.2, ..., 0.9

// 'filter' retains the elements that fulfill a predicate
(1 to 9).filter(_ % 2 == 0) // output: 2, 4, 6, 8

// 'reduceLeft' applied a binary function, going from left to right
// 'reduceLeft' takes 2 parameters
(1 to 9).reduceLeft(_ * _) // (...((1 * 2) * 3) * ... * 9)
(1 to 9).reduceRight(_ + _) // (...((9 + 8) + 7) + ... + 1)

(1 to 9).filter(_ % 2 == 0).map(0.1 * _)
for (n <- 1 to 9 if n % 2 == 0) yield 0.1 * n

// can model a sequence of statements as a function with no parameters
// then provide "control abstraction" that manipulate that function
// example: run some statement in a separate thread
def runInThread(block: () => Unit) {
  new Thread {
    override def run() { block() }
  }.start()
}
runInThread { () =>
  println("Hi"); Thread.sleep(1000); println("Bye")
}

// avoid the unsightly () => in the call with "call by name" notation
def runInThread2(block: => Unit) {
  new Thread {
    override def run() { block }
  }.start()
}
runInThread2 { println("Hi2"); Thread.sleep(1000); println("Bye") }
println("End")
