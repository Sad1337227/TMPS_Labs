package MVP;
import java.util.ArrayList;
import java.util.Random;

import conf.ConfigManager;
import obj.CustomerFactory;
import obj.DeliveryGuy;
import obj.Inspector;
import obj.MediumCustomer;
import obj.PoorCustomer;
import obj.Product;
import obj.Rent;
import obj.RichCustomer;
import obj.Robber;
import obj.Shop;

public class Model {
  public CustomerFactory customerfactory;
  public DeliveryGuy deliveryguy;
  public Inspector inspector;
  public ArrayList<PoorCustomer> poorcustomer_list;
  public ArrayList<MediumCustomer> mediumcustomer_list;
  public ArrayList<RichCustomer> richcustomer_list;
  public ArrayList<Product> product;
  public ArrayList<Robber> robbers;
  public Shop shop;
  public Rent rent;
  private Random rand;

  public Model(final ConfigManager configManager) {
    poorcustomer_list = new ArrayList<PoorCustomer>();
    mediumcustomer_list = new ArrayList<MediumCustomer>();
    richcustomer_list = new ArrayList<RichCustomer>();
    robbers = new ArrayList<Robber>();
    deliveryguy = new DeliveryGuy(configManager);
    inspector = new Inspector();
    customerfactory = new CustomerFactory();
    rent = new Rent(configManager);
    shop = new Shop(configManager);
    rand = new Random();

    for (int i = 0; i < 15; ++i) {
      poorcustomer_list.add(customerfactory.createPoorCustomer());
      mediumcustomer_list.add(customerfactory.createMediumCustomer());
      richcustomer_list.add(customerfactory.createRichCustomer());

      robbers.add(new Robber(configManager));
    }

    return;
  }

  public int RandInt(final int UpperB) { return RandIntInterval(UpperB, 0); }

  public int RandIntInterval(final int UpperB, final int LowerB) {
    return rand.nextInt(UpperB - LowerB) + LowerB;
  }
}
