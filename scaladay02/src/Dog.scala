/*
  * @Title: Dog
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/14:10:01
  */
/**
  * 用于测试Java调用scala语法的类
  * 在scala中用object修饰的类，在Java中类中的属性和方法都是静态
  */
//将scala集合转化成Java集合
import scala.collection.JavaConverters._
object Dog {
  def main(args: Array[String]): Unit = {
      val docs=Map("docs1"->List("hello","henan"),"docs2"->List("hi","hello"))
      val tmp=docs.map(kv=>kv._2.map(x=>(x,kv._1))).flatten.groupBy(kv=>kv._1)
      .map(kv=>(kv._1,kv._2.map(xb=>xb._2)))//.asJava
    println(tmp)
  }

  def add(x:Int,y:Int)=x+y

  def sing: Unit ={
    println("wnag wang wang")
  }
}

class Dog{
  def play: Unit ={
    println("play ball")
  }
  def sum(f:(Int,Int)=>Int,num1:Int,num2:Int)=f(num1,num2)

  def wordcount: java.util.Map[String,Int] ={
    val list =List("a","b","a","c")
    //单词计数
    list.groupBy(x=>x).map(kv=>(kv._1,kv._2.size)).asJava
  }
  //倒排索引
  def repaisolr: Map[String,Iterable[String]] ={
      val docs=Map("docs1"->List("hello","henan"),"docs2"->List("hi","hello"))
       docs.map(kv=>kv._2.map(x=>(x,kv._1))).flatten.groupBy(kv=>kv._1)
      .map(kv=>(kv._1,kv._2.map(xb=>xb._2)))//.asJava
  }
}


