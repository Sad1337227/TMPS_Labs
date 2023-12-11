package obj;
import conf.ConfigManager;
import interfaces.IDiscountCard;
import interfaces.ITippable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop extends Bank implements ITippable, IDiscountCard {
  private String Name;
  private int CustomersServed;
  private int TimesRobbed;
  public List<Product> Products;
  public int ValueInit;

  public Shop(final ConfigManager configManager) {
    final Random rand = new Random();
    SetName("Chop-chop!");
    this.SetMoney(configManager.GetValue("ShopBank")); // EXPORT TO CFG
    CustomersServed = 0;
    TimesRobbed = 0;

    Products = new ArrayList<>();

    final Product _prod = new Product();
    Products.add(_prod);

    for (int i = 0; i < 9; i++) {
      //here it should automatically clone the object, thus using prototype pattern
      Product _new_prod = Products.get(0);
      Products.add(_new_prod);
    }

    ValueInit = 1337;
  }

  @Override
  public float ApplyDiscount(final int prod_left) {
    return 50 / (prod_left == 0 ? 1 : prod_left);
  }

  @Override
  public float Tip(final Bank bank) {
    final int TipValue = Math.abs((int)(bank.GetMoney() * 0.05));

    if (TipValue > this.GetMoney()) {
      return -1;
    }

    this.SetMoney(this.GetMoney() - TipValue);
    bank.SetMoney(bank.GetMoney() + TipValue);

    return TipValue;
  }

  @Override
  public float AskTip(final Bank bank) {
    return (float)bank.GetMoney() * GetAppropriateLevel(bank);
  };
  public String GetName() { return Name; };

  public void SetName(final String Name) { this.Name = Name; };

  public Product ServeCustomer(final int Index) {
    final Random rand = new Random();
    Product prod;
    int rand_product = -1;

    switch (Index) {
    case 0:
    case 1:
    case 2: {
      rand_product = rand.nextInt(3 - 0) + 0;
      break;
    }
    case 3:
    case 4:
    case 5: {
      rand_product = rand.nextInt(6 - 3) + 3;
      break;
    }
    case 6:
    case 7:
    case 8: {
      rand_product = rand.nextInt(9 - 6) + 6;
      break;
    }
    }
    if (rand_product > Products.size())
      ServeCustomer(Index);

    prod = Products.get(rand_product);

    Products.get(rand_product).Subtract();

    System.out.println("There are " + prod.GetQuantity() + " " +
                       prod.GetName());

    return prod;
  }

  public String getName() { return Name; }

  public void setName(final String name) { Name = name; }

  public int getCustomersServed() { return CustomersServed; }

  public void setCustomersServed(final int customersServed) {
    CustomersServed = customersServed;
  }

  public int getTimesRobbed() { return TimesRobbed; }

  public void setTimesRobbed(final int timesRobbed) {
    TimesRobbed = timesRobbed;
  }

  public List<Product> getProducts() { return Products; }

  public void setProducts(final List<Product> products) { Products = products; }

  public int getValueInit() { return ValueInit; }

  public void setValueInit(final int valueInit) { ValueInit = valueInit; }
}
