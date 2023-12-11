package interfaces;
public interface IDiscountCard {
  default void Revoke() { System.out.println("The discount card was revoked"); }

  default void IncreaseDiscountLevel() {
    System.out.println("Increased discount level");
  }

  default void DecreaseDiscountLevel() {
    System.out.println("Decreased discount level");
  }

  default float ApplyDiscount(int prod_left) {
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
