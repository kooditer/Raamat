package gui;

import model.Raamat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RaamatuTableModel extends AbstractTableModel {

    private List<Raamat> db;
    private String[] colNames = {"ID", "Pealkiri", "Autor", "Aasta", "Zhanr", "Kas laenutatud", "Laenutaja"};

    @Override
    public String getColumnName(int column) {
        return colNames[column]; //kandilised sulud!!!!
    }

    public RaamatuTableModel() {

    }

    public void setData(List<Raamat> db) {
        this.db = db;

    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raamat raamat = db.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return raamat.getRaamatuId();
            case 1:
                return raamat.getPealkiri();
            case 2:
                return raamat.getAutor();
            case 3:
                return raamat.getAasta();
            case 4:
                return raamat.getZhanr();
            case 5:
                return raamat.isClicked();
            case 6:
                return raamat.getLaenutaja();

        }
        return null;
    }
}
