package com.ro.models;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private long id;
    private List<String> properties = new ArrayList<>();

    public Item(long id) {
        this.id = id;
    }

    public void addProperties(long valType, long val) {
        if (valType > 0 && val > 0) {
            this.properties.add(
                String.format(ItemEnchantProperty.getEnchant(valType), val)
            );
        }

    }

    @Override
    public String toString() {

        StringBuilder r = new StringBuilder("Item: " + this.id + " https://rune-nifelheim.com/item/" + this.id);
        for (String prop : properties) {
            r.append("\nProperty: ").append(prop);
        }

        return r.toString();
    }
}

