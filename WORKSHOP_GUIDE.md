### Scala workshop: Build a simple rest stocks app.

#####Installation
Follow the instructions of the README file to prepare your environment.

####What are we implementing? 
As a demo case ...

####PART  1 
##### Explaining project structure 
* Build process SBT
* Idea scala support:

action | Mac | Linux
---  | :---: | ---
Type info | _ctrl+shift+P_ |
Parameter info | _cmd+P_ |
Run main| _ctrl+shift+R_
Stop main | _cmd+F2_
Implicit conversion | _ctrl+Q_

##### A server up and running

Open the entry point of the application _swc.stocks.Server_. This object initializes an akka http server.

1) Let's Run the code and see the result.

> Hit _ctrl+shift+R_ to run the server and  open an browser at _http://localhost:9191/_ to make sure that everything works.

As you can see the implementation is written straight in the body of the object without a main method.

2) Where is the main? Let's find it.

> Navigate to the _App_ trait and make sure that a main exists.

It seems that we don't need to write explicitly the type at variable declarations.

3) The IDE can help us generate them and find them.

> Hover over the interface parameter and press _ctrl+shift+P_ to see its type.
Press _alt+Enter_ to automatically fill the type.

We can see some values declared as implicit on the top of the class.
These expressions initialize the _ActorSystem_ and _ActorMaterializer_ which are 
key components of the akka library.

4) Why we need them to be implicit?

> Let's delete the implicit keyword at the _executionContext_ declaration. What is happening?

The line 
```val route: Route =  _.complete("Let's get started")```
creates a route that is used for initializing the server.

5) Why is so cryptic? Can we write it more explicitly. Why is the string underlined by the IDE?

> Let's use the IDE to write an equivalent more readable version of this line.

...

It is already obvious that a lot of syntactic sugar and compilation time stuff are going on. Even with the help  of the IDE things seem to be too complex.
Before you jump into conclusions ask yourself __do we need to understand everything in order to create our application ?__


> We claim that the **answer is NO**. The __goal__ of this workshop apart from a hands on introduction is to __prove that we can use scala even without having vast prior  functional expertise__.
We just need to __keep a high level perspective__ and __focus on the problem at hand__ in this case provide a rest API for our client.


##### Creating the domain types 

##### Creating rest api

##### Testing our api

##### Integrating database via slick (Part 2)

##### Adding a front for fun

##### Resources

##### More topics