import dk.brics._

object Theory_Part_2 extends App{

  def Problem_1(regex: String): Int = { 
  val regGuy = new dk.brics.automaton.RegExp("ab(c|d)*")

  val tryAutomotan = regGuy.toAutomaton()

  val stringOut = tryAutomotan.getNumberOfStates()

  return stringOut
  }
  
  println(Problem_1)

}

/*
RegExp r = new RegExp("ab(c|d)*");
Automaton a = r.toAutomaton();
String s = "abcccdc";
System.out.println("Match: " + a.run(s)); // prints: true

*/