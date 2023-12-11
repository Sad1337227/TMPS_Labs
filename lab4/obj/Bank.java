package obj;
 public class Bank implements BankInterface{
  private int Money;

  Bank() {
    super();
    Money = 0;
  };

  public int GetMoney() { return Money; }

  public void SetMoney(final float _Money) {
    Money = (int)_Money;
    return;
  }
}