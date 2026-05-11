# README - OBJECTIVE

You need to design and implement a Java program with a simple window interface (buttons, text
boxes, etc.) that generates an encoded version of a user-provided string. The encoding process
will use a unique, hidden group-specific shift key embedded within the code. This ensuresthat the
encoded output is distinct and traceable to each student group, even for identical input strings.

# Class Requirements
class Encoded
- inputText:String
- charCount:int
- resultText:String
- groupID:String // Secret key embedded in code
+ Encoded()
+ Encoded(inputText: String)
+ countCharacters(inputText: String): int
+ checkStringValidity(inputText: String): boolean
+ generateShift(): int
+ applyCipher(inputText: String, shift: int): String
