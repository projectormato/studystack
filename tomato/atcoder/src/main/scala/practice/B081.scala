package practice

object B081{
  def main(args: Array[String]){
    if (sys.env.getOrElse("TEST", "")=="1"){
      println(test())
    }else{
      val input=io.Source.stdin.getLines().mkString("\n")
      println(solve(input).trim())
    }
  }

  def solve(input:String):String={
    val blackNums = input.split("\n")(1).split(" ").map(_.toInt).toList
    shift(blackNums, 0).toString
  }

  def shift(list:List[Int],count:Int):Int= {
    if (list.forall(_ % 2 == 0)) {
      shift(list.map(_ / 2), count + 1)
    } else {
      count
    }
  }

  val tests=List(
    """
      |3
      |8 12 40
    """.stripMargin -> """2""",
    """
      |4
      |5 6 8 10
    """.stripMargin -> """0""",
    """
      |6
      |382253568 723152896 37802240 379425024 404894720 471526144
    """.stripMargin -> """8""")

  def test():String= {
    return tests.map{case (i,o)=>(i.trim(),o.trim())}
      .zipWithIndex.map{
      case ((input,outputExpect),i)=>{
        val output=solve(input).trim()
        s"test${i+1}:"+(if(output==outputExpect){
          "Passed"
        }else{
          s"Failed\nexpect:\n${outputExpect}\noutput:\n${output}"
        })
      }}
      .mkString("\n")
  }
}