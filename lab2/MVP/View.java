package MVP;

public class View {
  private static View instance;

  private View() {}

  // singleton here, used it main line 11
  public static View getInstance() {
    if (instance == null) {
      instance = new View();
    }
    return instance;
  }

  public void ShowMessage(final String msg) { System.out.println(msg); }
}
