package org.kvlt.shop.org.kvlt.shop.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.jdesktop.xswingx.PromptSupport;
import org.kvlt.shop.OrderManager;
import org.kvlt.shop.org.kvlt.shop.utils.OMSettings;

import javax.swing.*;
import java.awt.*;

public class TableForm extends JFrame {

    private static final int W = 1024;
    private static final int H = 600;
    private static final String TITLE = "Таблица клиентов — " + OMSettings.$().getProperty("name");

    private JButton btnSearch;
    private JTextField fieldSearch;
    private JLabel labelSearch;
    private JTable clientTable;
    private JButton btnAdd;
    private JPanel tablePane;
    private JButton btnRemove;
    private JButton btnEdit;
    private JButton btnClear;

    public TableForm() {
        $$$setupUI$$$();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        Dimension paneDim = new Dimension(W, H);

        setContentPane(tablePane);
        setSize(paneDim);
        setPreferredSize(paneDim);
        setLocationRelativeTo(null);
        setTitle(TITLE);
        setMinimumSize(paneDim);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        registerListeners();

        getTable().getTableHeader().setReorderingAllowed(false);
        getTable().setRowHeight(40);

        PromptSupport.setPrompt("Любые данные клиента из таблицы", fieldSearch);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, fieldSearch);
    }

    private void registerListeners() {
        btnAdd.addActionListener(e -> {
            AdditionForm dialog = new AdditionForm(AdditionForm.ADD);
            dialog.pack();
            dialog.setVisible(true);
        });
        btnEdit.addActionListener(e -> {
            if (getTable().getSelectedRow() == -1) return;
            AdditionForm dialog = new AdditionForm(AdditionForm.EDIT);
            dialog.pack();
            dialog.setVisible(true);
        });
        btnRemove.addActionListener(e -> {
            int currentRow = getTable().getSelectedRow();

            if (currentRow == -1) return;

            int result = JOptionPane.showOptionDialog(null, "Удаление клиента",
                    "Вы уверены?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, null, null);

            if (result == JOptionPane.YES_OPTION) {
                int removeID = Integer.parseInt(getTable().getValueAt(currentRow, 0).toString());
                OrderManager.getDB().query("DELETE FROM clients WHERE id=" + removeID);
                OrderManager.getTableLoader().loadDB();
            }
        });
    }

    public JTable getTable() {
        return clientTable;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JPanel getTablePane() {
        return tablePane;
    }

    public JTextField getFieldSearch() {
        return fieldSearch;
    }

    private void createUIComponents() {

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        tablePane = new JPanel();
        tablePane.setLayout(new GridLayoutManager(3, 2, new Insets(5, 10, 5, 10), -1, -1));
        tablePane.setInheritsPopupMenu(false);
        tablePane.setMinimumSize(new Dimension(1024, 600));
        tablePane.setName("Таблица");
        tablePane.setPreferredSize(new Dimension(1024, 600));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        tablePane.add(panel1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        fieldSearch = new JTextField();
        fieldSearch.setText("");
        fieldSearch.setToolTipText("Введите данные для поиска");
        panel1.add(fieldSearch, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        labelSearch = new JLabel();
        labelSearch.setText("Поиск клиента");
        panel1.add(labelSearch, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnClear = new JButton();
        btnClear.setText("Очистить");
        panel1.add(btnClear, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnSearch = new JButton();
        btnSearch.setText("Найти");
        panel1.add(btnSearch, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        tablePane.add(panel2, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnAdd = new JButton();
        btnAdd.setText("[+]");
        panel2.add(btnAdd, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnRemove = new JButton();
        btnRemove.setText("[-]");
        panel2.add(btnRemove, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnEdit = new JButton();
        btnEdit.setText("Редактировать");
        panel2.add(btnEdit, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        tablePane.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        clientTable = new JTable();
        clientTable.setAutoResizeMode(4);
        clientTable.setDragEnabled(false);
        clientTable.setEnabled(true);
        clientTable.setFillsViewportHeight(true);
        clientTable.setRequestFocusEnabled(false);
        clientTable.setRowSelectionAllowed(true);
        scrollPane1.setViewportView(clientTable);
        labelSearch.setLabelFor(fieldSearch);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return tablePane;
    }
}
