package gui;

import model.Raamat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TabelPanel extends JPanel{
    private JTable table;
    private RaamatuTableModel tableModel;
    private JPopupMenu popup;
    private RaamatTableListener listener;


    public TabelPanel() {

        tableModel = new RaamatuTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();

        JMenuItem eemaldaRaamat = new JMenuItem("Kustuta raamat");
        popup.add(eemaldaRaamat);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                int row = table.rowAtPoint(e.getPoint());
//                table.setColumnSelectionInterval(row, row);
//
//                System.out.println(row);
//                //super.mousePressed(e);
                if (e.getButton()==MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });
        eemaldaRaamat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rida = table.getSelectedRow();
                //System.out.println(rida);
                if (listener!=null) {
                    listener.rowDeleted(rida);
                    tableModel.fireTableRowsDeleted(rida, rida);
                }
            }
        });


        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

    }
    public void setData(List<Raamat>db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    public void setRaamatTableListener(RaamatTableListener listener) {
        this.listener = listener;
    }

}
