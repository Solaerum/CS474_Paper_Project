package Theory_Part_2

import scala.collection.mutable

/**
  * Contains solutions for part 3
  */
object problem_3{
  
    /**
      * Outputs string for part 3
      *
      * @param regexIn Input regex
      * @return Size of regex,NFA,DFA,minDFA
      */
    def Compare(regexIn: String): String = {

        val regex_to_process = new dk.brics.automaton.RegExp(regexIn)
        val outString = new mutable.StringBuilder("")
        val Nfa = regex_to_process.toAutomaton(false)
        
        //Adds length of regex
        outString ++= "Your regex has size: " + regexIn.length().toString() + "\n"
        //Adds size NFA
        outString ++= "The resultant NFA has size: " + Nfa.getNumberOfStates() + "\n"
        //Adds size DFA
        Nfa.determinize()
        outString ++= "The resultant DFA has size: " + Nfa.getNumberOfStates() + "\n"
        //Adds size min DFA
        Nfa.minimize()
        outString ++= "The resultant Minimizeded DFA has size: " + Nfa.getNumberOfStates() + "\n"

        //Returns the string
        outString.toString
    }


}
