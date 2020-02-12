package com.huawei.fxboot.host_computer.domain;

import com.huawei.fxboot.host_computer.utils.control_extends.MyCheckBox;

import java.util.Objects;

public class Equipment {
    private Integer id;

    private String name;

    private String model;

    private String status;

    private String occupy;

    public MyCheckBox checked = new MyCheckBox();

    public Equipment(Integer id, String name, String model, String status,String occupy) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.status = status;
        this.occupy = occupy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOccupy() {
        return occupy;
    }

    public MyCheckBox getChecked() {
        return checked;
    }

    public void setChecked(MyCheckBox checked) {
        this.checked = checked;
    }

    public void setOccupy(String occupy) {
        this.occupy = occupy;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id);
    }

}