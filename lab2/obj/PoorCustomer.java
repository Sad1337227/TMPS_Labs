package obj;
import java.util.Random;

public class PoorCustomer extends Customer {
  public PoorCustomer() { SetMoney(new Random().nextInt(500 - 250) + 250); }
}
