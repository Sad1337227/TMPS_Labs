package obj;

import interfaces.IDiscountCard;
import interfaces.ITippable;
import interfaces.PaymentStrategy;
import java.util.Random;
import obj.Bank;

public class Customer extends Person implements ITippable, IDiscountCard {
  protected BankInterface bank;
  private int DiscountLevel;

  public Customer() {
    super();
    this.DiscountLevel = 0;
    this.SetMoney(0);
  }

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

    if (TipValue > this.GetMoney()) {
      return -1.0f;
    }

    this.SetMoney((float)this.GetMoney() - TipValue);
    bank.SetMoney((float)bank.GetMoney() + TipValue);

    return TipValue;
  }

  public float GetAppropriateLevel(final Bank bank) {
    return Math.abs((float)(bank.GetMoney() * 0.01));
  };

  public int Buy(final Product product, PaymentStrategy ps, String name,
                 String ProdName) {
    this.SetMoney((float)this.GetMoney() -
                  (float)product.GetPrice() /
                      ApplyDiscount(product.GetQuantity()));

    ps.pay(name, ProdName,
           (float)product.GetPrice() / (float)ApplyDiscount(product.GetQuantity()));

    return product.GetPrice();
  }
}
