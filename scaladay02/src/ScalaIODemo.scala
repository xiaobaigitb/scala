import scala.io.Source

/*
  * @Title: ScalaIODemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/14:11:05
  */
object ScalaIODemo {
  def main(args: Array[String]): Unit = {
    val c1=Source.fromFile("").mkString
    val c2=Source.fromURL("").mkString

    println(c1)
    println(c2)


  }
}
