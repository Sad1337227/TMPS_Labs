package interfaces;

public interface PaymentStrategy {

	public void pay(String name, String productname, float amount);
}
