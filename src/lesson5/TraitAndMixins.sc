// TRAITS - superficially similar to Java interface
// class can extends multiple traits
// traits can have concrete methods (like Java 8 default methods)
// traits can have abstract fields (a concrete implementing class must supply them)
// traits can have concrete fields (concrete trait fields are added to the implementing class)
// traits cannot have construction parameters (technically, this is the only difference between classes and traits)

trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) = println(msg)
}

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {
  val maxLength = 15
  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "...")
  }
}

class SavingsAccount extends Logged {
  private var balance: Double = 0
  def withdraw(amount: Double) = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

val acct = new SavingsAccount with ConsoleLogger //mixins
acct.withdraw(1000)

// trait layers
val acct_short = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger
acct_short.withdraw(1000) //call with reverse order: 1. ShortLogger, than TimestampLogger and then ConsoleLogger
//output: Sun Sep 22 15:31:01 CEST 2019 Insufficient...

val acct_long = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger {
  override val maxLength: Int = 20 //override the maxLength
}
acct_long.withdraw(1000)
//output: Sun Sep 22 15:34:25 CEST 2019 Insufficient funds


// EXERCISE PART 2
val acct2 = new SavingsAccount with ConsoleLogger with ShortLogger with TimestampLogger {
  override val maxLength: Int = 30 // 1. TimestampLogger, 2. ShortLogger, 3. ConsoleLogger
}
acct2.withdraw(1000)
//output: Sun Sep 22 15:45:16 CEST 20...

val acct3 = new SavingsAccount with ShortLogger with TimestampLogger with ConsoleLogger
acct3.withdraw(1000) // 1. ConsoleLogger
//output: Insufficient funds
