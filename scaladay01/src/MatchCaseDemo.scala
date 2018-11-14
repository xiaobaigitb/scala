
/*
  * @Title: MatchCaseDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:16:24
  */
object MatchCaseDemo {

  //定义隐士参数
  implicit val name="tom"
  //定义隐士函数
  implicit def stringToInt(string: String)=string.toInt
  //自定义模式类
  case class Dog(name:String,age:Int)

  def myPrint(any: Any)={
    any match{
      case 1=>println("this is num "+any)
      case string:String=>println("this is string "+any)
      case int:Int=>println("this is int "+any)
      case Dog("luck",12)=>new Student().run
      case Dog("jack",12)=>new Student().run("jack")
      case Dog(name,age)=>new Student().sing()
      case _=>println("default")
    }
  }

  class Student{
    def sing(): Unit ={
      println("hahahahha")
    }
  }
  //隐士类
    implicit class RichStudent(student: Student){
      def run(implicit name: String): Unit ={
        println(name+" is running")
      }
    }
  def main(args: Array[String]): Unit = {
    myPrint(1)
    myPrint("100"/2)
    myPrint("tom")
    myPrint(new Dog("luck",12))
    myPrint(new Dog("jack",12))
    myPrint(new Dog("luck",123))
    myPrint(new Student())
    val b=List("1","2")
    val a = List("1")
    val c=a++b
    val d="100"+100
    println(c)
    println(d)

  }
}
