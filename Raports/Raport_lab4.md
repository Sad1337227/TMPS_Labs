# Behavioral Design Patterns


## Author: Telug Anatolie, FAF-212

## Objectives:

* Get familiar with the Behavioral Design Patterns;
* Choose a specific domain;
* Develop the project for the specific domain using Behavioral Design Patterns;

## Theory:

`Behavioral design patterns` are concerned with the interaction and responsibility of objects. In these design patterns, the interaction between the objects should be in such a way that they can easily talk to each other and still should be loosely coupled. 

`Strategy` is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## Used Behavioral Design Patterns:

* Strategy

## Implementation
Implemented different types of payment strategies:
```
public class CreditCardStrategy implements PaymentStrategy {

  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  public CreditCardStrategy(String nm, String ccNum, String cvv,
                            String expiryDate) {
    this.name = nm;
    this.cardNumber = ccNum;
    this.cvv = cvv;
    this.dateOfExpiry = expiryDate;
  }
  @Override
  public void pay(String name, String productname, float amount) {

    String message =
        (name + " has bought " + productname + " for " + amount + " yuans!"
         + " using credit/debit card");
    System.out.println(message);
  }
}

```
```
public class PaypalStrategy implements PaymentStrategy {

  private String emailId;
  private String password;

  public PaypalStrategy(String email, String pwd) {
    this.emailId = email;
    this.password = pwd;
  }

  @Override
  public void pay(String name, String productname, float amount) {
    String message =
        (name + " has bought " + productname + " for " + amount + " yuans!"
         + " using Paypal!");
    System.out.println(message);
  }
}
```
## Conclusions / Screenshots / Results 
Here is example output
```
DeliveryQuantity = 13
Area = 50
PricePerSquareMeter = 250       
ChanceToRob = 50
ShopBank = 25000
Loaded cfg from file
Robber Barry has robbed THE shop
The assigned value is 1337
Melody has bought Matchbox for 53.0 yuans! using credit/debit card
Melody couldn't tip because he had no money
Shop Chop-chop! has payed 12$ for monthly rent!!!
Jeffrey has bought Rollerblades for 69.0 yuans! using credit/debit card
Jeffrey couldn't tip because he had no money
Alyssia has delivered 24 Rollerblades
Shop Chop-chop! has tipped 133.0$ for delivery/inspection
Jeffrey has bought Rollerblades for 42.0 yuans! using credit/debit card
Jeffrey couldn't tip because he had no money
Alyssia has delivered 16 Matchbox
Shop Chop-chop! has tipped 91.0$ for delivery/inspection
Gemma has bought Rollerblades for 42.0 yuans! using Paypal!
Gemma couldn't tip because he had no money
Reese has bought Rollerblades for 31.0 yuans! using Paypal!
Reese couldn't tip because he had no money
Alyssia has delivered 22 Rollerblades
Alyssia has delivered 22 iPod
Shop Chop-chop! has tipped 167.0$ for delivery/inspection
```
