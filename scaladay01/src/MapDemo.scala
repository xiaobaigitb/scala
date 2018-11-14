/*
  * @Title: MapDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:12:51
  */
object MapDemo {

  def test1(): Unit = {
    val map = Map("henan"->"zhengzhou","hebei"->"shijiazhuang","sichuan"->"chengdu")
    map.foreach(println)
    map.get("henan").foreach(println)
    map.keySet.foreach(println)
    map.keys.foreach(println)
    //map.reduce((kv1,kv2)=>kv1._1+kv2._1)
    map.map(kv=>(kv._1,1)).foreach(println)

  }

  /**
    * wordCount
    */
  def test2(): Unit = {
    val list=List("h","a","h","a","b")
    val tmp =list.map(word=>(word,1))
    //tmp.foreach(println)--(h,1)(a,1)
    //将tmp进行分组--指定key的值，将key相等的value值放在一个集合中
    tmp.groupBy((kv=>kv._1))//.foreach(println)  (h,List((h,1), (h,1)))
    list.groupBy(x=>x)//.foreach(println) (h,List(h, h))
      .map(kv=>(kv._1,kv._2.size)).foreach(println)
  }

  /**
    * 练习：
    * 建立倒排索引
    * val docs=Map("doc1"->List("hello","hehe"),"doc2"->List("hello","hi"))
    * 要求结果：
    * Map("hello"->List("doc1","doc2"),"hi"->List("doc1"),"hehe"->List("doc2"))
    */
  def test3(): Unit = {
    val docs=Map("doc1"->List("hello","hehe"),"doc2"->List("hello","hi"))
    docs.map(kv=>kv._2.map(word=>(word,kv._1))).flatten
      .groupBy(kv=>kv._1).map(kv=>(kv._1,kv._2.map(xy=>xy._2))).foreach(println)

    val tmp = docs.map(kv=>(kv._2,kv._1))//.foreach(println)
    //val words=tmp.keySet
    //将之转化成一个单词--文章
    val fileName = tmp.map(kv=>kv._1.map(word=>(word,kv._2))).flatten //.foreach(println)
        .groupBy(kv=>kv._1).map(kv=>(kv._1,kv._2.map(ab=>ab._2)))
    fileName.foreach(println)
    //fileName.reduce((kv1,kv2)=>kv1._2+""+kv2._2).foreach(println)
  }

  def test4(): Unit = {
    val docs=Map("doc1"->List("hello","hehe"),"doc2"->List("hello","hi"))
    val tmp = docs.map(kv=>kv._2.map(x=>(x,kv._1)))
    print(tmp)
  }

  /**
    * /**
    * * 练习：
    * * 建立倒排索引
    * * val docs=Map("doc1"->List("hello","hehe"),"doc2"->List("hello","hi"))
    * * 要求结果：
    * * Map("hello"->List("doc1","doc2"),"hi"->List("doc1"),"hehe"->List("doc2"))
    **/
    */
  def test5(): Unit = {
    val docs=Map("doc1"->List("hello","hehe"),"doc2"->List("hello","hi"))
    val tmp=docs.map(kv=>kv._2.map(x=>(x,kv._1))).flatten.groupBy(kv=>kv._1)
        .map(kv=>(kv._1,kv._2.map(xb=>xb._2)))
    println(tmp)
  }

  def main(args: Array[String]): Unit = {
    //test1()
    //test2()
    //test3()
    //test4()
    test5()
  }
}
