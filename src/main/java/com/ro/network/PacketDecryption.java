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

        //System.out.println("["+ port +"] "+ packet);

        if (packet.contains(ITEM_IN_DEAL)) {
            enchantDetails(packet, port);
        }

    }
    /**
     * 0A 96 -> Item in deal [2]
     * xx xx xx -> Item ID [3]
     *  yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy yy -> unknowns [25]
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
            List<String> property1List = Arrays.asList(Arrays.copyOfRange(sepContent, 30, 32));
            List<String> property1ValueList = Arrays.asList(Arrays.copyOfRange(sepContent, 32, 35));
            List<String> property2List = Arrays.asList(Arrays.copyOfRange(sepContent, 35, 37));
            List<String> property2ValueList = Arrays.asList(Arrays.copyOfRange(sepContent, 37, 40));
            List<String> property3List = Arrays.asList(Arrays.copyOfRange(sepContent, 40, 42));
            List<String> property3ValueList = Arrays.asList(Arrays.copyOfRange(sepContent, 42, 45));
            List<String> property4List = Arrays.asList(Arrays.copyOfRange(sepContent, 45, 47));
            List<String> property4ValueList = Arrays.asList(Arrays.copyOfRange(sepContent, 47, 50));

            // Reverse
            Collections.reverse(itemIdList);
            Collections.reverse(property1List);
            Collections.reverse(property1ValueList);
            Collections.reverse(property2List);
            Collections.reverse(property2ValueList);
            Collections.reverse(property3List);
            Collections.reverse(property3ValueList);
            Collections.reverse(property4List);
            Collections.reverse(property4ValueList);

            // parse to info
            Item item = new Item(new BigInteger(String.join("", itemIdList), 16).longValue());
            item.addProperties(
                    new BigInteger(String.join("", property1List), 16).longValue(),
                    new BigInteger(String.join("", property1ValueList), 16).longValue()
            );
            item.addProperties(
                    new BigInteger(String.join("", property2List), 16).longValue(),
                    new BigInteger(String.join("", property2ValueList), 16).longValue()
            );
            item.addProperties(
                    new BigInteger(String.join("", property3List), 16).longValue(),
                    new BigInteger(String.join("", property3ValueList), 16).longValue()
            );
            item.addProperties(
                    new BigInteger(String.join("", property4List), 16).longValue(),
                    new BigInteger(String.join("", property4ValueList), 16).longValue()
            );

            System.out.println(item);

        }

    }
}
