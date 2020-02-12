package com.huawei.fxboot.host_computer.domain;

public class Link {
    private Integer id;
    private Integer routeId;
    private Integer switchId;
    private Integer firewallId;
    private String connectType;
    private String pointA;
    private String pointB;
    private String occupier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getSwitchId() {
        return switchId;
    }

    public void setSwitchId(Integer switchId) {
        this.switchId = switchId;
    }

    public Integer getFirewallId() {
        return firewallId;
    }

    public void setFirewallId(Integer firewallId) {
        this.firewallId = firewallId;
    }

    public String getConnectType() {
        return connectType;
    }

    public void setConnectType(String connectType) {
        this.connectType = connectType;
    }

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    public String getOccupier() {
        return occupier;
    }

    public void setOccupier(String occupier) {
        this.occupier = occupier;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", switchId=" + switchId +
                ", firewallId=" + firewallId +
                ", connectType='" + connectType + '\'' +
                ", pointA='" + pointA + '\'' +
                ", pointB='" + pointB + '\'' +
                ", occupier='" + occupier + '\'' +
                '}';
    }
}
