
/*
  * @Title: CaseClassDemo
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:16:11
  */
object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    case class Student(id:Int,name:String)
    val s1=new Student(1,"tom")
    s1.hashCode();
    s1.id;
    s1.name;
  }
}
