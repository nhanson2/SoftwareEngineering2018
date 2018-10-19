Reflection
10/19/2018

* For design patterns see file `Patterns.md` *

This programming assignment was certainly a fun and enjoyable endeavor into game design. As a very open-ended problem,
it invited a variety of responses to the challenge of implementing a video games from the 1990s in Java. The basic problem
of establishing a JavaFX window and adding `ImageViews` to it was not inherently difficult. For this assignment, I thought
the most difficult part was managing Java's lack of multiple inheritance. Although I appreciate how easy Java's inheritance
syntax is, there is no easy way to implement multiple inheritance. For example I wanted my ChipMan class to be both a
moving object, which I defined as an abstract base class and an observable object. I worked around this challenge by leaving
the ChipMan object as an observable object and programming to an interface for the methods I wanted. Overall, this challenge
was a useful exercise in debugging and utilizing an IDE more fully to assist with understanding where errors occur. Eclipse's
built-in suggestions to fix errors has been a life-saver and especially helped when I didn't know what package to include. 

My final solution revolves around a main class, `ChipsChallenge.java` which implements/overrides JavaFX methods to allow the
game to execute properly. Every level is a class that can override the methods of the base class `level.java`. Thinking of each
level as an object allows the level exhibit the composite pattern, as it has an instance of Chip, tokens, gates, jump pads, etc.
Another thing I am proud of is my game's ability to read in level files from a text file. This simple step made implementing
changes to the level design a relatively painless process. One thing I would certainly do if I were able to start this
project from the beginning would be start with a more limited scope.My initial concepts for the challenge were overly 
grandiose and were not realistic to implement/complicated the architecture I had already established. I would also take the Gate,
JumpPad, and Token classes and create a series of interface to reduce code reuse and allow for an architecture to easily add 
new game elements. Additionally, I would create a better system for enumerating the tile types and accessing them beyond the
object I already have to contain them.