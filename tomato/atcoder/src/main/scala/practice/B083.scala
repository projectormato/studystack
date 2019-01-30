package practice

object B083{
  def main(args: Array[String]){
    if (sys.env.getOrElse("TEST", "")=="1"){
      println(test())
    }else{
      val input=io.Source.stdin.getLines().mkString("\n")
      println(solve(input).trim())
    }
  }

  def solve(input:String):String={
    val List(n, a, b) = input.split(" ").map(_.toInt).toList
    val num = (1 to n).toList
    num.filter(
      _.toString
      .split("")
      .filter(_.length!=0)
      .map(_.toInt)
      .sum >= a
    ).filter(
      _.toString
      .split("")
      .filter(_.length!=0)
      .map(_.toInt)
      .sum <= b
    ).sum.toString
  }


  val tests=List("""20 2 5"""-> """84""",
    """10 1 2""" -> """13""",
    """100 4 16""" -> """4554""")

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