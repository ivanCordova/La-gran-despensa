//Methods General
package Methods;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class General {
    Methods.Sound sound = new Methods.Sound();

    public void close() {
        int message = JOptionPane.YES_NO_OPTION;
        sound.information();
        int answer = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO GO OUT?", "EXIT", message);
        if (answer == 0) {
            System.exit(0);
        }
    }
     public void clear(JTextField a, JComboBox b, JTextField c, JTextField d, JTextField e, JTextField f, JTextField g,JComboBox h, JTextField i ){
        a.setText("");
        b.setSelectedIndex(0);
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");
        g.setText("");
        h.setSelectedIndex(0);
        i.setText("");
    }
}
