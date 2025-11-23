package com.mycompany.tablemodel;

import com.mycompany.entity.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomerTableModel extends AbstractTableModel {

    private final List<Customer> list;
    private final String[] columns = {"ID", "Nama", "Alamat", "No Telp", "Email"};

    public CustomerTableModel(List<Customer> list) {
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
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = list.get(rowIndex);

        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getNama();
            case 2: return c.getAlamat();
            case 3: return c.getNoTelp();
            case 4: return c.getEmail();
        }
        return null;
    }

    public Customer getCustomerAt(int row) {
        return list.get(row);
    }
}
