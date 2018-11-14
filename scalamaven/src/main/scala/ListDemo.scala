object ListDemo {
  /*
  作业：

  1.去重List("a", "b", "c", "d", "d")
  2.按字典序排序List("hello", "word", "world")
  3.A:List(1,2,3) B:List(2,3) 求出两个集合交集 并集 A对B的补集

   */

  def testCreate(): Unit = {
    val l1 = List(1, 2, 3, 4)
    val l2 = List.apply(1, 2, 3, 4)
    //val l2=
    println(l1)
    println(l2)

    val l3: List[String] = List("a", "b", "c", "d")
    val l4: List[Any] = List("a", "b", 1, "d")


  }

  def testForeach(): Unit = {
    val l1 = List(1, 2, 3, 4)
    l1.foreach(println)

    val p = (x: Int) => println(x)

    l1.foreach(x => println(x))

    l1.foreach(p)

    l1.foreach(println(_))

  }

  def testMap(): Unit = {
    val l1 = List(1, 2, 3, 4)
    val l2 = l1.map(x => x + 1)
    val l3 = l1.map(x => x * 2)

    println(l1)
    println(l2)
    println(l3)

  }

  def testReduce(): Unit = {
    val l1 = List(1, 2, 3, 4)

    println(l1.reduce((x, y) => x + y))
    println(l1.reduce((x, y) => x * y))
    println(l1.reduce(_ + _))
    println(l1.reduce(_ * _))
    //println(l1.reduce(_^_))
  }

  def testMapReduce(): Unit = {
    val l1 = List(1, 2, 3, 4)
    println(l1.map(x => x + 1).reduce(_ + _))
  }

  def testPut(): Unit = {
    val l1 = List(1, 2, 3, 4)
    val l11 = List(1, 2, 3, 4)

    val l2 = 5 :: l1

    val l3 = l1 ::: (5 :: Nil)
    println(l2)
    println(l3)
    println(l1 ::: l11)
  }

  def testFilter(): Unit = {
    val l1 = List(1, 2, 3, 4)
    l1.filter(x => x % 2 == 0).foreach(println)
    l1.filter(x => x % 2 != 0).foreach(println)
    l1.filter(x => x > 3).foreach(println)
    l1.filter(x => x > 1 && x < 3).foreach(println)
    val l2 = List("hello", "hi", "world")
    println(l2.filter(x => x.startsWith("h")).map(x => 1).reduce(_ + _))
  }

  def testOtherApi(): Unit = {
    val l1 = List(1, 2, 3, 4,5, 3, 1, 5)
    /*val l2=List(List(1,2),List(3))
    val l3=l2.flatten
    println(l3)
    println(l1.head)
    println(l1.tail)*/
    //println(sort(l1))
    println(quickSort(l1))
    println(sum(l1))


    //println(getMax(l1))

  }


  def main(args: Array[String]): Unit = {
    //testCreate()
    //testForeach()
    //testMap()
    //testReduce()
    //testMapReduce()
    //testPut()
    //testFilter()
    testOtherApi()

  }

  // 1 2 4 4
  def getMax(list: List[Int]): Int = {
    if (list.size == 1) {
      list.head
    }
    else {
      val left = list.filter(x => x > list.head)
      //println(left.size)
      if (left.size == 0) list.head else getMax(left)
    }
  }

  //1 1 2
  def sort(list: List[Int]): List[Int] = {

    if (list.size == 1) list
    if (list.size == 0) Nil
    else {
      val max = getMax(list)
      sort(list.filter(x => x < max)) ::: (list.filter(x => x == max))
    }
  }

  def quickSort(list: List[Int]): List[Int] = {
    if (list.size == 1) list
    if (list.size == 0) Nil
    else
      quickSort(list.filter(x => x < list.head)) ::: list.filter(x => x == list.head) ::: quickSort(list.filter(x => x > list.head))
  }
  def sum(list: List[Int]): Int = {
    if (list.size==1) list.head else list.head+sum(list.tail)
  }
}