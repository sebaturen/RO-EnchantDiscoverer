package com.ro.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item {

    private long id;
    private long price;
    private long quantity;
    private long shopPosition;
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

    public void setPrice(long price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void addProperty(String[] itemData) {

        List<String> property1List = Arrays.asList(Arrays.copyOfRange(itemData, 30, 32));
        List<String> property1ValueList = Arrays.asList(Arrays.copyOfRange(itemData, 32, 35));
        List<String> property2List = Arrays.asList(Arrays.copyOfRange(itemData, 35, 37));
        List<String> property2ValueList = Arrays.asList(Arrays.copyOfRange(itemData, 37, 40));
        List<String> property3List = Arrays.asList(Arrays.copyOfRange(itemData, 40, 42));
        List<String> property3ValueList = Arrays.asList(Arrays.copyOfRange(itemData, 42, 45));
        List<String> property4List = Arrays.asList(Arrays.copyOfRange(itemData, 45, 47));
        List<String> property4ValueList = Arrays.asList(Arrays.copyOfRange(itemData, 47, 50));
        List<String> property5List = Arrays.asList(Arrays.copyOfRange(itemData, 50, 52));
        List<String> property5ValueList = Arrays.asList(Arrays.copyOfRange(itemData, 52, 55));

        // Reverse
        Collections.reverse(property1List);
        Collections.reverse(property1ValueList);
        Collections.reverse(property2List);
        Collections.reverse(property2ValueList);
        Collections.reverse(property3List);
        Collections.reverse(property3ValueList);
        Collections.reverse(property4List);
        Collections.reverse(property4ValueList);
        Collections.reverse(property5List);
        Collections.reverse(property5ValueList);

        // parse to info
        addProperties(
                new BigInteger(String.join("", property1List), 16).longValue(),
                new BigInteger(String.join("", property1ValueList), 16).longValue()
        );
        addProperties(
                new BigInteger(String.join("", property2List), 16).longValue(),
                new BigInteger(String.join("", property2ValueList), 16).longValue()
        );
        addProperties(
                new BigInteger(String.join("", property3List), 16).longValue(),
                new BigInteger(String.join("", property3ValueList), 16).longValue()
        );
        addProperties(
                new BigInteger(String.join("", property4List), 16).longValue(),
                new BigInteger(String.join("", property4ValueList), 16).longValue()
        );
        addProperties(
                new BigInteger(String.join("", property5List), 16).longValue(),
                new BigInteger(String.join("", property5ValueList), 16).longValue()
        );

    }

    @Override
    public String toString() {

        StringBuilder r = new StringBuilder("Item: " + this.id + " https://rune-nifelheim.com/item/" + this.id);
        if (this.quantity > 0) {
            r.append("\nQuantity: "+ this.quantity);
        }
        if (this.price > 0) {
            r.append("\n"+ String.format("Price: %,dz", this.price));
        }
        for (String prop : properties) {
            r.append("\nProperty: ").append(prop);
        }

        return r.toString();
    }
}

