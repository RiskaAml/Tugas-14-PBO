package com.mycompany.tablemodel;

import com.mycompany.entity.Penjualan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PenjualanTableModel extends AbstractTableModel {

    private final List<Penjualan> list;
    private final String[] columns = {
        "ID", "Customer", "Tanggal", "Total Harga", "Mobil"
    };

    public PenjualanTableModel(List<Penjualan> list) {
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
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Penjualan p = list.get(row);

        switch (col) {
            case 0: return p.getId();
            case 1:
                return (p.getCustomerId() != null)
                        ? p.getCustomerId().getNama()
                        : "";
            case 2: return p.getTanggal();
            case 3: return p.getTotalHarga();
            case 4:
                return (p.getMobilId() != null)
                        ? p.getMobilId().getMerk() + " " + p.getMobilId().getModel()
                        : "";
            default:
                return null;
        }
    }

    public Penjualan getPenjualanAt(int row) {
        return list.get(row);
    }
}
