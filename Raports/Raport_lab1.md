# SOLID Principles


## Author: Telug Anatolie, FAF-212

## Objectives:

* Get familiar with the SOLID Principles;
* Choose a specific domain;
* Develop the project for the specific domain taking into account SOLID Principles;

## Theory:
SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language.

## Used SOLID Principles: 

* Single Responsibility principle
* Open-Closed principle
* Liskov Substitution principle
* Interface Segregation principle
* Dependency Inversion principle


## Project Description and SOLID Implementation

The project I decided to develop throughout this course is nothiing else but a Shop simulation. The main interfaces in this application are `ITippable.java` and `IDiscountCard.java` this is `Single Responsibility  principle`:
```
interface IDiscountCard {
  public void Revoke() { System.out.println("Revoked this discount card"); };
  public void IncreaseDiscountLevel() {
    System.out.println("Increased discount level");
  };
  public void DecreaseDiscountLevel() {
    System.out.println("Decreased discount level");
  };

  public float ApplyDiscount(int prod_left) {
    float discount = 0;

    if (prod_left < 10) {
      discount = 70;
    } else if (prod_left < 20) {
      discount = 45;
    }

    float discountedPrice = prod_left - (prod_left * discount / 100);
    return discountedPrice;
  }
}

interface ITippable {
  float GetAppropriateLevel(final Bank bank) { return 0.05; };
  float AskTip(final Bank bank) { return bank * this.GetAppropriateLevel(); };
  float Tip(final Bank bank) { return 0; };
}

```
`Open-Closed principle` is realized through inheritance. Objects `RichCustomer`, `MediumCustomer`, `PoorCustomer` extend functionality of `Customer`, but do not modify it.
```
import java.util.Random;

public class RichCustomer extends Customer {
  RichCustomer() { SetMoney(new Random().nextInt(5500 - 2500) + 2500); }
  void LeaveExtraTip();
  void VisitRegularly();
}
```
`Customer.java` overrides only methods which it needs:
```
@Override
  public float ApplyDiscount(final int prod_left) {
    final float Discount =
        (this.DiscountLevel / (prod_left == 0 ? 1 : prod_left));
    return Discount == 0 ? 1 : Discount;
  }

  @Override
  public void IncreaseDiscountLevel() {
    if (this.DiscountLevel < 50)
      this.DiscountLevel += 5;
  }

  @Override
  public void DecreaseDiscountLevel() {
    if (this.DiscountLevel > 0)
      this.DiscountLevel -= 5;
  }

  @Override
  public void Revoke() {
    this.DiscountLevel = 0;
  }

  @Override
  public float Tip(final Bank bank) {
    final float TipValue = this.GetAppropriateLevel(bank);
  }
```

In this way I managed to make my project corresponding to the `interface segregation principle`. By using interfaces in my project I also reached `dependency inversion` principle because my classes depend on abstract "sets of rules" rather then on concrete implementations.

Returning to the `Presenter.java` class, it contains the single `Model` attribute (class storing Customers, Delivery guy, Inspector, Robber and Products in a primitive way) and a few methods similar to the ones declared in the `Customer` class:
```
    if (rand_list >= 0 && rand_list <= 2) {
      ArrayList<Customer> customerList = new ArrayList<>();

      switch (rand_list) {
      case 0:
        if (model.poorcustomer_list != null) {
          customerList.addAll(model.poorcustomer_list);
        }
        break;
      case 1:
        if (model.mediumcustomer_list != null) {
          customerList.addAll(model.mediumcustomer_list);
        }
        break;
      case 2:
        if (model.richcustomer_list != null) {
          customerList.addAll(model.richcustomer_list);
        }
        break;
      default:
        // Handle invalid rand_list values if needed
        break;
      }
```

It should be mentioned here that this class corresponds to the `Liskov substitution` principle because these methods will receive objects of types `RichCustomer`, `MediumCustomer` and `PoorCustomer` and still will work properly.

Finally, `Bank` class returns Money data :
```
abstract public class Bank {
  private int Money;

  Bank() {
    super();
    Money = 0;
  };

  public int GetMoney() { return Money; }

  public void SetMoney(final float _Money) {
    Money = (int)_Money;
    return;
  }
}
```



## Conclusions / Screenshots / Results

Below I am going to show the output of those methods:
```
Gina has bought iPod for 66 yuans!
Gina has tipped 15.37 but the shop has asked for 76.85
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
There are 8 Hula Hoop
Gina has bought Hula Hoop for 63 yuans!
Gina has tipped 16.15 but the shop has asked for 80.75
Gina has delivered 13 Coke
Gina has delivered 13 Coke
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
There are 7 Hula Hoop
Gina has bought Hula Hoop for 63 yuans!
Gina has tipped 16.49 but the shop has asked for 82.450005
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
There are 6 iPod
Gina has bought iPod for 66 yuans!
Gina has tipped 17.31 but the shop has asked for 86.55
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
There are 10 Rollerblades
Gina has bought Rollerblades for 63 yuans!
Gina has tipped 18.11 but the shop has asked for 90.55
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
There are 9 Rollerblades
Gina has bought Rollerblades for 63 yuans!
Gina has tipped 18.92 but the shop has asked for 94.6
Shop Chop-chop! couldn't tip for delivery/inspection because they do not have money!!
```

To sum up, the project works as desired and respects all five SOLID Principles.
