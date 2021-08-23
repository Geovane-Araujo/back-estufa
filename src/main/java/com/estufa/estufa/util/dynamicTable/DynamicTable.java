package com.estufa.estufa.util.dynamicTable;

import com.atom.Ignore;

import java.io.Serializable;

public class DynamicTable implements Serializable {

    @Ignore
    private static final long serialVersionUID = 1L;

    private String route ="";
    private int pagging = 1;
    private String filters = "";
    private String orders ="";

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPagging() {
        return pagging;
    }

    public void setPagging(int pagging) {
        this.pagging = pagging;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}
