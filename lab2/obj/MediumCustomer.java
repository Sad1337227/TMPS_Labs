package obj;
import java.util.Random;

public class MediumCustomer extends Customer {
  public MediumCustomer() { SetMoney(new Random().nextInt(1500 - 500) + 500); }
}
