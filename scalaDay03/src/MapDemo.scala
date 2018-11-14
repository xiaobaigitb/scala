object MapDemo {

  def test1(): Unit = {
    val m1=Map("henan"->"zhengzhou","hebei"->"shijiazhuang","sichuan"->"chengdu")
    m1.foreach(println)
    m1.keySet.foreach(println)
    m1.map(kv=>(kv._1,1)).foreach(println)
    //m1.map((k,v)=>(kv._1,1))
  }

  def test2(): Unit = {
    val l2=List("h","a","h","a","b")
    val tmp=l2.map(word=>(word,1))//("h"->1)
    tmp.foreach(println)
    tmp.groupBy(kv=>kv._1)
      //(("h",List("h"->1,"h"->1)....))
      .map(kv=>(kv._1,kv._2.map(kv=>kv._2).sum))
      .foreach(println)
    /*val l1=List(("h",1),("h",1))
    val l3=List(1,2)
    l3.reduce((v1,v2)=>v1+v2)
    l1.reduce((kv1,kv2)=>kv1._2+kv2._2)*/

    l2.groupBy(x=>x).map(kv=>(kv._1,kv._2.size)).foreach(println)

  }

  def main(args: Array[String]): Unit = {
    //test1()
    test2()
  }
}
