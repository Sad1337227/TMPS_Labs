package obj;

import interfaces.PaymentStrategy;

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
