
### Functional programming & Scala
#### Why bother?

_Fotis Paschos, @fpaschos_


#HSLIDE
### Outline
 - Introduction.
 - Some critical questions.
 - Answering
    * Why functional programming ?
    * Why scala ?
    * Why functional programming today ?
    
 - Concusion
 - Q & A 
 

#HSLIDE
### Introduction

#VSLIDE
#### About me
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
#### Why am I here?
Because ever since I started developing production software I had a feeling that 
I am doing something wrong.

That I was lacking something that would help me to tame each problems complexity.

#VSLIDE
#### Disclaimer
All the presented material, thoughts, opinions etc. are __subjective__. 
 
They reflect my __own__ strive and __learning path__ towards means __to implement better software__.
 
My goal is to share my findings and discuss about them.
 
#### This presentation is ONLY about designing and implementing better software  AND NOTHING MORE.  
 
#VSLIDE
#### Special thanks

#HSLIDE
### Some critical questions.
 - Why functional programming?
 - Why functional programming today?
 - What is functional programming? 
 - Is it hard?
 - So what is functional programming?
 - Why scala?

#HSLIDE
### Why functional programming?
We need tools to develop software that:

* is closer to the way our mind works

* models problems using high level abstractions.

* promotes composability (= reusability)

* uses more denotational than operational semantics
 
#### In other words makes our developer lives easier...

#VSLIDE
#### Denotational WHAT???

#VSLIDE
#### Example program 1
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
#### Example program 2
That was trivial, but what we were trying to do in the first place ? 

```
-- In a more mathematical notation

-- Define the functions
f x = x + 1

g x = x * 2

-- Define composition (g . f = g o f)
gof = g.f 

-- Executing
gof 1 

```

#VSLIDE
#### Comparison
- The first program describes the operations that the compiler must do in order to execute the functions.
- The second describes the meaning of the expressions of the language (just like in mathematics).

__The programs are equivalent but solve the problem using different tools.__
__The second program is using a pure functional approach.__

#VSLIDE

#### Conclusion
Denotational semantics may seem strange but are closer to the way we think.

That means that is easier for us to infer the execution result of the program.

Moreover, they are more precise and terse.

__Denotational semantics describe a problem in a higher level of abstraction 
and leave the compiler do the hard work for us.__

BTW: The second program is written in haskell.

#VSLIDE
#### Some more rhetorical questions.
* If we were meaning simple function composition. Why java forces us to use classes?

* Functions must be parts of objects?

* What exactly do the objects model?

* If we need to compose a third function h of type _(int -> String)_ how would our 
programs would be altered?

#HSLIDE
#### Why scala?
* It is a multiparadigm language.
* It runs on the JVM.
* It is strongly typed.
* It is mature and production ready.
* It has very good IDE support.
* It has (IMHO) a better ecosystem in mentality and actual tools.
* It is (IMHO) the closest reasonable thing that we have to haskell :) 

####Thank you!

__Q & A__
