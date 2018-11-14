/*
  * @Title: TraitDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/14:9:31
  */
/**
  * scala的特质（trait）
  */
object TraitDemo {

  trait play{
    def basketball
    def football(): Unit ={
      println("play football")
    }
  }

  trait sing{
    def sing
  }

  /**
    * 单实现用extends
    */
  class Dog extends sing {
    override def sing: Unit = {
      println("wang wang wang")
    }
  }

  /**
    * 多继承，先使用extends后面的使用with
    */
  class Pig extends sing with play{
    override def sing: Unit = {
      println("heng heng heng")
    }

    override def basketball: Unit = {
      println("play basketball")
    }
  }

  def main(args: Array[String]): Unit = {
    new Dog().sing
    new Pig().basketball
    new Pig().sing
    new Pig().football()
  }

}
