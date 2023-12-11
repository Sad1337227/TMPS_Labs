package obj;
    
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class CustomerContainer extends Customer{
    public List<Customer> childCustomers;
    public CustomerContainer(){return;}
    
    public void addCustomerList(ArrayList<Customer>cl){
        childCustomers.addAll(cl);
    }
 
    public void removeCustomer(int ind){
        childCustomers.remove(ind);
    }

    public Customer selectRandomCustomer() {
        if (childCustomers == null || childCustomers.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(childCustomers.size());

        return childCustomers.get(randomIndex);
    }
}