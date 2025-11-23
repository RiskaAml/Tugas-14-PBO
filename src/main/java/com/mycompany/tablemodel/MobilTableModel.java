package com.mycompany.tablemodel;

import com.mycompany.entity.Mobil;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MobilTableModel extends AbstractTableModel {

    private final List<Mobil> list;
    private final String[] columns = {"ID", "Merk", "Model", "Tahun", "Harga"};

    public MobilTableModel(List<Mobil> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mobil m = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return m.getId();
            case 1: return m.getMerk();
            case 2: return m.getModel();
            case 3: return m.getTahun();
            case 4: return m.getHarga();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    // paling penting — untuk ambil objek saat klik tabel!
    public Mobil getMobilAt(int row) {
        return list.get(row);
    }
}
