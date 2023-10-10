package obj;
import java.util.Random;
import java.util.Timer;

import conf.ConfigManager;

public class Rent {
  private final int Area;
  private final int PricePerSqM;

  public Rent(final ConfigManager configManager) {
    final Random rand = new Random();

    Area = configManager.GetValue("Area"); // EXPORT TO CFG
    PricePerSqM =
        configManager.GetValue("PricePerSquareMeter"); // EXPORT TO CFG
  }

  public int Pay(final Shop _shop) {
    final int Sum = Area * PricePerSqM / 1000;
    _shop.SetMoney(_shop.GetMoney() - (int)(Sum));
    return Sum;
  }
}
