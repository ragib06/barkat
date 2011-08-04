

package barkat;
import javax.swing.*;

public class showLayout extends javax.swing.JFrame{
    private javax.swing.JLabel a;
    public showLayout() {
        a = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        a.setIcon(new javax.swing.ImageIcon("Blayout.jpg"));
        add(a);
        pack();
    }    
    
}
