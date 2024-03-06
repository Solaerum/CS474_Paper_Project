//Import dk.bric
/**
  * dk.brics.automaton library built for java. See the package link for more details https://www.brics.dk/automaton/doc/dk/brics/automaton/package-summary.html
  */
import dk.brics.automaton._

/**
  * Contains all of the problems, this may be remade into a containing class in the future
  */
object Theory_Part_2 extends App{
  
  //code for function which takes a regex (string) as an input, and outputs the conversion to DFA
  /**
    * Solution for problem one, this method translates a regex into an NFA into a DFA
    * 
    *
    * @param regex The regex as a string
    * 
    * @return DFA from the input regex that is not in minimal form
    * Has optional minimal form (remove comments on line DONT FORGET TO FILL THIS IN WITH THE LINE #!)
    * 
    */
  def Problem_1(regexIn: String): Automaton = {

// Instantiate Regex, built in method to translate strings to 
    val startingExpression = new dk.brics.automaton.RegExp(regexIn)

// Translate Regex to NFA
    val Nfa = startingExpression.toAutomaton()
    val determinism_check = Nfa.isDeterministic()
    
    var dfa_states = Nfa.getNumberOfStates()
    
    println("The new NFA has: " + dfa_states.toString() + " states")
    println("Is this this NFA already deterministic?" + determinism_check.toString())

// Translate NFA to DFA
    Nfa.determinize()

    dfa_states = Nfa.getNumberOfStates()

    println("Translating to DFA, we see it now has: " + dfa_states.toString() + " states")
    

// Optional mimimization
    Nfa.minimize()
    //println("The new DFA has: " + dfa_states.toString() + " states")

    return Nfa
    
  }
  
  println(Problem_1("a|b*"))
  println(Problem_1("a|b|ab|cb|a*"))
  println(Problem_1("ab|()|ba"))
  println(Problem_1("a|b*"))

}