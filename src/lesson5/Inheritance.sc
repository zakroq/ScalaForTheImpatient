class Person(name: String, age: Int) {
}
class Employee(name: String, age: Int, val salary: Double) extends Person(name, age) {
}

class Manager(name: String, age: Int, salary: Double, val department: String)
  extends Employee(name, age, salary) {
}

val e = new Employee("", 0, 0)
val m = new Manager("", 0, 0, "")
e.isInstanceOf[Manager] // like 'e instanceof Manager'
m.asInstanceOf[Employee] //like (Employee) m
e.getClass == classOf[Manager] // like Manager.class
m.getClass == classOf[Manager] // like Employee.class
