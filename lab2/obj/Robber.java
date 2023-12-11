package obj;
import java.util.Random;

import conf.ConfigManager;

public class Robber extends Customer {
  private final Boolean Color;
  private final int ChanceToRob;

  public Robber(final ConfigManager configManager) {
    Color = true;
    final Random rand = new Random();
    ChanceToRob =
        rand.nextInt(configManager.GetValue("ChanceToRob")); // EXPORT TO CFG
  };

  public Boolean TryRob() {
    final Random rand = new Random();
    return (ChanceToRob > rand.nextInt(100));
  }
}
