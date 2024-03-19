package Theory_Part_2

/**
  * dk.brics.automaton library built for java. See the package link for more details https://www.brics.dk/automaton/doc/dk/brics/automaton/package-summary.html
  */
import dk.brics.automaton._

/**
  * Contains all of the problems, this may be remade into a containing class in the future
  */
object Problem_1 extends App{
  
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
  def Regex_to_NFA_to_DFA(regexIn: String) = {

// Instantiate Regex, built in method to translate strings to 
    val startingExpression = new dk.brics.automaton.RegExp(regexIn)

// Translate Regex to NFA
    val Nfa = startingExpression.toAutomaton(false)
    var determinism_check = Nfa.isDeterministic()
    
    var dfa_states = Nfa.getNumberOfStates()
    
    println("The new NFA has: " + dfa_states.toString() + " states")
    println("Is this this NFA already deterministic?" + determinism_check.toString())

// Translate NFA to DFA
    Nfa.determinize()
    //Nfa.determinize(false)
    val Dfa = Nfa

    dfa_states = Dfa.getNumberOfStates()
    determinism_check = Dfa.isDeterministic()
    println("Translating to DFA, we see it now has: " + dfa_states.toString() + " states")
    println("Is this this DFA deterministic now?" + determinism_check.toString())

// Optional mimimization with default to hopcraft algorythm
    dk.brics.automaton.MinimizationOperations.minimizeHopcroft(Dfa)
    val minDFA = Dfa
    println("The new minimal DFA has: " + dfa_states.toString() + " states")

    
  }
  /**
    * Test Cases to try random regexes
    */
  /*println(Regex_to_NFA_to_DFA("a|b*"))
  println(Regex_to_NFA_to_DFA("a|b|ab|cb|a*"))
  println(Regex_to_NFA_to_DFA("a|"))

  println(Regex_to_NFA_to_DFA("(((aS?))|(O((aS?))C((U|:)(((aS?))|O((aS?)+)C))*)|(((aS?))((U|:)(((aS?))|O((aS?))C))*))+"))
*/
  //k = 1
  println(problem_3.Compare("e|OeC|(eU(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*)))|(OeCU(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*)))|(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*))"))
  println(problem_3.Compare("(aS?)|(O((aS?))C((U|:)(((aS?))|O((aS?))C))*)|(((aS?))((U|:)(((aS?))|O((aS?))C))*)"))
  println(problem_3.Compare("(aS?)|(O((aS?))C((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)|((aS?)((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)|(OO(aS?)CC((U|:)((aS?)|O(aS?)C)|OO(aS?)CC )*)"))

  //k = 2
  //k = 3
  //k = 4
  //k = 5

  //def Problem_2()
}
/*
A --> ((a|b)+S?)*

A(for a and b)--> (((a|b)S?)((U|:)((a|b)S?))*) has one extra outside set of parens 

𝑟0+|([𝑟0]((U|:)(𝑟0|[𝑟0]))*)|(𝑟0((U|:)(𝑟0|[𝑟0]))*)
one or more strings or one paren then optional OR no paren and optional

a+|([a]((U|:)(a|[a]))*)|(a((U|:)(a|[a]))*)
(aS?)
------------------- r1 high

((aS?))|(O((aS?))C((U|:)(((aS?))|O((aS?))C))*)|(((aS?))((U|:)(((aS?))|O((aS?))C))*) THIS IS JUST 'a' (has one extra outside parens)


k     regex length     nfa length    dfa length   min 
1      90                 7           16            5
2s     140                14           32           10
3s     190
4s     230
5s      250
k      96 + 50K         7+1^2           dasd        ada 


-----------------------r2  high
orig
e|[e]|(eU𝑟1)|([e]U𝑟1)|r0

sub with O and C
e|OeC|(eU𝑟1)|(OeCUa)|r1
k=2
e|OeC|(eU𝑟1)|(OeCUa)|r0|OeC


insert r0
e|OeC|(eU(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*)))|(OeCU(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*)))|(((aS?)+)|(O((aS?)+)C((U|:)(((aS?)+)|O((aS?)+)C))*)|(((aS?)+)((U|:)(((aS?)+)|O((aS?)+)C))*))


https://www.debuggex.com/#cheatsheet



one level (without e)
(aS?)|(O((aS?))C((U|:)(((aS?))|O((aS?))C))*)|(((aS?))((U|:)(((aS?))|O((aS?))C))*)
two level(withoute)     (aS)       U:      (a) or a *               (aS)       U:      (a) or a *             (O(aS?)C( (U|:)( (aS?)|O(aS?)C) | )* )        
(aS?)   |   (O((aS?))C((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)   |   ((aS?)((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)    |  (OO(aS?)CC( (U|:)( (aS?)|O(aS?)C) | OO(aS?)CC )* )
(aS?)|(O((aS?))C((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)|((aS?)((U|:)(((aS?))|O((aS?))C)| OO(aS?)CC )*)|(OO(aS?)CC((U|:)((aS?)|O(aS?)C)|OO(aS?)CC )*)


*/
