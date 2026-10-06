package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton btn1;
    private JButton btn2;
    private TextPanel textPanel;
    private StringListener textListener;

    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
        btn1 = new JButton("Nupp1");
        btn2 = new JButton("Nupp2");
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(btn1);
        add(btn2);

    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Toolbar nupp vajutatud");
        JButton clicked = (JButton) e.getSource();

        if (clicked == btn1) {
            if (textListener != null) {
                textListener.textEmitted("Nupp1\n");
            }
            //System.out.println("BTN1");
            //textPanel.appendText("BTN1\n");
        }
        else if (clicked ==btn2) {
            if (textListener != null) {
                textListener.textEmitted("Nupp2\n");
            }

            //System.out.println("BTN2");
            //textPanel.appendText("BTN2\n");
        }

    }
}
