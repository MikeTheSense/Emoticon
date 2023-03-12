package learnpatterns.MySimpleGraphic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TableView {
    private DefaultTableModel model;
    private JTable table;
    private Controller myController;


    public TableView(Controller myController) {
        this.myController = myController;
    }


    public Box buildTable()
    {
        DefaultTableModel model = new DefaultTableModel()
        {
            boolean[] canEdit = new boolean[]{
                    true, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        JTable table = new JTable(model);

        model.addColumn("x");
        model.addColumn("f(x)");
        this.model = model;
        this.table = table;
        var columnModel = table.getColumnModel();
        myController.setTableView(this);
        myController.setDataSet(new DataSet(new HashMap<>()));
        model.addTableModelListener(myController);
        JButton add = new JButton("Добавить");
        JButton remove = new JButton("Удалить");
        remove.addActionListener(myController);
        add.addActionListener(myController);
        JLabel jLabel = new JLabel("Таблица значений функции y(x)= a-(b/x)");
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(jLabel);
        contents.add(new JScrollPane(table));
        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(remove);
        contents.add(buttons);
        return contents;
    }

    public int insertRaw()
    {
        int idx = table.getSelectedRow();
        model.insertRow(idx + 1, new Object[]{"", ""});
        return idx + 1;
    }
    public Object deleteSelectedRaw()
    {
        int idx = table.getSelectedRow();
        if(idx<0) return null;
        Object obj = null;
        if (!(model.getValueAt(idx,1).toString().equals(""))) {
            obj = model.getValueAt(idx, 0);
        }
        model.removeRow(idx);
        return  obj;
    }
    public void updateRaw(int index)
    {
        model.setValueAt(1, index, 1);
    }
    public void updateRaw(int index, Double x)
    {
        model.setValueAt(x, index, 1);
    }
    public void correctValue(int index)
    {
        model.setValueAt(0, index, 0);
    }
    public void showDialog(String message)
    {
        JOptionPane.showMessageDialog(new JFrame(), "Такое значение не допустимо: "+message+ ";"+ "\n Пожалуйста используйте значение по модулю более 0.0001", "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
    public void showDialog()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Такое значение x уже существует", "Предупреждение",
                JOptionPane.ERROR_MESSAGE);
    }
}
