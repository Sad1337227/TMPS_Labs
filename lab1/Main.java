import MVP.View;
import MVP.Model;
import MVP.Presenter;
import conf.ConfigManager;
public class Main {
  public static void main(final String[] args) throws Exception {
    final ConfigManager configManager = new ConfigManager();
    configManager.Load();

    final Model model = new Model(configManager);
    final View view = new View();
    final Presenter presenter = new Presenter(view, model, configManager);

    presenter.StartSimulation();
    while (true) {
      try {
        Thread.sleep(10);
      } catch (final Exception e) {
      }
    }
  }
}
