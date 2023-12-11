import MVP.Model;
import MVP.Presenter;
import MVP.PresenterProxy;
import MVP.View;
import MVP.MVPFacade;
import conf.ConfigManager;

public class Main {
  public static void main(final String[] args) throws Exception {
    MVPFacade mvp_facade = new MVPFacade();
    mvp_facade.StartSimulation();

    while (true) {
      try {
        Thread.sleep(10);
      } catch (final Exception e) {
      }
    }
  }
}
