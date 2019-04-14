package Task1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Task5 {

    private JPanel task5;

    private JTextField text;
    private JButton addToTableBtn;
    private JButton MoveRightBtn;
    private JButton MoveLeftBtn;

    private JTable table;
    private MyTableModel model;
    private java.util.List<String[]> info;

    public Task5(){
        task5 = new JPanel();
        panelSettingsMethod(task5);
        text = new JTextField();

        addToTableBtn = new JButton("Добавить в таблицу");
        MoveRightBtn = new JButton("Move right");
        MoveLeftBtn = new JButton("Move left");

        info = new ArrayList<>();
        model = new MyTableModel(info);
        table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(250, 100));

        addToTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!text.getText().equals("")) {
                    String[] s = {text.getText(), null};
                    info.add(s);
                    text.setText("");

                    model.fireTableDataChanged();
                }
            }
        });

        MoveRightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = -1;
                row = table.getSelectedRow();
                if(row != -1 && notNull(row, 0)) {
                    String[] sNew = {null, (String) model.getValueAt(row, 0)};
                    info.set(row, sNew);
                    model.fireTableDataChanged();
                }
            }
        });

        MoveLeftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = -1;
                row = table.getSelectedRow();
                if(row != -1 && notNull(row, 1)) {
                    String[] sNew = {(String) model.getValueAt(row, 1), null};
                    info.set(row, sNew);
                    model.fireTableDataChanged();
                }
            }
        });

        task5.setLayout(new BoxLayout(task5, BoxLayout.Y_AXIS));
        task5.add(text);
        task5.add(table);
        task5.add(addToTableBtn);
        task5.add(MoveRightBtn);
        task5.add(MoveLeftBtn);


    }
    public void panelSettingsMethod(JPanel panel){
        // panel.setPreferredSize(new Dimension(200,120));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)));

    }

    private boolean notNull(int row, int col){
        if (model.getValueAt(row, col) != null){
            return true;
        }else{
            return false;
        }
    }

    public JPanel getPanel() {
        return task5;
    }

    public class MyTableModel extends AbstractTableModel {

        java.util.List<String[]> info;

        MyTableModel(java.util.List<String[]> info) {
            super();
            this.info = info;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return info.size();
        }

        @Override
        public String getColumnName(int c) {
            return "";
        }

        @Override
        public Object getValueAt(int r, int c) {
            return info.get(r)[c];
        }

    }
}
