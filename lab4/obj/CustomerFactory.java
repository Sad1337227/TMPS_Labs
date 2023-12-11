package obj;

public class CustomerFactory {
  public PoorCustomer createPoorCustomer() {
    PoorBank pb = new PoorBank();
    return new PoorCustomer(pb);
  }
  public MediumCustomer createMediumCustomer() {
    return new MediumCustomer(new MediumBank());
  }
  public RichCustomer createRichCustomer() {
    return new RichCustomer(new RichBank());
  }
}
