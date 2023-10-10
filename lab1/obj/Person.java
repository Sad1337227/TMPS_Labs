package obj;
import java.util.Random;

abstract public class Person extends Bank {
  private String Name;

  Person() {
    final Random rand = new Random();
    final int rand_name_ind = rand.nextInt(Names.cust_names.length);
    SetName(Names.cust_names[rand_name_ind]);
  };
  public String GetName() { return Name; };

  public void SetName(final String Name) { this.Name = Name; }
}
