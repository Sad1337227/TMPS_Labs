package obj;
import conf.ConfigManager;
import java.util.Random;

public class DeliveryGuy extends Customer {
  int delivery_quantity_basic;

  public DeliveryGuy(final ConfigManager configManager) {
    super();
    delivery_quantity_basic = configManager.GetValue("DeliveryQuantity");
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  }

  public boolean TryDeliver(final Shop shop) {
    final Random rand = new Random();
    boolean delivered = false;
    int delivery_quantity = delivery_quantity_basic + new Random().nextInt(15);

    for (int i = 0; i < shop.Products.size(); ++i) {
      final Product prod = shop.Products.get(i);

      if (prod.GetQuantity() < 1) {
        final int price_to_pay = (int)(delivery_quantity * prod.GetPrice() /
                                       shop.ApplyDiscount(prod.GetQuantity()));
        prod.SetQuantity(delivery_quantity);

        if (shop.GetMoney() < price_to_pay) {
          System.out.println(("The shop couldn't order " + delivery_quantity +
                              " " + prod.GetName() +
                              " because they do not have money."));
          break;
        }
        shop.SetMoney(shop.GetMoney() - price_to_pay);

        System.out.println(GetName() + " has delivered " + delivery_quantity +
                           " " + prod.GetName());
        delivered = true;
      }
    }

    return delivered;
  }
}
