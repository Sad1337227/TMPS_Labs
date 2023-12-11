package obj;

import interfaces.PaymentStrategy;

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
