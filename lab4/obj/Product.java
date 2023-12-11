package obj;
import java.util.Random;

public class Product implements Cloneable {
  private String Name;
  private final boolean ProdDate;
  private final int Price;
  private int Quantity;

  Product() {
    final Random rand = new Random();

    final int rand_name_ind = rand.nextInt(Names.prod_names.length);
    Name = Names.prod_names[rand_name_ind];
    Quantity = rand.nextInt(5 - 1) + 1;
    Price = rand.nextInt(100 - 25) + 25;
    ProdDate = (rand.nextInt(50) % 2 == 0);
  };
  public String GetName() { return Name; };

  public void SetName(final String Name) { this.Name = Name; };
  public int GetPrice() { return Price; };
  public int GetQuantity() { return Quantity; };
  public void SetQuantity(final int q) {
    Quantity = q;
    return;
  };
  public Boolean CanSell() { return Quantity > 0; }
  public void Subtract() {
    if (Quantity > 0)
      Quantity -= 1;
    return;
  }

  public boolean IsExpired() { return ProdDate; }

  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return clone;
  }
}
