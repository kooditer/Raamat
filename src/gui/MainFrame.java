package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private FormPanel formPanel;
    private Toolbar toolbar;
    private Controller controller;




    public MainFrame() {
        super("Raamatud");
        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        controller = new Controller();


        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                //System.out.println(text);
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(FormEvent e) {
                controller.makeRaamat(e);


            }
        });



        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
