# Differences between Kotlin and Java

This document intends to show the various differences between the rather unknown programming language Kotlin, which is simply a kind of syntactic sugar for Java.
Kotlin is statically typed and runs on the JVM, which means it is possible to invoke normal Java Code and use it's ancestor's libraries, as I did in the assignment
with JUnit 4.

The biggest difference between these two languages is, that Kotlin is very explicit. In most languages there is a normal case for certain behaviours and then there are some
rarer exceptional cases. In Kotlin you mostly have to specify exactly what you mean to achieve in order to leave no room for interpretation.

Here is a list of some of the most notable differences in a distilled form.

### Kotlin advantages

- You have to be quite careful when working with possible null references. It is nearly impossible to get an unexpected `NullPointerException` as you have to hint the possibility of a null reference before you are even able to compile with `type?`.
- Kotlin has invariant arrays, this means you can not specify a generic container and later declare it as a container of child objects. This is introduced in order to enhance the type safety of the whole program.
- This language properly gives the programmer the possibility to use and expect functions in function parameters, which is quite helpful when implementing lambda functions. Kotlin has native support of lambda functions opposed to Java which implements them through various workarounds.
- Something rather strange for Java programmer is the complete abundance of checked exceptions. In a perfect world checked exceptions would be desired by every programmer, but in reality the exception handling often clutters the code and annoys the developer which in turn results in worse error handling.
- You are also able to extend classes by adding new functionality without writing your own class in order to inherit from the base class. This lets you easily expand simple collections with small methods which would require a tedious amount of work for a very small output in Java.
- Variables have to be explicitly set to read-only (`val`) or a mutable (`var`) state. The language maintainers use this as an advantage, whereas I see this as something visually disturbing and unusual. Implementing it the way C++ does it, by manually adding `const` would be much more convenient in my opinion.
- String formatting is supported out of the box, without any special method calls.
- In Kotlin everything is an object, even the simple data types like integer. All classes inherit from the class `Any` by default.
- Operator overloading is supported like in C++.
- Static class methods are not supported, but offered through a mechanism called companion objects.
- The Singleton Pattern is also quite easy to implement by using the `object` keyword instead of `class`. I honestly think it is a bad thing to make an Anti Pattern easily available, but if the code maintainers want it...
- Semicolons are optional which make the code quite pythonic.

As a conclusion the following can be said about Kotlin: It advances quite heavily in the direction of type safety even though I think this level of implementation hurts the coding flow more than it helps prevent errors. Nearly everything happens implicitly which means that errors mostly occur during the compilation or immediately at the beginning of the runtime, rather than later on.

All in all I have to say I do not particularly like Kotlin because it seems to solve some problems I never noticed encountering while hurting the readability of Java and shifting it into a C++-esque direction.
