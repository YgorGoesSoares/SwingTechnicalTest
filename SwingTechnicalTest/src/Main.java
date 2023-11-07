import br.com.edamatec.view.ViewCadastro;
import br.com.edamatec.view.ViewLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewLogin view = new ViewLogin();
            JFrame frame = new JFrame("EDAMATEC - Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(view.panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
