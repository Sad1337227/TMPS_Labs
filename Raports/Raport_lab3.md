# Structural Design Patterns


## Author: Telug Anatolie, FAF-212

## Objectives:

* Get familiar with the Structural Design Patterns;
* Choose a specific domain;
* Develop the project for the specific domain using Structural Design Patterns;

## Theory:
`Structural design patterns` are concerned with how classes and objects can be composed, to form larger structures. The structural design patterns simplify the structure by identifying the relationships. These patterns focus on, how the classes inherit from each other and how they are composed from other classes.

`Bridge` pattern that decouple an abstraction from its implementation so that the two can vary independently

`Facade` pattern provides a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client. In other words, Facade pattern describes a higher-level interface that makes the sub-system easier to use.

`Proxy` pattern provides the control for accessing the original object. So, we can perform many operations like hiding the information of original object, on demand loading etc.


## Used Structural Design Patterns: 

* Bridge
* Facade
* Proxy


## Implementation
In this laboratory I implemented three design patterns on of them is 'Bridge' here is its implementation:
```
public interface PresenterInterface {

void StartSimulation(final View mainView, final Model model,
                              final ConfigManager configManager);

}
```
Another pattern used is 'Facade' I used it in my MVP model, here is implemetnation:
```
public MVPFacade() {
    configManager = new ConfigManager();
    try {
      configManager.Load();
    } catch (Exception e) {
      e.printStackTrace();
    }

    model = new Model(configManager);
    presenter = new PresenterProxy();
    
  }
```
The last pattern I used is 'Proxy', I used it in Presenter:
```
public class PresenterProxy implements PresenterInterface {
  private static Presenter presenter;

  public PresenterProxy(){
    super();
  }
```
## Conclusions / Screenshots / Results 
Changed arguments which my simulation takes
```
public void StartSimulation() { presenter.StartSimulation(View.getInstance(), model, configManager);
```
Here is example output:
```
DeliveryQuantity = 13
Area = 50
PricePerSquareMeter = 250
ChanceToRob = 50
ShopBank = 25000
Loaded cfg from file     
Robber Arron couldn't rob THE shop!!
The assigned value is 1337
Glenn has bought Band-Aid for 30 yuans!
Glenn couldn't tip because he had no money
Shop Chop-chop! has payed 12$ for monthly rent!!!
Dajah has bought Coke for 65 yuans!
Dajah couldn't tip because he had no money
Gina has delivered 24 Coke
Shop Chop-chop! has tipped 172.0$ for delivery/inspection
Aimee has bought iPod for 43 yuans!
Aimee couldn't tip because he had no money
Gina has delivered 20 Coke
Gina has delivered 20 Band-Aid
Shop Chop-chop! has tipped 189.0$ for delivery/inspection
Glenn has bought Band-Aid for 30 yuans!
Glenn couldn't tip because he had no money
Gina has delivered 26 Rollerblades
Shop Chop-chop! has tipped 137.0$ for delivery/inspection
```
In conclusion, I would say that structural design patterns bring many benefits for designing software products. They help the programmers hide inner functionality of the system to prevent it from any unexpected changes, organize similar objects into a common structure and introduce basic security principles into the projects. In this laboratory work I managed to use structural design patterns to optimize my project. Proxy pattern was rather useful for optimizing code in Presenter. Facade pattern made the MVP simplier. Therefore, summing up everything having been said, structural design patterns simplify software products and make them more efficient.
