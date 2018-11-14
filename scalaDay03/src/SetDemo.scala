object SetDemo {

  def test1(): Unit = {
    val s1=Set(2,1,2,3)
    //s1.foreach(println)
    s1.map(x=>x+1)
    s1.filter(x=>x%2==0)
    s1.reduce(_+_)

  }

  def main(args: Array[String]): Unit = {
    test1()
  }

}
