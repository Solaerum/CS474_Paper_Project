//Import dk.bric
import dk.bric._


object Theory_Part_2 extends App{
   def Problem_1(regex: String): Int = {
   val regGuy = new dk.brics.automaton.RegExp("ab(c|d)*")
   val tryAutomotan = regGuy.toAutomaton()
   val stringOut = tryAutomotan.getNumberOfStates()
   return stringOut

}

  println(Problem_1)

  

}