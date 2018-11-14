/*
  * @Title: ImplicitDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:15:47
  */
object ImplicitDemo {

  /**
    * 隐式函数
    * @param dog
    * @return
    */
  implicit def dogToString(dog : Dog)="hdfdfkj"

  implicit def stringToInt(string:String)=string.toInt

  implicit val name="sgfx"

  def main(args: Array[String]): Unit = {
    new Dog().sing
    new Dog().singOpera
    new Dog().sayHi
  }

  class Dog{
    def sing: Unit={
      print("erg")
    }
    def sayHi(implicit name:String):Unit={
      print("hello:"+name)
    }
  }

  /**
    * 隐式类+参数中是类名(扩展方法的类名)
    * @param dog
    */
  implicit class RichDog(dog:Dog){
    def singOpera: Unit={
      print("sgrsvf")
    }
  }

}
