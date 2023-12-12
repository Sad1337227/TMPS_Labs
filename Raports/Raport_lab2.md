# Creational Design Patterns


## Author: Telug Anatolie, FAF-212

## Objectives:

* Get familiar with the Creational Design Patterns;
* Choose a specific domain;
* Develop the project for the specific domain using Creational Design Patterns;

## Theory:
`Creational design patterns` are concerned with the way of creating objects. These design patterns are used when a decision must be made at the time of instantiation of a class (i.e. creating an object of a class). 

`Builder` is the design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

`Factory` is the design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

`Prototype` pattern lets you copy existing objects without making your code dependent on their classes.

`Singleton` pattern lets you ensure that a class has only one instance, while providing a global access point to this instance.

## Used Creational Design Patterns: 

* Builder
* Factory
* Prototype
* Singleton


## Implementation
In this laboratory work I have 'Singleton' implementaion at the View in MVP model:
```
  public static View getInstance() {
    if (instance == null) {
      instance = new View();
    }
    return instance;
  }
```
Also I added the 'Factory' to create different types of customers:
```
public class CustomerFactory {
  public PoorCustomer createPoorCustomer() { return new PoorCustomer(); }
  public MediumCustomer createMediumCustomer() { return new MediumCustomer(); }
  public RichCustomer createRichCustomer() { return new RichCustomer(); }
}
```
The last thing I added is 'Prototype' here is its implemetation, I implemented to class Products Clonable to be able to copy them:
```
  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
```
## Conclusions / Screenshots / Results 
Here is example of output:
```
DeliveryQuantity = 13
Area = 50
PricePerSquareMeter = 250
ChanceToRob = 50
ShopBank = 25000
Loaded cfg from file
Robber Kelsey couldn't rob THE shop!!
The assigned value is 1337
There are 0 Band-Aid
Shop Chop-chop! has payed 12$ for monthly rent!!!
Renee has bought Band-Aid for 93 yuans!
Renee has tipped 250.81 but the shop has asked for 1254.05
Isabell has delivered 13 Band-Aid
Shop Chop-chop! has tipped 195.0$ for delivery/inspection
There are 2 Band-Aid
```
In conclusion, I would say that all the creational design patterns used in this laboratory work fit in perfectly in the concept of my project. The program runs succesfully and the classes are well-structured. However, I have to say that it is not necessary to use all of the creational patterns at the same time, while it can be not quite convenient and in fact not bring any benefits. It is a good practice to use creational design patterns if they are realy needed and simplify our work.
