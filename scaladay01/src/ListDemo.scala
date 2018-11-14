///**
//  * @Title: ListDemo
//  * @ProjectName scalademo
//  * @Description: TODO
//  * @author Mr.lu
//  * @date 2018/11/13:11:16
//  */
/**
  * 1.去重List("a", "b", "c", "d", "d")
  *   2.按字典序排序List("hello", "word", "world")
  *   3.A:List(1,2,3) B:List(2,3) 求出两个集合交集 并集 A对B的补集
  */
object ListDemo {

  /**
    * 去重List.distinct
    * 如果方法中没有参数，可以将（）省略不写
    */
  def test1(): Unit = {
    //定义一个list集合
    val list=List("a", "b", "c", "d", "d")
    //使用listAPI进行去重
    list.distinct.foreach(println)
    //自定义方法去重
    distinct(list).foreach(println)
  }

  /**
    * 自定义去重方法
    * @param list
    * @return
    */
  def distinct(list: List[String]): List[String] = {
    //filter(),true--不过滤，false--过滤
    if (list.size<=1) list else distinct(list.filter(x=>x!=x.head))
  }

  /**
    * 2.按字典序排序List("hello", "word", "world")
    */
  def test2(): Unit = {
    val list = List("hello", "word", "world")
    //compareToIgnoreCase：表示忽略大小写
    list.sortWith((word1,word2)=>if (word1.compareToIgnoreCase(word2)<0) true else false).foreach(println)
    //自定义快速排序
    quickSort(list).foreach(println)
  }

  def quickSort(list: List[String]): List[String]={
    //取出头作为中间值，再比较小于中间的放在左边，最后大于的放在右边
    if (list.size<=1) list else quickSort(list.filter(x=>x.compareTo(list.head)<0)):::
      list.filter(x=>x.equals(list.head)):::quickSort(list.filter(x=>x.compareTo(list.head)>0))
  }

  /**
    * A:List(1,2,3) B:List(2,3) 求出两个集合交集 并集 A对B的补集
    */
  def test3(): Unit = {
    val a = List(1,2,3)
    val b = List(2,3)
    //求交集--api
    a.intersect(b).foreach(println)
    //使用包含关系求交集,将不包含的部分过滤掉
    a.filter(x=>b.contains(x)).foreach(println)

    //并集--所有元素
    //a的部分+a没有的部分
    //b.filter(x=>a.contains(x)==false).foreach(println)
    (a ::: b.filter(x=>a.contains(x)==false)).foreach(println)
    //a独有+ab公共+a没有
    val u=a.filter(x=>b.contains(x)==false):::a.filter(x=>b.contains(x)):::b.filter(x=>a.contains(x)==false)
    u.foreach(println)

    //补集--A对B的补集，A独有的部分
    a.filter(x=>b.contains(x)==false).foreach(println)
  }

  /**
    * 测试groupby:将集合变成一个map
    * 参数指定的是key,value就是一个list/set集合
    */
  def test4(): Unit = {
    val list =List(1,2,1,2,3)
    list.groupBy(a=>list).foreach(println)
    val tmp = list.map(x=>(x,x))//.foreach(println)
    print(tmp)
  }

  def main(args: Array[String]): Unit = {
    //test1()
    //test2()
    //test3()
    test4()
  }
}
