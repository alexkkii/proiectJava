import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class TableExample extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField secondDescriptionField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton modifyButton;
    private JButton darkModeButton;
    private JTextField newCategoryField;
    private JTextField newDescriptionField;
    private JTextField newSecondDescriptionField;
    private JButton changeCategoryName;
    private JButton changeDescriptionName;
    private JButton changeSecondDescriptionName;

    public TableExample() {
        super("Table Example");
        setLayout(new BorderLayout());
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columns = {"Category", "Description", "Second Description"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 9));
        categoryField = new JTextField();
        descriptionField = new JTextField();
        secondDescriptionField = new JTextField();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        modifyButton = new JButton("Modify");
        darkModeButton = new JButton("DarkMode");
        add(darkModeButton, BorderLayout.EAST);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Second Description:"));
        inputPanel.add(secondDescriptionField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(modifyButton);
        add(inputPanel, BorderLayout.SOUTH);

        JPanel columnPanel = new JPanel();
        columnPanel.setLayout(new GridLayout(1, 9));
        newCategoryField = new JTextField();
        newDescriptionField = new JTextField();
        newSecondDescriptionField = new JTextField();
        changeCategoryName = new JButton("Change Category Name");
        changeDescriptionName = new JButton("Change Description Name");
        changeSecondDescriptionName = new JButton("Change Second Description Name");
        columnPanel.add(new JLabel("New Category Name:"));
        columnPanel.add(newCategoryField);
        columnPanel.add(changeCategoryName);
        columnPanel.add(new JLabel("New Description Name:"));
        columnPanel.add(newDescriptionField);
        columnPanel.add(changeDescriptionName);
        columnPanel.add(new JLabel("New Second Description Name:"));
        columnPanel.add(newSecondDescriptionField);
        columnPanel.add(changeSecondDescriptionName);
        add(columnPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String category = categoryField.getText();
                String description = descriptionField.getText();
                String secondDescription = secondDescriptionField.getText();
                Object[] row = {category, description, secondDescription};
                model.addRow(row);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int lastRow = model.getRowCount() - 1;
                if (lastRow >= 0) {
                    model.removeRow(lastRow);
                }
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int lastRow = model.getRowCount() - 1;
                if (lastRow >= 0) {
                    String category = categoryField.getText();
                    String description = descriptionField.getText();
                    String secondDescription = secondDescriptionField.getText();
                    model.setValueAt(category, lastRow, 0);
                    model.setValueAt(description, lastRow, 1);
                    model.setValueAt(secondDescription, lastRow, 2);
                }
            }
        });
        darkModeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getBackground() == Color.BLACK && table.getForeground() == Color.GREEN) {
                    table.setBackground(null);
                    table.setForeground(null);
                } else {
                    table.setBackground(Color.BLACK);
                    table.setForeground(Color.GREEN);
                }
            }
        });
        changeCategoryName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newCategory = newCategoryField.getText();
                if (!newCategory.equals("")) {
                    model.setColumnIdentifiers(new Object[] {newCategory, model.getColumnName(1), model.getColumnName(2)});
                }
            }
        });
        changeDescriptionName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newDescription = newDescriptionField.getText();
                if (!newDescription.equals("")) {
                    model.setColumnIdentifiers(new Object[] {model.getColumnName(0), newDescription, model.getColumnName(2)});
                }
            }
        });
        changeSecondDescriptionName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newSecondDescription = newSecondDescriptionField.getText();
                if (!newSecondDescription.equals("")) {
                    model.setColumnIdentifiers(new Object[] {model.getColumnName(0), model.getColumnName(1), newSecondDescription});
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TableExample();
    }
}
