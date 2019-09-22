// PART 1
class Time(val hours: Int, val minutes: Int) {
  def this(h: Int) { this(h, 0) } // auxiliary constructor
  if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60)  throw new IllegalArgumentException // arbitrary code executed when object is created
  def before(other: Time): Boolean = hours < other.hours || hours == other.hours && minutes < other.minutes
  override def toString: String = f"${hours}:${minutes}%02d"
}

val morning = new Time(9, 0)
//val crazy = new Time(-3, 222) // IllegalArgumentException
val afternoon = new Time(16, 30)
morning.before(afternoon)
afternoon.before(morning)
val noon = new Time(12) // using auxiliary constructor


class Time2(val hours: Int = 0, var minutes: Int = 0) {
  override def toString: String = f"${hours}:${minutes}%02d"
}
val midnight = new Time2() // using defaulted values
midnight.minutes = 30 // mutate the field minutes
midnight



// PART 2 - uniform access
class Time3(h: Int, m: Int = 0) { // not a class fields, just a parameters to construct the class
  private var minutesSinceMidnight = h * 60 + m
  def hours = minutesSinceMidnight / 60
  def minutes = minutesSinceMidnight % 60
  def minutes_=(newValue: Int) {
    if (newValue < 0 || newValue >= 60) throw new IllegalArgumentException
    minutesSinceMidnight = hours * 60 + newValue
  }
  if (h < 0 || h >= 24 || m < 0 || m >= 60)  throw new IllegalArgumentException
  def before(other: Time3): Boolean = minutesSinceMidnight < other.minutesSinceMidnight
  override def toString: String = f"${hours}:${minutes}%02d"
}
val morning2 = new Time3(9, 0)
val afternoon2 = new Time3(16, 30)
morning2.before(afternoon2)
afternoon2.before(morning2)
val noon2 = new Time3(12)
noon2.hours
noon2.minutes = 30 // call the method minutes_ - LOL
noon2
// noon2.minutes = -999 // IllegalArgumentException



// PART 3 - operators
class Time4(val hours: Int, val minutes: Int) {
  def this(h: Int) { this(h, 0) }
  if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60)  throw new IllegalArgumentException
  def -(other: Time4) = hours * 60 + minutes - other.hours * 60 - other.minutes
  def <(other: Time4): Boolean = this - other < 0
  override def toString: String = f"${hours}:${minutes}%02d"
}
object Time4 {
  def apply(h: Int, m: Int) = new Time4(h, m)
}
Time4(9, 0) - Time4(12, 30)
Time4(9, 0) < Time4(12, 30)
