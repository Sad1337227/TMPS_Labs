package obj;

public class CustomerFactory {
  public PoorCustomer createPoorCustomer() { return new PoorCustomer(); }
  public MediumCustomer createMediumCustomer() { return new MediumCustomer(); }
  public RichCustomer createRichCustomer() { return new RichCustomer(); }
}
