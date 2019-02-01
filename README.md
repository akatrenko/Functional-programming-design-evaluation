# Functional-programming-design-evaluation

# Exercise 1. Bloxorz.
The objective of Bloxorz is simple; you must navigate your rectangular block to the hole at the end of the board, by rolling it, in the fewest number of moves possible. A block can be moved in 4 possible directions, left, right, up, down, using the appropriate keys on the keyboard.

You will implement a solver for a simplified version of a Flash game named “Bloxorz” using streams and lazy evaluation..

# Exercise 2. Quickcheck.
You’re given several implementations of a purely functional data structure: a heap, which is a priority queue supporting operations insert, meld, findMin, deleteMin. All these operations are pure; they never modify the given heaps, and may return new heaps. This purely functional interface is taken from Brodal & Okasaki’s paper.

You should write your properties in the body of the QuickCheckHeap class in the file src/main/scala/quickcheck/QuickCheck.scala.

# Exercise 3. Calculator.
As you probably know, Tweets (messages on Twitter) are limited to 140 characters. When typing a Tweet, it is very helpful to receive instantaneous visual feedback on the number of characters you have left. In this calculator, cells can depend on the value of other cells, and are recomputed automatically when the latter change.
