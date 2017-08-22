package org.kvlt.shop;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;

public class ClientSearch {

    private TableForm tableForm;
    private TableModel model;
    private TableRowSorter<TableModel> sorter;
    private String searchText;

    public ClientSearch(TableForm tableForm) {
        this.tableForm = tableForm;
        model = this.tableForm.getTable().getModel();
        sorter = new TableRowSorter<>(model);

        this.tableForm.getTable().setRowSorter(sorter);
    }

    public ActionListener listener() {
        return e -> {
            searchText = tableForm.getFieldSearch().getText();
            if (searchText.isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                Log.$("aaaaaaaaaaaaaaaaaaa");
            }
        };
    }

/*    public DocumentListener documentListener() {
        return new DocumentListener() {

            private void sort() {
                searchText = tableForm.getFieldSearch().getText();
                if (searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                sort();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sort();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
    }*/

}