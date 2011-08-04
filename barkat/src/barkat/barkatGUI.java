/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * barkatGUI.java
 *
 * Created on Mar 22, 2009, 2:33:42 PM
 */
package barkat;

import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.Robot;

/**
 *
 * @author nautilus
 */
public class barkatGUI extends javax.swing.JFrame implements ClipboardOwner {

    char map[] = new char[500];
    String OLPOPRAN = "bcdDgjkpsSrRtT";
    String KAR_OJOGGO = "\u0981\u0982\u0983\u0985\u0986\u0987\u0988\u0989\u098A\u098B\u098C\u098F\u0990\u0993\u0994\u0985\u09BE\u09BF\u09C0\u09C1\u09C2\u09C3\u09C7\u09C8\u09CB\u09CC\u09CD\u09CE\u09F7\u09FA\0";
    String BANJON = "কখগঘঙচছজঝঞটঠডঢণতথদধনপফবভমযরলশষসহয়ড়ঢ়";
    String KARS = "aeiIOuUR";
    char last, lastmap, caseO;
    boolean link;
    final int BANGLA = 0;
    final int ENGLISH = 1;
    final int NUM_OLPOPRAN = 14;
    final int NUM_KAR = 8;
    final int NUM_KAR_OJOGGO = 31;
    final int NUM_BANJON = 35;
    final int KAR = 128;
    final int MOHA = 256;
    final int DUMMY = java.awt.event.KeyEvent.VK_ESCAPE;
    final int DIFF = 32;
    int KEYBOARD_MODE = BANGLA;

    String title = "\u09AC\u09B0\u0995\u09A4 \u09AC\u09BE\u0982\u09B2\u09BE \u0987\u0989\u09A8\u09BF\u0995\u09CB\u09A1 \u09B2\u09C7-\u0986\u0989\u099F";

    /** Creates new form barkatGUI */
    public barkatGUI() {
        initComponents();
        initMap();
        textPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        CaretListener caretListener = new CaretListener() {

            public void caretUpdate(CaretEvent e) {
                int dot = e.getDot();
                int mark = e.getMark();

                if (dot == mark) {
                    try {
                        Rectangle cc = textPane.modelToView(dot);
                    //System.out.println("Caret text position: " + dot +", view location (x, y): (" + cc.x + ", " + cc.y + ")");
                    } catch (BadLocationException ble) {
                        //System.err.println("CTP: " + dot);
                    }
                } else if (dot < mark) {
                    //System.out.println("Selection from " + dot + " to " + mark);
                } else {
                    //System.out.println("Selection from " + mark + " to " + dot);
                }
            }
        };

        textPane.addCaretListener(caretListener);

        heading.setText(title);
        this.setTitle("BARKAT Bangla Unicode Layout");
        this.setLocation(135, 60);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        heading = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        viewLayout = new javax.swing.JButton();
        save = new javax.swing.JButton();
        lchange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        textPane.setFont(new java.awt.Font("SolaimanLipi", 0, 18)); // NOI18N
        textPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPaneKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textPane);

        heading.setFont(new java.awt.Font("SolaimanLipi", 0, 22));
        heading.setForeground(new java.awt.Color(255, 0, 0));
        heading.setText("");
        heading.setToolTipText("This is Barkat !");

        exit.setFont(new java.awt.Font("SolaimanLipi", 0, 16)); // NOI18N
        exit.setText("বন্ধ করুন");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        copy.setFont(new java.awt.Font("SolaimanLipi", 0, 16));
        copy.setText("লেখা টুকে নিন");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        viewLayout.setFont(new java.awt.Font("SolaimanLipi", 0, 16)); // NOI18N
        viewLayout.setText("লে-আউট দেখুন");
        viewLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLayoutActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("SolaimanLipi", 0, 16));
        save.setText("সংরক্ষন করুন");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        lchange.setFont(new java.awt.Font("SolaimanLipi", 0, 16)); // NOI18N
        lchange.setText("বাংলা");
        lchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lchangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(copy)
                        .addGap(32, 32, 32)
                        .addComponent(save)
                        .addGap(34, 34, 34)
                        .addComponent(exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lchange)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(viewLayout)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewLayout)
                    .addComponent(heading)
                    .addComponent(lchange))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copy)
                    .addComponent(exit)
                    .addComponent(save))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPaneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPaneKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        System.out.println("char : " + (int) ch);
        //System.out.println("const" + evt.VK_DEAD_ABOVEDOT + "  evt : " + );

        if(evt.isControlDown() && ch == 2)
        {
            if(KEYBOARD_MODE == ENGLISH)
                lchange.doClick();
            System.out.println("Changing layout to Bangla !");
            return ;
        }
        else if(evt.isControlDown() && ch == 5)
        {
            if(KEYBOARD_MODE == BANGLA)
                lchange.doClick();
            System.out.println("Changing layout to English !");
            return ;
        }

        if(KEYBOARD_MODE == ENGLISH)
            evt.setKeyChar(ch);
        else
        {
            
            
            if (ch == '\\') {
                evt.setKeyChar('\u09CE');
                lastmap = '\u09CE';
            } else if (ch == '-' && last == '-'){
                dummyKeyPress();
            }
            else if (lastmap == '\u09F7' && ch == '.') {
                dummyKeyPress();
            } 
            else if(ch == 'o' && isKAR(last)){
                evt.setKeyChar('\u0993');
                lastmap = '\u0993';
            }
            else if (ch == 'o' && lastmap > 255) {
                evt.setKeyChar('\0');
                lastmap = '\0';
            } else if (ch == 'g' && last == 'n') {
                dummyKeyPress();
            } else if (ch == 'g' && last == 'N') {
                dummyKeyPress();
            } else if (ch == 'G' && last == 'N') {
                dummyKeyPress();
            } else if (ch == 'i' && last == 'O') {
                dummyKeyPress();
            } else if (ch == 'u' && last == 'O') {
                dummyKeyPress();
            } else if (isKAR(ch) && lastmap > 255 && isKAR_JOGGO(lastmap) && link == true) {
                if (ch == 'O')
                    caseO = lastmap;
                System.out.println("the character is a KAR !");
                evt.setKeyChar(map[ch + KAR]);
                lastmap = map[ch + KAR];
            } else if (ch == 'h' && isOLPOPRAN(last)) {
                dummyKeyPress();
            }else if(ch == DUMMY){
                //after performing dummy key ....
                if(last == 'g' && lastmap == map['n']){
                    evt.setKeyChar('\u0982');
                    lastmap = '\u0982';
                }else if(last == 'g' && lastmap == map['N']){
                    evt.setKeyChar('\u0999');
                    lastmap = '\u0999';
                }else if(last == 'G' && lastmap == map['N']){
                    evt.setKeyChar('\u099E');
                    lastmap = '\u099E';
                }
                else if (last == '.'){
                    evt.setKeyChar('.');
                    lastmap = '\0';
                }else if(last == 'i'){
                    char temp;
                    if (isKAR_JOGGO(caseO)) {
                        temp = '\u09C8';
                    } else {
                        temp = '\u0990';
                    }
                    evt.setKeyChar(temp);
                    lastmap = temp;
                    caseO = '\0';
                }else if(last == 'u'){
                    char temp;
                    if (isKAR_JOGGO(caseO)) {
                        temp = '\u09CC';
                    } else {
                        temp = '\u0994';
                    }
                    evt.setKeyChar(temp);
                    lastmap = temp;
                    caseO = '\0';
                }
                else if(isOLPOPRAN(last)){
                    evt.setKeyChar(map[last+MOHA]);
                    lastmap = map[last+MOHA];
                }
                else if(last == '-'){
                    evt.setKeyChar('\u2014');
                    lastmap = '\u2014';
                }
            }
            else if(isKAR_JOGGO(map[ch]) && last == ch && link==true){
                System.out.println("in exception !!    ch: "+ (int)ch + "   last: "+ (int)last + "   lastmap: "+ lastmap);
                evt.setKeyChar('\u09CD');
                lastmap = '\u09CD';
                last = 0;
                ch = DUMMY;
                
            }
            else {
                evt.setKeyChar(map[ch]);
                if(ch != java.awt.event.KeyEvent.VK_BACK_SPACE){
                    lastmap = map[ch];
                    caseO = '\0';
                }
            }
            
            if(ch == java.awt.event.KeyEvent.VK_BACK_SPACE){
                link = false;
            }
            else
                link = true;

            if(ch != java.awt.event.KeyEvent.VK_BACK_SPACE && ch != 'h' && ch != DUMMY){
                last = ch;
            }
            System.out.println("last : " + (int) last + "  lastmap : " + (int) lastmap);
        }
    }//GEN-LAST:event_textPaneKeyTyped

    public void dummyKeyPress(){
        System.out.println("firing dummy key ");
        Robot rb;
        try {
            rb = new Robot();
            rb.keyPress(java.awt.event.KeyEvent.VK_BACK_SPACE);
            rb.keyRelease(java.awt.event.KeyEvent.VK_BACK_SPACE);
            rb.keyPress(java.awt.event.KeyEvent.VK_BACK_SPACE);
            rb.keyRelease(java.awt.event.KeyEvent.VK_BACK_SPACE);
            link = true;
            rb.keyPress(java.awt.event.KeyEvent.VK_ESCAPE);
            rb.keyRelease(java.awt.event.KeyEvent.VK_ESCAPE);
        } catch (AWTException ex) {
            Logger.getLogger(barkatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        System.exit(0);
    // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    public void setClipboardContents(String aString) {
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed

        setClipboardContents(textPane.getText());
    // TODO add your handling code here:
    }//GEN-LAST:event_copyActionPerformed

    private void viewLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLayoutActionPerformed

       new showLayout().setVisible(true);
        // TODO add your handling code here:
}//GEN-LAST:event_viewLayoutActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

       String text = textPane.getText();

       new saveText(text).setVisible(true);
    }//GEN-LAST:event_saveActionPerformed

    private void lchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lchangeActionPerformed

        String bang = "বাংলা";
        String eng = "ইংরেজী";
        
        if(KEYBOARD_MODE == BANGLA)
        {
            KEYBOARD_MODE = ENGLISH;
            lchange.setText(eng);
            viewLayout.setEnabled(false);
        }
        else
        {
            KEYBOARD_MODE = BANGLA;
            lchange.setText(bang);
            viewLayout.setEnabled(true);
        }
        //lchange.setText();
    }//GEN-LAST:event_lchangeActionPerformed

    void initMap() {
        last = lastmap = 0;

        int i;
        for (i = 0; i < (int) '0'; i++) {
            map[i] = (char) i;
        }

        for (i = '9' + 1; i < (int) 'A'; i++) {
            map[i] = (char) i;
        }

        for (i = 'Z' + 1; i < (int) 'a'; i++) {
            map[i] = (char) i;
        }

        for (i = 'z' + 1; i < 128; i++) {
            map[i] = (char) i;
        }

        map['a'] = '\u0986';
        map['a' + KAR] = '\u09BE';
        map['A'] = '\0';
        map['b'] = '\u09AC';
        map['b' + MOHA] = '\u09AD';
        map['B'] = '\0';
        map['c'] = '\u099A';
        map['c' + MOHA] = '\u099B';
        map['C'] = '\0';
        map['d'] = '\u09A6';
        map['d' + MOHA] = '\u09A7';
        map['D'] = '\u09A1';
        map['D' + MOHA] = '\u09A2';
        map['e'] = '\u098F';
        map['e' + KAR] = '\u09C7';
        map['E'] = '\0';
        map['f'] = '\u09AB';
        map['F'] = '\0';
        map['g'] = '\u0997';
        map['g' + MOHA] = '\u0998';
        map['G'] = '\u0997';
        map['h'] = '\u09B9';
        map['H'] = '\u0983';
        map['i'] = '\u0987';
        map['i' + KAR] = '\u09BF';
        map['I'] = '\u0988';
        map['I' + KAR] = '\u09C0';
        map['j'] = '\u099C';
        map['j' + MOHA] = '\u099D';
        map['J'] = '\0';
        map['k'] = '\u0995';
        map['k' + MOHA] = '\u0996';
        map['K'] = '\0';
        map['l'] = '\u09B2';
        map['L'] = '\0';
        map['m'] = '\u09AE';
        map['M'] = '\0';
        map['n'] = '\u09A8';
        map['N'] = '\u09A3';
        map['o'] = '\u0985';
        map['O'] = '\u0993';
        map['O' + KAR] = '\u09CB';
        map['p'] = '\u09AA';
        map['p' + MOHA] = '\u09AB';
        map['P'] = '\0';
        map['q'] = '\0';
        map['Q'] = '\0';
        map['r'] = '\u09B0';
        map['r' + MOHA] = '\u09DC';
        map['R'] = '\u098B';
        map['R' + KAR] = '\u09C3';
        map['R' + MOHA] = '\u09DD';
        map['s'] = '\u09B8';
        map['s' + MOHA] = '\u09B6';
        map['S'] = '\u09B6';
        map['S' + MOHA] = '\u09B7';
        map['t'] = '\u09A4';
        map['t' + MOHA] = '\u09A5';
        map['T'] = '\u099F';
        map['T' + MOHA] = '\u09A0';
        map['u'] = '\u0989';
        map['u' + KAR] = '\u09C1';
        map['U'] = '\u098A';
        map['U' + KAR] = '\u09C2';
        map['v'] = '\u09AD';
        map['V'] = '\0';
        map['w'] = '\0';
        map['W'] = '\0';
        map['x'] = '\0';
        map['X'] = '\0';
        map['y'] = '\u09DF';
        map['Y'] = '\0';
        map['z'] = '\u09AF';
        map['Z'] = '\0';

        map['+'] = '+';
        map['.'] = '\u09F7';
        map[':'] = map['H'];
        map['&'] = '\u0981';
        map['$'] = '\u09F3';

        map['0'] = '\u09E6';
        map['1'] = '\u09E7';
        map['2'] = '\u09E8';
        map['3'] = '\u09E9';
        map['4'] = '\u09EA';
        map['5'] = '\u09EB';
        map['6'] = '\u09EC';
        map['7'] = '\u09ED';
        map['8'] = '\u09EE';
        map['9'] = '\u09EF';
    }

    boolean isKAR_JOGGO(char ch) {
        int i;
        for (i = 0; i < NUM_BANJON; i++) {
            if (BANJON.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    boolean isKAR(char ch) {
        int i;
        for (i = 0; i < NUM_KAR; i++) {
            if (KARS.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    boolean isOLPOPRAN(char ch) {
        int i;
        for (i = 0; i < NUM_OLPOPRAN; i++) {
            if (OLPOPRAN.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("net.sourceforge.mlf.metouia.MetouiaLookAndFeel");
                //javax.swing.UIManager.setLookAndFeel("net.beeger.squareness.SquarenessLookAndFeel");
                } catch (Exception e) {
                    System.out.println(e);
                }
                new barkatGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copy;
    private javax.swing.JButton exit;
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lchange;
    private javax.swing.JButton save;
    private javax.swing.JTextPane textPane;
    private javax.swing.JButton viewLayout;
    // End of variables declaration//GEN-END:variables

    public void lostOwnership(Clipboard arg0, Transferable arg1) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}