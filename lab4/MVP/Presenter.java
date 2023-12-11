package MVP;

import conf.ConfigManager;
import interfaces.PaymentStrategy;
import interfaces.PresenterInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import obj.CreditCardStrategy;
import obj.Customer;
import obj.CustomerContainer;
import obj.PaypalStrategy;
import obj.Product;
import obj.Robber;

public class Presenter implements PresenterInterface {
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

  public void StartSimulation(final View mainView, final Model model,
                              final ConfigManager configManager) {
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
    final int rand_list = model.RandInt(3);

    Customer cust = new Customer();
    Product prod = model.shop.ServeCustomer(rand_list);

    CustomerContainer cc = new CustomerContainer();
    cc.childCustomers = new ArrayList<Customer>();

    cc.childCustomers.addAll(model.mediumcustomer_list);
    cc.childCustomers.addAll(model.richcustomer_list);
    cc.childCustomers.addAll(model.poorcustomer_list);

    cust = cc.selectRandomCustomer();

    int rand = model.RandInt(2);

    PaymentStrategy ps =
        rand == 1
            ? new PaypalStrategy(cust.GetName() + "@gmail.com",
                                 "_+%#" + cust.GetName() + "_pw")
            : new CreditCardStrategy(
                  cust.GetName(), cust.GetName() + "^6548gfkjsssgk;syu53w462q_",
                  "186", "12/28");

    final int BuySum = cust.Buy(prod, ps, cust.GetName(), prod.GetName());
    model.shop.SetMoney(model.shop.GetMoney() + BuySum);

    String message = "";

    final float AskTipValue = model.shop.AskTip(model.shop);
    float TipValue = cust.Tip(model.shop);
    message =
        (TipValue != -1
             ? (cust.GetName() + " has tipped " + TipValue +
                " but the shop has asked for " + AskTipValue)
             : (cust.GetName() + " couldn't tip because he had no money"));
    view.ShowMessage(message);

    if (model.deliveryguy.TryDeliver(model.shop) == true) {
      TipValue = model.shop.Tip(model.deliveryguy);
      message =
          (TipValue != -1
               ? ("Shop " + model.shop.GetName() + " has tipped " + TipValue +
                  "$ for delivery/inspection")
               : "Shop " + model.shop.GetName() +
                     " couldn't tip for delivery/inspection because they do not have money!!");
      view.ShowMessage(message);
    }

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
