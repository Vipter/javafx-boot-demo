package com.huawei.fxboot.host_computer.controller;

import com.huawei.fxboot.host_computer.domain.Equipment;
import com.huawei.fxboot.host_computer.domain.EquipmentTopoOccupy;
import com.huawei.fxboot.host_computer.domain.Link;
import com.huawei.fxboot.host_computer.domain.Topo;
import com.huawei.fxboot.host_computer.service.EquipmentService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.net.URL;
import java.util.*;

@FXMLController
public class HostTestController implements Initializable {
    //存储选中的设备
    Map<Integer, Pane> choiceNodeMap = new HashMap<>();
    //判断需要部署的设备是否被加载过，防止重复加载
    private Boolean isLoadEqu = false;
    @FXML
    Pane deviceLeftDisplay;
    @FXML
    Pane topoLeftDisplay;
    @FXML
    Pane btnDisplay;
    @FXML
    Pane deviceTableViewDisplay;
    @FXML
    Pane topoCanvasDisplay;
    @FXML
    Canvas canvas;
    //--------------按钮fx:id
    @FXML
    Button btnTopo;
    @FXML
    Button btnAdd;
    @FXML
    Button btnOccupy;
    @FXML
    Button btnRelease;
    @FXML
    Button btnConnect;
    @FXML
    Button btnDisConnect;
    //--------------

    //TableView fxid
    @FXML
    TableView<Equipment> tableView;
    @FXML
    TableColumn<Equipment, Number> tableColumnId;//数字类型 int  double等实现的是Observable<Number>接口
    @FXML
    TableColumn<Equipment, String> tableColumnName;
    @FXML
    TableColumn<Equipment, String> tableColumnModel;
    @FXML
    TableColumn<Equipment, String> tableColumnStatus;
    @FXML
    TableColumn<Equipment, String> tableColumnOccupy;
    @FXML
    TableColumn<Equipment, CheckBox> tableColumnOperate;
    //--------------
    @FXML
    ComboBox<Equipment> equComboBox1;//连接选项下拉列表
    @FXML
    ComboBox<Equipment> equComboBox2;
    @Autowired
    EquipmentService equipmentService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topoLeftDisplay.setVisible(false);
        topoLeftDisplay.setManaged(false);
        topoCanvasDisplay.setVisible(false);
        topoCanvasDisplay.setManaged(false);
        btnTopo.setVisible(false);
        showTabelView();
    }

    //展示TableView
    private void showTabelView() {
        ObservableList<Equipment> tabelList = FXCollections.observableArrayList();
        List<Equipment> equipmentList = equipmentService.getEquipments();

        tableColumnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        tableColumnName.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getName()));
        tableColumnModel.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getModel()));
        tableColumnStatus.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getStatus()));
        tableColumnOccupy.setCellValueFactory(cellDate -> new SimpleStringProperty(cellDate.getValue().getOccupy()));
        //调用封装了的checkbox的getCheckBox()方法，这里会返回一个ObservableValue<CheckBox>类型的checkbox
        tableColumnOperate.setCellValueFactory(cellData -> cellData.getValue().checked.getCheckBox());
        tabelList.addAll(equipmentList);
        tableView.setItems(tabelList);
    }

    @FXML
    public void deviceClick() {
        //隐藏topo页面
        topoLeftDisplay.setVisible(false);
        topoLeftDisplay.setManaged(false);
        topoCanvasDisplay.setVisible(false);
        topoCanvasDisplay.setManaged(false);
        btnTopo.setVisible(false);
        //显示设备页面
        deviceLeftDisplay.setVisible(true);
        deviceLeftDisplay.setManaged(true);
        deviceTableViewDisplay.setVisible(true);
        deviceTableViewDisplay.setManaged(true);

    }

    @FXML
    public void topoClick() {
        //显示topo页面
        topoLeftDisplay.setVisible(true);
        topoLeftDisplay.setManaged(true);
        topoCanvasDisplay.setVisible(false);
        topoCanvasDisplay.setManaged(false);
        btnTopo.setVisible(true);
        //隐藏设备页面
        deviceLeftDisplay.setVisible(false);
        deviceLeftDisplay.setManaged(false);
        deviceTableViewDisplay.setVisible(true);
        deviceTableViewDisplay.setManaged(true);
//        if (!isLoadEqu) {
//            topoLeftDisplayAddChildren();
//            isLoadEqu = true;
//        }

    }

    //加载选中的设备
    private Pane loadTopoEquipment(String equName, Integer equId) {
        Pane node = new StackPane();
        Circle circle = new Circle(20);
        circle.setStyle("-fx-fill: rgb(51,184,223)");
        Text text = new Text(equName);
        text.setStyle("-fx-fill: rgb(93,93,93);-fx-font-weight: bold;");
        node.setId(String.valueOf(equId));
        node.getChildren().addAll(circle, text);
        return node;
    }

    //静态私有类，存储位置
    private static class Position {
        double x;
        double y;
    }

    private void draggable(Node node) {
        //
        final Position pos = new Position();

        // 提示用户该结点可点击
        node.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> node.setCursor(Cursor.HAND));
        node.addEventHandler(MouseEvent.MOUSE_EXITED, event -> node.setCursor(Cursor.DEFAULT));

        // 提示用户该结点可拖拽
        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            node.setCursor(Cursor.MOVE);

            // 当按压事件发生时，缓存事件发生的位置坐标
            pos.x = event.getX();
            pos.y = event.getY();
        });
        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> node.setCursor(Cursor.DEFAULT));

        // 实现拖拽功能
        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double distanceX = event.getX() - pos.x;
            double distanceY = event.getY() - pos.y;

            double x = node.getLayoutX() + distanceX;
            double y = node.getLayoutY() + distanceY;
            // 计算出 x、y 后将结点重定位到指定坐标点 (x, y)
            x = x < 0.0 ? 0.0 : x;
            x = x > topoLeftDisplay.getPrefWidth() - 60 ? topoLeftDisplay.getPrefWidth() - 60 : x;
            y = y < 0 ? 0 : y;
            y = y > topoLeftDisplay.getPrefHeight() - 60 ? topoLeftDisplay.getPrefHeight() - 60 : y;
            node.relocate(x, y);
        });
    }

    @FXML
    public void btnSearchAction() {

    }

    @FXML
    public void btnNextAction() {

    }

    @FXML
    public void btnTopoAction() throws InterruptedException {
        deviceTableViewDisplay.setVisible(false);
        deviceTableViewDisplay.setManaged(false);
        topoCanvasDisplay.setVisible(true);
        topoCanvasDisplay.setManaged(true);
        double topoLeftX = topoLeftDisplay.getPrefWidth();
        System.out.println("topoLeftPreDisX:" + topoLeftDisplay.getPrefWidth());
        double topoLeftY = topoLeftDisplay.getPrefHeight();
        System.out.println("topoLeftPreDisY:" + topoLeftDisplay.getPrefWidth());

        double topoCanvasX = topoCanvasDisplay.getPrefWidth();
        double topoCanvasY = topoCanvasDisplay.getPrefHeight();

        double ratioX = topoCanvasX / topoLeftX;
        double ratioY = topoCanvasY / topoLeftY;

        ObservableList<Node> list = topoLeftDisplay.getChildren();
        for (Node node : list) {
            System.out.println(node.getId() + "(" + node.getLayoutX() + "," + node.getLayoutY() + ")");
            //取出其中的设备，设备有id标识，没有标识的为线
            if (node.getId() != null) {
                equipmentService.saveNodePosition(new Topo(Integer.parseInt(node.getId()), node.getLayoutX(), node.getLayoutY()));
                Thread.sleep(500);
            }
        }
        drawTopo(ratioX, ratioY);
    }

    private void drawTopo(double ratioX, double ratioY) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = null;
        List<EquipmentTopoOccupy> list = equipmentService.getTopoEquipment("vipter");
        for (EquipmentTopoOccupy topoMsg : list) {
            String model = topoMsg.getModel();
            if ("route".equals(model)) {
                image = new Image("images/route.png");
            } else if ("switch".equals(model)) {
                image = new Image("images/switch.png");
            } else if ("firewall".equals(model)) {
                image = new Image("images/firewall.png");
            }
            System.out.println("(" + topoMsg.getPosX() * ratioX + "," + topoMsg.getPosY() * ratioX + ")");
            gc.drawImage(image, topoMsg.getPosX() * ratioX, topoMsg.getPosY() * ratioY);
        }
        List<Link> linkList = equipmentService.getLink("vipter");
        if (linkList.size() > 0) {
            for (Link link : linkList) {
                String pointA[] = link.getPointA().split("-");
                String pointB[] = link.getPointB().split("-");
                gc.strokeLine((Double.parseDouble(pointA[0]))* ratioX, (Double.parseDouble(pointA[1])) * ratioY,
                        (Double.parseDouble(pointB[0])) * ratioX, (Double.parseDouble(pointB[1])) * ratioY);
            }
        }
        System.out.println("已画完");
    }

    @FXML
    public void btnDelAction() {
        ObservableList<Equipment> list = tableView.getItems();
        if (list.size() > 0) {
            for (Equipment equ : list) {
                if (equ.checked.isSelected()) {
                    list.remove(equ);
                    equipmentService.deleteEquipment(equ.getId());
                }
            }
        }
    }

    @FXML
    public void btnEditAction() {

    }

    @FXML
    public void btnAddAction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/test.fxml"));//getResource
        Stage dh = new Stage();
        dh.setTitle("菜单导航");
        Scene scene = new Scene(root, 600, 400);
        dh.setScene(scene);
        dh.show();

    }


    @FXML
    public void btnOccupyAction() {
        System.out.println("size:" + choiceNodeMap.size());
        double width = topoLeftDisplay.getPrefWidth();
        double height = topoLeftDisplay.getPrefHeight();
        ObservableList<Equipment> list = tableView.getItems();
        try {
            if (list.size() > 0) {
                for (Equipment equ : list) {
                    if (equ.checked.isSelected()) {
                        equipmentService.occupyEquipment("vipter", equ.getId());
                        equ.setOccupy("vipter");
                        //每占用一个生产一个显示设备的node
                        //todo 增加判断，如果这个设备对应的node已生产过，不在生产，后期考虑通过数据库记录每个设备生产记录
                        if (!choiceNodeMap.containsKey(equ.getId())) {
                            Pane node = loadTopoEquipment(equ.getName(), equ.getId());
                            equ.checked.setCheckFalse();
                            node.relocate((int) (Math.random() * (width - 60)), (int) (Math.random() * (height - 60)));
                            draggable(node);
                            equComboBox1.getItems().add(equ);
                            equComboBox2.getItems().add(equ);
                            topoLeftDisplay.getChildren().add(node);
                            choiceNodeMap.put(equ.getId(), node);
                        }
                        equ.checked.setCheckFalse();
                    }
                }
                tableView.refresh();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnReleaseAction() {
        ObservableList<Equipment> list = tableView.getItems();
        try {
            if (list.size() > 0) {
                for (Equipment equ : list) {
                    if (equ.checked.isSelected()) {
                        equipmentService.occupyEquipment(null, equ.getId());
                        equ.setOccupy(null);
                        equComboBox1.getItems().remove(equ);
                        equComboBox2.getItems().remove(equ);
                        //如果已选中的被释放，从map中移除
                        if (choiceNodeMap.containsKey(equ.getId())) {
                            topoLeftDisplay.getChildren().remove(choiceNodeMap.get(equ.getId()));
                        }
                        equ.checked.setCheckFalse();//取消勾选
                    }
                }
                tableView.refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Map<String, Line> lineMap = new HashMap<>();//后期考虑对line对象存入数据库

    @FXML
    public void btnConnectAction() {
        Object item1 = equComboBox1.getValue();
        Object item2 = equComboBox2.getValue();
        if (!item1.equals(item2)) {
            Equipment equ1 = (Equipment) item1;
            Equipment equ2 = (Equipment) item2;
            //根据id获取代表此设备的node
            Pane node1 = choiceNodeMap.get(equ1.getId());
            Pane node2 = choiceNodeMap.get(equ2.getId());
            // 创建直线
            Line line = new Line();
            // 将直线的起点坐标与 node1 的中心坐标进行绑定
            line.startXProperty().bind(node1.layoutXProperty().add(node1.widthProperty().divide(2)));
            line.startYProperty().bind(node1.layoutYProperty().add(node1.heightProperty().divide(2)));
            // 将直线的终点坐标与 node2 的中心坐标进行绑定
            line.endXProperty().bind(node2.layoutXProperty().add(node2.widthProperty().divide(2)));
            line.endYProperty().bind(node2.layoutYProperty().add(node2.heightProperty().divide(2)));
            lineMap.put(String.valueOf(equ1.getId()) + String.valueOf(equ2.getId()), line);
            topoLeftDisplay.getChildren().removeAll(node1, node2);
            topoLeftDisplay.getChildren().addAll(line, node1, node2);
            String pointA = node1.getLayoutX() + "-" + node1.getLayoutY();
            String pointB = node2.getLayoutX() + "-" + node2.getLayoutY();
            String idType1 = equ1.getModel() + "_id";
            String idType2 = equ2.getModel() + "_id";
            String connectType = equ1.getModel() + "-" + equ2.getModel();
            String sql = "insert into link (" + idType1 + "," + idType2 + ", connect_type ,point_a , point_b , occupy " + ") " +
                    "               values (" + equ1.getId() + "," + equ2.getId() + ",'" + connectType + "','" + pointA + "','" + pointB + "', 'vipter' )";
            System.out.println("sql:" + sql);
            equipmentService.insertConnectRelationship(sql);
        }

    }

    @FXML
    public void btnDisConnectAction() {
        Equipment equ1 = equComboBox1.getValue();
        Equipment equ2 = equComboBox2.getValue();
        if (!equ1.equals(equ2)) {
            Line line = lineMap.get(String.valueOf(equ1.getId()) + String.valueOf(equ2.getId()));
            topoLeftDisplay.getChildren().removeAll(line);
            String disSql = "delete from link where " + equ1.getModel() + "_id = " + equ1.getId() + " and " + equ2.getModel() + "_id = " + equ2.getId();
            System.out.println("disSql:" + disSql);
            equipmentService.disConnectRelationship(disSql);
        }
    }
}
