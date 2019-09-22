import java.util.Date
val now = new Date // shortcut for new java.util.Date

import java.util._
import java.lang.Math._ // like import static in Java

import java.awt.{Color, Font} // import 2 classes
import java.util.{HashMap => JavaHashMap} // alias
import java.util.{HashMap => _, _} // hide a class HashMap (first '_' - make it invisible) but import everything else (second '_')

class Manage {
  import scala.collection.mutable._ // imports can be anywhere - only this class see this import
  val subordinates = new ArrayBuffer[Int]()
}


// java.lang, scala, Predef are always imported!

//App can be from com.horstmann.App or from scala.App
//import com.horstmann.App
import _root_.scala.App // use to disambiguate if packages have the same name

