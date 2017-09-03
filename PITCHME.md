
## Functional programming with scala
### Why bother?

_Fotis Paschos, @fpaschos_


#HSLIDE
## Outline
 - Introduction.
 - Disclaimers.
 - 

#HSLIDE
## Introduction

#VSLIDE
### About me
 My name is Fotis Paschos.
 I live in Greece.
 
 I have been a full stack software engineer for the past 9 years.
 
 The project that i have been involved were about:
 - JVM back end stacks.
 - RDBMs and No SQL storage systems.
 - Frond end libraries like Angular, React etc.
 
 [LinkedIn]() |
 [Github]() |
 [Company]()
 
#VSLIDE
### Why am I here?

Because ever since I started developing production software I had a feeling that 
I am doing something wrong.

That I was lacking something that would help me to tame each problems complexity.

#VSLIDE
### Disclaimer
All the presented material, thoughts, opinions etc. are __subjective__. 
 
They reflect my __own__ strive and __learning path__ towards means __to implement better software__.
 
My goal is to share my findings and discuss about them.
 
#### This presentation is ONLY about designing and implementing better software  AND NOTHING MORE.  
 

#VSLIDE
### Special thanks

#HSLIDE
### Some critical questions.
 - Why functional programming?
 - Why functional programming today?
 - What is functional programming? Is it hard?
 - So what is functional programming?
 - Why scala?


 

#HSLIDE
## Why functional programming?
We need functional programming as a tool in order to develop software that:

is closer to the way our mind works

models problems using high level abstractions

promotes composability

uses more denotational than operational semantics
 
#### In other words makes our developer lives easier...

#VSLILDE
### Denotational WHAT???
Example

This is a program that composes two methods in an OOP like language (in this case java).

```
class Main{
    public static int f(int x) { // Increment by one
        return x + 1;
    }
    
    public static int g(int x) { // Multiply by two
        return x * 2;
    } 
    
    public static int gof(int x) { // Composition g o f (g after f)
        return  g(f(x));
    }
    
    public static void  main(String[] args) { //Executing
        int ans = gof(1); // ans = 4
        
        //...
    }
}
```

#VSLIDE
### Example continue ...
Ok, that was trivial. Java does its jobs but what where we thinking while modeling 
the problem.

```
-- In a more mathematical notation

-- Define the functions
f x = x + 1

g x = x * 2

-- Define composition (g . f = g o f in the mathematical sense)
gof = g.f 

-- Executing
gof 1 

```

#VSLIDE
### Example comparison

Let's forget for a moment the amount of code written ...

- The second example has an major advantage in comparison to the first.

- It describes the meaning of the expressions of the language (just like in mathematics)

- The first example describes the operations that the compiler should do in order to execute the functions.

#### The programs are equivalent but solve the problem using different tools.
#### The second program is using pure functional approch.

#VSLIDE

### Conclusion
Denotational semantics may seem strange but are closer to the way we think.

That means that is easier for us to infer the execution result of program.

Moreover, they are more precise.

### Denotational semantics desctibe a problem in a higher level and leave the compiler do the hard work for us.

BTW: The second program is written in haskell.







---
The end
