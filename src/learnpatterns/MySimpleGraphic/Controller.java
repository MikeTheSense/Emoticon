package learnpatterns.MySimpleGraphic;

import learnpatterns.MySimpleGraphic.CustomExceptions.DuplicateValueException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements TableModelListener, ActionListener {
    private DataSet dataSet;
    private GraphScene graphView;
    private TableView tableView;

    public Controller(DataSet dataSet, GraphScene myView) {
        this.dataSet = dataSet;
        this.graphView = myView;
    }

    public Controller(TableView tableView) {
        this.tableView = tableView;
    }
    public Controller() {}



    public Controller(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e.getSource();
        var exmp = (JButton)e.getSource();
        switch (exmp.getText()) {
            case "Добавить":
                tableView.insertRaw();
                break;
            case "Удалить":
                var object = tableView.deleteSelectedRaw();
                if (object !=null) {
                    dataSet.removePoint(object);
                    graphView.draw(dataSet);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        var row = e.getFirstRow();
        e.getType();
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn()!=1) {
            var model = (TableModel) e.getSource();
            Object data = model.getValueAt(row, 0);
            Object datay = model.getValueAt(row, 1);
            try {
                if (!(datay.toString().equals("")))
                dataSet.removePointByY(datay);
                tableView.updateRaw(row,dataSet.addPointGet(data));
            }
            catch (NumberFormatException ex)
            {
                tableView.showDialog(data.toString());
            }
            catch (NullPointerException ex)
            {
                tableView.showDialog("пустое поле");
            }
            catch (DuplicateValueException ex)
            {
                tableView.showDialog();
            }
        }
        else if(e.getType() == TableModelEvent.UPDATE && e.getColumn()==1)
            graphView.draw(dataSet);
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public GraphScene getGraphView() {
        return graphView;
    }

    public void setGraphView(GraphScene graphView) {
        this.graphView = graphView;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}
