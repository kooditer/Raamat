package gui;

import model.ZhanriModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class FormPanel extends JPanel {
    private JLabel pealkiriLabel;
    private JTextField pealkiriField;
    private JLabel autorLabel;
    private JTextField autorField;
    private JLabel aastaLabel;
    private JTextField aastaField;
    private JLabel zhanrLabel;
    private JComboBox zhanrCombo;
    private JLabel kasLaenutatudLabel;
    private JCheckBox laenutusCheckbox;
    private JLabel laenutajaLabel;
    private JTextField laenutajaField;
    private JButton saveBtn;
    private FormListener formListener;
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("LISA RAAMAT");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        pealkiriLabel = new JLabel("Pealkiri: ");
        pealkiriField = new JTextField(10);
        autorLabel = new JLabel("Raamatu autor: ");
        autorField = new JTextField(10);
        aastaLabel = new JLabel("Publitseeritud: ");
        aastaField = new JTextField(10);
        zhanrLabel = new JLabel("Raamatu zhanr: ");
        zhanrCombo = new JComboBox<>();
        kasLaenutatudLabel = new JLabel("Kas on laenutatud: ");
        laenutusCheckbox = new JCheckBox();
        laenutajaLabel = new JLabel("Laenutaja: ");
        laenutajaField = new JTextField(10);
        saveBtn = new JButton("Salvesta");

        saveBtn.setMnemonic(KeyEvent.VK_S);
        pealkiriLabel.setDisplayedMnemonic(KeyEvent.VK_P);
        pealkiriLabel.setLabelFor(pealkiriField);



        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement(new ZhanriKategooria(0, "Luuletused"));
        comboBoxModel.addElement(new ZhanriKategooria(1, "Eneseabi"));
        comboBoxModel.addElement(new ZhanriKategooria(2, "Lasteraamat"));
        comboBoxModel.addElement(new ZhanriKategooria(3, "Elulood"));
        comboBoxModel.addElement(new ZhanriKategooria(4, "Õpperaamat"));
        zhanrCombo.setModel(comboBoxModel);
        zhanrCombo.setSelectedIndex(0);

        laenutajaLabel.setEnabled(false);
        laenutajaField.setEnabled(false);
        laenutusCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = laenutusCheckbox.isSelected();
                laenutajaLabel.setEnabled(isTicked);
                laenutajaField.setEnabled(isTicked);
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pealkiri = pealkiriField.getText();
                String autor = autorField.getText();
                String aasta = aastaField.getText();
                ZhanriKategooria zhanr = (ZhanriKategooria) zhanrCombo.getSelectedItem();
                boolean laenutatud = laenutusCheckbox.isSelected();
                String laenutaja = laenutajaField.getText();

                FormEvent ev = new FormEvent(this, pealkiri, autor, aasta, zhanr.getId(),
                 laenutatud, laenutaja);

                if (formListener != null) {
                    formListener.formEventOccured(ev);

                }
                pealkiriField.setText("");
                autorField.setText("");
                aastaField.setText("");
                laenutusCheckbox.setSelected(false);
                laenutajaField.setText("");
                laenutajaLabel.setEnabled(false);
                laenutajaField.setEnabled(false);

            }
        });

        LayoutSettings();


    }

    public void LayoutSettings() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /// ////Pealkirjarida//////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(pealkiriLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(pealkiriField, gc);

        /// ///Autoririda////////

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(autorLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(autorField, gc);

        /// ///Aastarida///////

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(aastaLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(aastaField, gc);

        /// /Zhanririda////////

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(zhanrLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(zhanrCombo, gc);


        /// //Laenutaja checkboxrida///////

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(kasLaenutatudLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(laenutusCheckbox, gc);

        /// ////////Laenutajarida/////////

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(laenutajaLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(laenutajaField, gc);


        /// //////Nupurida/////////

        gc.weightx = 1;
        gc.weighty = 1.0;
        gc.gridx = 1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(saveBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

class ZhanriKategooria {
    private int id;
    private String text;

    public ZhanriKategooria(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return text;
    }
}

