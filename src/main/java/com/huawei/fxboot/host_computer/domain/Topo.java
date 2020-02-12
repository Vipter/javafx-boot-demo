package com.huawei.fxboot.host_computer.domain;

public class Topo {
    private Integer id;

    private Integer equId;

    private Double posX;

    private Double posY;

    public Topo() {

    }

    public Topo(Integer equId, Double posX, Double posY) {
        this.equId = equId;
        this.posX = posX;
        this.posY = posY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Double getPosX() {
        return posX;
    }

    public void setPosX(Double posX) {
        this.posX = posX;
    }

    public Double getPosY() {
        return posY;
    }

    public void setPosY(Double posY) {
        this.posY = posY;
    }
}
