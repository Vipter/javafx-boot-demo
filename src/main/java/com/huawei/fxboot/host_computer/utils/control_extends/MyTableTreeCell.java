package com.huawei.fxboot.host_computer.utils.control_extends;

import javafx.scene.control.Button;
import javafx.scene.control.TreeTableCell;

public class MyTableTreeCell extends TreeTableCell<TreeTableItem, TreeTableItem> {
    String columnID;

    public MyTableTreeCell(String columnID) {
        this.columnID = columnID;
    }

    @Override
    protected void updateItem(TreeTableItem item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setGraphic(null);
            if (columnID.equals("id"))
                this.setText(String.valueOf(item.id));
            else if (columnID.equals("name"))
                this.setText(item.name);
            else if (columnID.equals("model"))
                this.setText(item.model);
            else if (columnID.equals("status"))
                this.setText(item.status);
            else {
                Button btnOccupy = new Button("占用");
                this.setGraphic(btnOccupy);
            }

        }
    }
}
