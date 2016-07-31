package com.example.priyanka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black Corporation on 01-03-2016.
 */
public class items {
    private String name;
    private String price;
    private String qty;
    public static List<items> itemsList = new ArrayList<items>();

    public items() {
        this.getItemsList();
    }

    public items(String name, String price){
        this.name = name;
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public static List<items> getItemsList() {
        return itemsList;
    }

    public static void setItemsList(List<items> itemsList) {
        items.itemsList = itemsList;
    }

}
