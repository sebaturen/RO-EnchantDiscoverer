package com.ro.network;

import com.ro.models.Item;

import java.math.BigInteger;
import java.util.*;

public class PacketDecryption {

    public PacketDecryption() {

    }

    /**
     * All packet is in reverse direction [mirror]
     */
    public void decryption(String packet, int port) {

        //System.out.println("packet ["+ port +"] "+ packet);

        if (packet.contains(ITEM_IN_DEAL)) {
            enchantDetails(packet, port);
        }

        if (packet.contains(SHOP_VIP_INFO)) {
            shopDetailVip(packet, port);
        }

        if (packet.startsWith(SHOP_STANDARD_INFO)) {
            shopDetailStandard(packet, port);
        }

    }
    /**
     * 0A 96 -> Item in deal [2]
     * xx xx xx -> Item ID [3]
     *  yy ...... yy -> unknowns [25]
     * zz zz -> Property 1 [2]
     * ll ll ll -> Value property 1 [3]
     * hh hh -> Property 2 [2]
     * ii ii ii -> Value property 2 [3]
     * kk kk -> Property 3 [2]
     * oo oo oo -> Value property 3 [3]
     * qq qq -> Property 4 [2]
     * aa aa aa -> Value property 4 [3]
     * size: 61
     * @param packet
     * @param port
     */
    private static final String ITEM_IN_DEAL = "96 0A";
    private static final int ITEM_IN_DEAL_SIZE = 61;
    private void enchantDetails(String packet, int port) {
        System.out.println("["+ port +"] "+ packet);

        for (int index = packet.indexOf(ITEM_IN_DEAL);
             index >= 0;
             index = packet.indexOf(ITEM_IN_DEAL, index + 1))
        {
            String packContent = packet.substring(index, index + (ITEM_IN_DEAL_SIZE*2)+(ITEM_IN_DEAL_SIZE-1));
            String[] sepContent = packContent.split(" ");

            // Packet content
            List<String> itemIdList = Arrays.asList(Arrays.copyOfRange(sepContent, 2, 4));

            // Reverse
            Collections.reverse(itemIdList);

            // parse to info
            Item item = new Item(new BigInteger(String.join("", itemIdList), 16).longValue());
            item.addProperty(sepContent);

            System.out.println(item);

        }

    }

    /**
     * 0A 8D -> Shop open [2]
     * xx .... xx -> Time to left [15]
     * yy .... yy -> Shop Item info [63]
     */
    private static final String SHOP_VIP_INFO = "8D 0A";
    private static final int SHOP_VIP_INFO_SIZE = 80;
    private void shopDetailVip(String packet, int port) {

        System.out.println("["+ port +"] "+ packet);

        String[] sepContent = packet.split(" ");
        sepContent = Arrays.copyOfRange(sepContent, 17, sepContent.length); // remove packet en time to left

        System.out.println("Items: "+ Arrays.toString(sepContent));
        itemInShop(sepContent);

    }

    /**
     * 08 00 -> Shop open [2]
     * xx .... xx -> unknown [10]
     * yy ...... yy -> Item data [63]
     * more items...
     * @param packet
     * @param port
     */
    private static final String SHOP_STANDARD_INFO = "00 08";
    private static final int SHOP_STANDARD_INFO_SIZE = 75;
    private void shopDetailStandard(String packet, int port) {

        System.out.println("["+ port +"] "+ packet);

        String[] sepContent = packet.split(" ");
        sepContent = Arrays.copyOfRange(sepContent, 12, sepContent.length); // remove packet en time to left

        System.out.println("Items: "+ Arrays.toString(sepContent));

        itemInShop(sepContent);


    }

    private void itemInShop(String[] sepContent) {

        // foreach items
        do {
            String[] itemData = Arrays.copyOf(sepContent, 63);

            // Packet content
            List<String> priceList = Arrays.asList(Arrays.copyOfRange(itemData, 0, 4));
            List<String> quantityList = Arrays.asList(Arrays.copyOfRange(itemData, 4, 5));
            List<String> itemIdList = Arrays.asList(Arrays.copyOfRange(itemData, 9, 11));


            // Reverse
            Collections.reverse(priceList);
            Collections.reverse(quantityList);
            Collections.reverse(itemIdList);

            // Object
            Item item = new Item(new BigInteger(String.join("", itemIdList), 16).longValue());
            item.setPrice(new BigInteger(String.join("", priceList), 16).longValue());
            item.setQuantity(new BigInteger(String.join("", quantityList), 16).longValue());
            item.addProperty(Arrays.copyOfRange(itemData, 2, itemData.length));

            System.out.println(item);
            // Next item
            sepContent = Arrays.copyOfRange(sepContent, itemData.length, sepContent.length);
        } while (sepContent.length >= 63);

    }

}
