package com.huawei.fxboot.host_computer.domain.entity;

public class LinkEntity {
    private Integer id;

    private Integer routeId;

    private Integer switchId;

    private Integer firewallId;

    private String connectType;

    private String pointA;

    private String pointB;

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
        this.connectType = connectType == null ? null : connectType.trim();
    }

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA == null ? null : pointA.trim();
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB == null ? null : pointB.trim();
    }
}