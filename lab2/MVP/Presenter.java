package MVP;
import java.util.ArrayList;
import java.util.TimerTask;
import obj.Customer;
import obj.Product;
import obj.Robber;
import conf.ConfigManager;

public class Presenter {
  private View view;
  private Model model;
  private ConfigManager configManager;

  public Presenter(final View mainView, final Model model,
                   final ConfigManager configManager) {
    this.configManager = configManager;
    this.view = mainView;
    this.model = model;

    return;
  }

  public void StartSimulation() {
    new java.util.Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        Simulate_interactions();
      }
    }, 1, 1000);

    new java.util.Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        Simulate_rent();
      }
    }, 1, 3000 * 10);

    new java.util.Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        Simulate_rob();
      }
    }, 1, 6000 * 10);
  }

  private void Simulate_interactions() {
    int rand_ind = -1;
    final int rand_list = model.RandInt(3);

    Customer cust = new Customer();
    final Product prod = model.shop.ServeCustomer(rand_list);

    // reverse this if it doesnt launch
    if (rand_list >= 0 && rand_list <= 2) {
      ArrayList<Customer> customerList = new ArrayList<>();

      switch (rand_list) {
      case 0:
        if (model.poorcustomer_list != null) {
          customerList.addAll(model.poorcustomer_list);
        }
        break;
      case 1:
        if (model.mediumcustomer_list != null) {
          customerList.addAll(model.mediumcustomer_list);
        }
        break;
      case 2:
        if (model.richcustomer_list != null) {
          customerList.addAll(model.richcustomer_list);
        }
        break;
      default:
        // Handle invalid rand_list values if needed
        break;
      }

      if (customerList != null && customerList.size() > 1) {
        rand_ind = model.RandInt(customerList.size());
        cust = customerList.get(rand_ind);
      }
    }

    final int BuySum = cust.Buy(prod);
    model.shop.SetMoney(model.shop.GetMoney() + BuySum);
    String message = (cust.GetName() + " has bought " + prod.GetName() +
                      " for " + BuySum + " yuans!");
    view.ShowMessage(message);

    final float AskTipValue = model.shop.AskTip(model.shop);
    float TipValue = cust.Tip(model.shop);
    message =
        (TipValue != -1
             ? (cust.GetName() + " has tipped " + TipValue +
                " but the shop has asked for " + AskTipValue)
             : (cust.GetName() + " couldn't tip because he had no money"));
    view.ShowMessage(message);

    model.deliveryguy.TryDeliver(model.shop);
    TipValue = model.shop.Tip(model.deliveryguy);
    message =
        (TipValue != -1
             ? ("Shop " + model.shop.GetName() + " has tipped " + TipValue +
                "$ for delivery/inspection")
             : "Shop " + model.shop.GetName() +
                   " couldn't tip for delivery/inspection because they do not have money!!");
    view.ShowMessage(message);

    model.inspector.IssueDefect(model.shop);

    return;
  }

  private void Simulate_rent() {
    view.ShowMessage("The assigned value is " + model.shop.ValueInit);
    final int PriceToPay = model.rent.Pay(model.shop);
    final String message = "Shop " + model.shop.GetName() + " has payed " +
                           PriceToPay + "$ for monthly rent!!!";

    view.ShowMessage(message);

    return;
  }

  private void Simulate_rob() {
    final int rand_rob = model.RandInt(model.robbers.size());

    final Robber robber = model.robbers.get(rand_rob);

    final String message =
        "Robber " + robber.GetName() +
        (robber.TryRob() ? " has robbed THE shop" : " couldn't rob THE shop!!");
    view.ShowMessage(message);

    return;
  }
}
