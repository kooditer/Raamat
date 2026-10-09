package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private FormPanel formPanel;
    private Toolbar toolbar;
    private Controller controller;
    private TabelPanel tablePanel;
    private JFileChooser fileChooser;




    public MainFrame() {
        super("Raamatud");
        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        controller = new Controller();
        tablePanel = new TabelPanel();

        fileChooser = new JFileChooser();

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        tablePanel.setData(controller.getRRaamat());
        tablePanel.setRaamatTableListener(new RaamatTableListener() {
            public void rowDeleted(int row){
                controller.removeRaamat(row);

            }
        });

        //add(textPanel, BorderLayout.CENTER);


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
                controller.makeRRaamat(e);
                tablePanel.refresh();


            }
        });

        setJMenuBar(createMenuBar());

        setMinimumSize(new Dimension(700,500));
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private JMenuBar createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportData = new JMenuItem("Export Data ...");
        JMenuItem importData = new JMenuItem("Import Data ...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

        JMenuItem showFormItem = new JCheckBoxMenuItem("Raamatu Info");
        showFormItem.setSelected(true);
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuItem.isSelected());
            }
        });

        menubar.add(fileMenu);
        menubar.add(windowMenu);

        importData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Faili ei õnnestunud üleslaadida.", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    //System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        exportData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Andmeid ei saanud faili salvestada.",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    //System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        importData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Kas sa soovid äpist lahkuda?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        return menubar;

    }
}
