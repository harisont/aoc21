# Advent of Code 2021
My solutions to the Advent of code 2021 puzzles. 

I am taking part in AoC with a strictly non-competitive spirit, mostly to learn writing Kotlin without Android Studio's autocompletion.

## Usage
Move into the `src` directory and compile with

```
kotlinc Day*.kt Main.kt -include-runtime -d aoc21.jar
```

Then run with

```
java -jar aoc21.jar
```

This will show the solutions of all the puzzles solved so far.

Alternative, pass the days corresponding to the specific puzzles you want to solve as command line arguments:

```
java -jar aoc21.jar 1 5 30 03
```

This will solve, in this order, puzzle 1, 5 and 3 (skipping 30 as it's not a valid advent day).

## Lessons learned
Here is a nonexhaustive list of the things I "had to"[¹](#notes) look up and learn, in no particular order:

- [`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/), the Kotlin counterpart of Java `Object`s
- how to [generalize `transpose`](https://stackoverflow.com/questions/70230712/generic-transpose-or-anything-else-really-in-kotlin/70230823#70230823) (or anything else that has something to do with arrays really)
- how [mutable lists](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/) work and that it is not wise to loop over them with an iterator and modify their elements. C-style for loops for the win!
- [if expressions](https://discuss.kotlinlang.org/t/ternary-operator/2116/3) (aka verbose ternary operator)
- how to use [`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/)s, even though there's not much to learn 'cause they're kinda like Haskell's
- [`Single-expression functions`](https://kotlinlang.org/docs/functions.html#single-expression-functions) because sometimes I miss Haskell
- [lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) (I already knew about this but the lambdas' docs are always worth re-reading, especially the part on the [`it` parameter](https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter))
- that `toInt()` applied to a `Char` returns its code, instead of parsing them as if it was a string, so 
  ```kotlin
  '1'.toString().toInt()
  ``` 
  is the way to go.
- the Java [`ArrayDeque`](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html) class
- [extension functions](https://kotlinlang.org/docs/extensions.html#extension-functions)
- [collection grouping](https://kotlinlang.org/docs/collection-grouping.html)

#### Notes
¹ Well, more often than not they were completely unnecessary but hey, I'm doing this to improve my Kotlin skills!