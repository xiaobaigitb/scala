/*
  * @Title: DaoPai2
  * @ProjectName scalademo
  * @Description: TODO
  * @author Mr.lu
  * @date 2018/11/13:17:28
  */
object DaoPai2 {
  def main(args: Array[String]): Unit = {
    //在spark本地单节点运行配置
    val conf =new  SparkConf()
    conf.setAppName("DaoPai").setMaster("local")
    val sc = new SparkContext(conf)
    //wholeTextFile返回值是一个元组，第一个值是文件名，一个二个值是文件的内容
    val file = sc.wholeTextFiles("D:\\decstop\\sparkTest\\daopai")
    //将文章分割成（filename，（wordsArray））
    val fileTu = file.map(file =>(file._1,file._2.split(System.getProperty("line.separator")).flatMap(line=>line.split(" "))))
    //然后去重，然后转变成（word，fileName）
    val wordAndFileName = fileTu.flatMap(a=>a._2.distinct.map(word=>(word,a._1)) )
    //合并相同的word
    val result = wordAndFileName.reduceByKey(_+" "+_)
    //保存结果
    result.saveAsTextFile("D:\\decstop\\sparkTest\\result\\res4")
  }
}
