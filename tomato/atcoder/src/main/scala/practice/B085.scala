package practice

object B085{
  def main(args: Array[String]){
    if (sys.env.getOrElse("TEST", "1")=="1"){
      println(test())
    }else{
      val input=io.Source.stdin.getLines().mkString("\n")
      println(solve(input).trim())
    }
  }

  def solve(input:String):String={
    input.split("\n").drop(1).toSet.size.toString()
  }


  val tests=List(
    """
      |3
      |15
      |15
      |15
    """.stripMargin-> """1""",
    """
      |7
      |50
      |30
      |50
      |100
      |50
      |80
      |30
    """.stripMargin -> """4""",
    """
      |4
      |10
      |8
      |8
      |6
    """.stripMargin -> """3""")

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