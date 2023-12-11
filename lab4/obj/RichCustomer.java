package obj;
import java.util.Random;

public class RichCustomer extends Customer {
  public  RichCustomer(Bank _bank) { bank=_bank; }
  void LeaveExtraTip() { System.out.println("Left an extra tip"); };
  void VisitRegularly() { System.out.println("Will visit now regularly"); };
}
