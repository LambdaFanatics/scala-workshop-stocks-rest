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
Show intention actions & quick fixes | _alt+Enter_
Type info | _ctrl+shift+P_ |
Parameter info | _cmd+P_ |
Run main| _ctrl+shift+R_
Stop main | _cmd+F2_
Implicit conversion | _ctrl+Q_

##### A server up and running

Open the entry point of the application _swc.stocks.Server_. This object initializes an akka http server.

1) Run the code and see the result.

> Hit _ctrl+shift+R_ to run the server and  open an browser at _http://localhost:9191/_ to make sure that everything works.

As you can see the implementation is written straight in the body of the object without a main method.

2) Where is `main`?

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
```val routes: Route =  _.complete("Let's get started")```
creates a route that is used for initializing the server.

5) Why is so cryptic? Can we write it more explicitly. Why is the string underlined by the IDE?

> Let's use the IDE to write an equivalent more readable version of this line.

...

It is already obvious that a lot of syntactic sugar and compilation time stuff are going on. Even with the help  of the IDE things seem to be too complex.
Before you jump into conclusions ask yourself __do we need to understand everything in order to create our application ?__

> We claim that the **answer is NO**. The __goal__ of this workshop apart from a hands on introduction is to __prove that we can use scala even without having vast prior  functional expertise__.
We just need to __keep a high level perspective__ and __focus on the problem at hand__ in this case provide a rest API for our client.


##### Creating the domain types 
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

#### Implenting a simple stock service
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

Notice that the api describes the delay that of the hypothetical database event, 
it has a return type of `Future[Seq[Stock]]`.

##### Test the service layer
TODO...

##### Creating rest api

We begin by replacing our routes definition. We are going to use akka Directives which is 
a __DSL__ to create server http routes.

1) Create the `/stocks` route which returns all the available 


##### Testing our api


####PART 2
##### Integrating database via slick 

##### What about transactions

##### What about errors and validation

##### Adding a front for fun

##### Resources

##### More topics