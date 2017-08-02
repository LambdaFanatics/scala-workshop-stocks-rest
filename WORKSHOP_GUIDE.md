# Scala workshop: Build a simple rest stocks app.

## Installation
Follow the instructions of the README file to prepare your environment.

## What are we implementing? 
As a demo case ...

## PART  1 
### Explaining project structure 
* Build process SBT _TODO..._
* Idea scala support:

IDE Action | Mac | Linux
---  | :---: | ---
Show intention actions & quick fixes | `alt+Enter`
Type info | `ctrl+shift+P` |
Parameter info | `cmd+P` |
Find usages | `alt+F7` |
Run main| `ctrl+shift+R` | 
Stop main | `cmd+F2` |
Implicit conversion | `ctrl+Q` |
Implicit parameters | `cmd+shift+P` |

### A server up and running !

Open the entry point of the application _swc.stocks.Server_. This object initializes an akka http server.

1) Run the code and see the result.

> Hit `ctrl+shift+R` to run the server and  open an browser at `http://localhost:9191` to make sure that everything works.

As you can see the implementation is written straight in the body of the object without a main method.

2) Where is `main`?

> Navigate to the `App` trait and make sure that a main exists.

It seems that we don't need to write explicitly the type at variable declarations.

3) The IDE can help us generate them and find them.

> Hover over the interface parameter and press `ctrl+shift+P` to see its type.
Press `alt+Enter` to automatically fill the type.

We can see some values declared as implicit on the top of the class.
These expressions initialize the `ActorSystem` and `ActorMaterializer` which are 
key components of the akka library.

4) Why they need to be `implicit`?

> Let's delete the implicit keyword at the `executionContext` declaration. What is happening?

The line 
`val routes: Route =  _.complete("Let's get started")`
creates a route that is used for initializing the server.

5) Why is it so cryptic? Can we write it more explicitly. Why is the string underlined by the IDE?

> Let's use the IDE to write an equivalent more readable version of this line.


It is already obvious that a lot of syntactic sugar and compilation time stuff is going on. Even with the help  of the IDE things seem to be too complex.
Before you jump into conclusions ask yourself __do we need to understand everything in order to create our application ?__

> We claim that the __answer is NO__. The __goal__ of this workshop apart from a hands on introduction is to __prove that we can use scala even without having vast prior  functional expertise__.
We just need to __keep a high level perspective__ and __focus on the problem at hand__ in this case provide a rest API for our client.


### Creating the domain types 
The next step is to create some type that will represent our domain.
For our simple scenario we need to represent only the concepts of user and stock.

1) How we chose to represent the stock and the user?

> Create two case classes `User` and `Stock` in package `swc.stocks.domain` to represent the domain.
Not because like in OOP everything should be a class, but because we need to create 
two new data types. In our case we need to create two scala _case class_ es.

```
case class Stock(code: String, description: String)

case class User(id: Long, name: String)
```

> Compare this with immutable java classes with equal and hash code function getters.
We have done all of this with a simple line of code.

### Implenting a simple stock service
Next we will implement a simple stock service.
The simple stock service is a high level service
that corresponds one on one to the http api of the server.

> Open the object file `swc.stocks.StockService`. 

The service object just holds some internal state to represent mock 
stocks.
`stocksRegistry` is a map from of all the available stocks indexed by.
`stocksPerUser` is the assigned stocks per user.

For now we intentionally ignore the database integration. We will mock the 
results inside the service.

1) Let's create some mock data.

> Fill the `stocksRegistry` with three mock stocks `AAA, BBB, CCC`
> Add a mock user with `User(1,"user")` to hold the stock `CCC`

2) Implement the method `fetchStocks()`.

> The stub of the method to implement already exists. 

```def fetchStocks() : Future[Seq[Stock]] = ???```

> Fill the implementation to return all the available stocks of the registry. 

> _Hint: You need to wrap the result to a future. Does the compiler complains
when you do it?_ 

Notice that the method signature describes the delay of the hypothetical database event, 
it has a return type of `Future[Seq[Stock]]`.

3) Similarly with the above we can implement `fetchUserPortfolio()`.

> Implement the method, this time use the state value `stocksPerUser`.

For the next two methods of the user portfolio we need to _mutate_ the internal state of the service.
That is why the signature of the methods change returning a type of `Future[Done]`. This type again 
declares operation delay but we don't care about the result value only about the successful completion.

4) Implement the method that adds a stock code to a user portfolio.
>  The implementation of the method requires knowledge about scala collections.
> `def addToUserPortfolio(userId: Long, code: String): Future[Done]`
>
>  _Hint: You need to query if a user has already a portfolio list. If the portfolio exists then we should add the stock,
> if not then we should create it first._ 

5) Similarly let's implement the method that removes a stock from a users portfolio.
> Implement the method `removeUserStock`.

Before we continue lets take a moment and concider about the method signatures.

Compare this signature:
`def fetchUserPortolio(userId: Long): Future[Seq[Stock]]` 

With this:
`def fetchUserPortolio(userId: Long): Seq[Stock]`
 
Isn't it better to have the side effect of the method visible in the type. `Future[...]` denotes 
that time latency (or error) may occur. In other words __the method signature explicitly states 
about what side effect it uses__.  In the second case __only by examining the method body__ we 
can be certain that the method is not pure. 

6) Finally, all the methods of our service are __pure functions__ 
can you tell why this is important.

### Test the service layer
We have now an service layer which relies on internal in memory state. We don't know if it is operational yet.

1) Should we wait until the creation of the http API in order to test if it works?

> Of course not. Let's use scala testing mechanisms to test our service layer. 
> Open file `swc.stocks.StockServiceSpec` and complete the tests based on the known implementation 
> stock service.

### Creating rest api

We begin by replacing our routes definition. We are going to use akka Directives which is 
a __DSL__ to create server http routes.

1) Let's implement a route.

>  Create the `/stocks` route which returns all the available stocks.


### Testing our API

##PART 2

### Integrating database via slick 

### What about transactions

### What about errors and validation

### Adding a front for fun

### You said something about Functional Programming?

### Next steps

### Resources

[Akka Documentation](http://akka.io/docs/)

[Scalatest Documentation](http://www.scalatest.org/user_guide)

[Programming in Scala: A Comprehensive Step-by-Step Guide, Third Edition](https://www.amazon.com/Programming-Scala-Comprehensive-Step-Step-ebook/dp/B01EX49FOU/ref=sr_1_sc_1?s=books&ie=UTF8&qid=1499325668&sr=1-1-spell&keywords=a+complrehensive+step-by-step+guide+3rd+edition)