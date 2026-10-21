import javax.swing.SwingUtilities;
import view.LoginView;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LoginView tela = new LoginView();

            tela.setVisible(true);
        });
    }
}