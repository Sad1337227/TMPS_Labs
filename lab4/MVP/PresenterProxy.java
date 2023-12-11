package MVP;
import interfaces.PresenterInterface;
import conf.ConfigManager;

public class PresenterProxy implements PresenterInterface {
  private static Presenter presenter;

  public PresenterProxy(){
    super();
  }

  public void StartSimulation(final View mainView, final Model model,
                              final ConfigManager configManager) {
    if (presenter == null) {
      presenter = new Presenter(mainView, model, configManager);
    }
    presenter.StartSimulation(mainView, model, configManager);
  }
}
