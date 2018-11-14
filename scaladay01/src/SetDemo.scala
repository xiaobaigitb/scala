/*
  * @Title: SetDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:12:42
  */
/**
  * set集合与list集合的区别就是set集合不能存放重复的元素
  */
object SetDemo {

  def test1(): Unit = {
    val set = Set(1,2,4,6,7,4)
    set.groupBy(a=>set).foreach(println)
    //map就是分开做运算
    //set.map(x=>x+1).foreach(println)
    //reduce：就是做聚合
    set.reduce(_+_).toString.foreach(println)
    //val sum=set.reduce((a,b)=>a+b)
  }

  def main(args: Array[String]): Unit = {
    test1()
  }
}
