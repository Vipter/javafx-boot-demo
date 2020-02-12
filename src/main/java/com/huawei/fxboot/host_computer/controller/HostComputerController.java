package com.huawei.fxboot.host_computer.controller;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.service.EquipmentService;
import com.huawei.fxboot.host_computer.utils.control_extends.MyTableTreeCell;
import com.huawei.fxboot.host_computer.utils.control_extends.TreeTableItem;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import org.springframework.beans.factory.annotation.Autowired;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class HostComputerController implements Initializable {
    TreeTableView<TreeTableItem> treeTable;
    @Autowired
    EquipmentService equipmentService;
    @FXML
    AnchorPane splitBottomManagement;
    @FXML
    Pane bottomDevicePane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        treeTable = new TreeTableView<TreeTableItem>();
        bottomDevicePane.setVisible(false);
        bottomDevicePane.setManaged(false);
    }

    @FXML
    public void deviceClick() {
        initTreeTable();
        initTreeData();
        bottomDevicePane.setVisible(true);
        bottomDevicePane.setManaged(true);
        deviceDisplayBottomPane();
        splitBottomManagement.getChildren().add(treeTable);
    }

    private void initTreeTable() {
        // 添加多个列
        TreeTableColumn<TreeTableItem, TreeTableItem> columns[] = new TreeTableColumn[5];
        columns[0] = new TreeTableColumn("id");
        columns[1] = new TreeTableColumn("设备名称");
        columns[2] = new TreeTableColumn("设备类型");
        columns[3] = new TreeTableColumn("设备状态");
        columns[4] = new TreeTableColumn("操作");
        treeTable.getColumns().addAll(columns);

        // 定义每个列的列宽
        columns[0].setPrefWidth(100);
        columns[1].setPrefWidth(300);
        columns[2].setPrefWidth(300);
        columns[3].setPrefWidth(300);
        columns[4].setPrefWidth(100);
        // 设置 CellValueFactory (提供数据)
        Callback cellValueFactory = new Callback() {
            @Override
            public Object call(Object param) {
                CellDataFeatures p = (CellDataFeatures) param;
                return p.getValue().valueProperty();
            }
        };
        for (int i = 0; i < columns.length; i++) {
            columns[i].setCellValueFactory(cellValueFactory);
        }

        // 设置CellFactory，定义每一列的单元格的显示
        // 这里使用了lambda表达式，否则写起来太长了！
        columns[0].setCellFactory((param) -> {//定义显示
            return new MyTableTreeCell("id");
        });
        columns[1].setCellFactory((param) -> {
            return new MyTableTreeCell("name");
        });
        columns[2].setCellFactory((param) -> {
            return new MyTableTreeCell("model");
        });
        columns[3].setCellFactory((param)->{
            return new MyTableTreeCell("status");
        });
        columns[4].setCellFactory((param)->{
            return new MyTableTreeCell("operate");
        });
    }
    private void initTreeData() {
        // 根节点只是占一个位置
        TreeItem<TreeTableItem> root = new TreeItem<TreeTableItem>(new TreeTableItem());
        treeTable.setRoot( root );
        treeTable.setShowRoot(false);

        List<Equipment> list = equipmentService.getEquipments();
        for (Equipment equipment: list) {
            TreeTableItem data = new TreeTableItem(equipment);
            root.getChildren().add( new TreeItem(data));
        }
    }

    private void deviceDisplayBottomPane() {
        Button btnAdd = new Button("增加");
        btnAdd.setLayoutX(154.0);
        btnAdd.setLayoutY(19.0);
        Button btnDel = new Button("删除");
        btnDel.setLayoutX(265.0);
        btnDel.setLayoutY(19.0);
        Button btnEdit = new Button("修改");
        btnEdit.setLayoutX(207);
        btnEdit.setLayoutY(19.0);
        Button btnNextPage = new Button("下一页");
        btnNextPage.setLayoutX(520.0);
        btnNextPage.setLayoutY(19.0);
        bottomDevicePane.getChildren().addAll(btnAdd, btnDel, btnEdit, btnNextPage);
    }
    private void topoDisplayBottomPane(){
        Button btnTopo = new Button("拓扑");
    }
}
