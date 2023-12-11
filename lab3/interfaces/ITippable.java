package interfaces;
import obj.Bank;

public interface ITippable {
  default float GetAppropriateLevel(final Bank bank) { return 0.05f; };

  default float AskTip(final Bank bank) {
    return (float)bank.GetMoney() * GetAppropriateLevel(bank);
  }

  default float Tip(final Bank bank) { return 0.0f; }
}
