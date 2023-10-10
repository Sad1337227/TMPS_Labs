package obj;
import java.util.Random;

public class Inspector extends Person {
  private int Defections;

  public Inspector() {
    super();
    Defections = 0;
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  };

  public int GetDefections() { return Defections; }

  public void IssueDefect(final Shop _shop) {
    for (int i = 0; i < _shop.Products.size(); ++i)
      if (_shop.Products.get(i).IsExpired()) {
        _shop.Products.get(i).Subtract();
        Defections++;
      }
  }

  public void setDefections(final int defections) { Defections = defections; }
}
