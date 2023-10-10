package obj;
import java.util.Random;

public class RichCustomer extends Customer {
  public RichCustomer() { SetMoney(new Random().nextInt(5500 - 2500) + 2500); }
  void LeaveExtraTip() { System.out.println("Left an extra tip"); };
  void VisitRegularly() { System.out.println("Will visit now regularly"); };
}
