//Developed by: Miranda Diaz Emmanuel
package Frames;

import javax.swing.UIManager;

public class MainClass {
public static void main(String[] args) throws InterruptedException {
    Presentation presentation = new Presentation();
        Login login = new Login();
        presentation.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                presentation.lbPorcentaje.setText(Integer.toString(i) + "%");
                presentation.bProgreso.setValue(i);
                if (i == 10 || i == 40 || i == 70) {
                    presentation.lbCargando.setText("Cargando.");
                }
                if (i == 20 || i == 50 || i == 80) {
                    presentation.lbCargando.setText("Cargando..");
                }
                if (i == 30 || i == 60 || i == 90) {
                    presentation.lbCargando.setText("Cargando...");
                }
                if (i == 100) {
                    presentation.setVisible(false);
                    login.setVisible(true);
                }
            }
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
