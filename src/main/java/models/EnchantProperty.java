package com.ro.models;

import java.util.HashMap;
import java.util.Map;

public class EnchantProperty {

    private static final Map<Long, String> enchants;
    static {
        Map<Long, String> enc = new HashMap<>();
        enc.put(1L, "Max HP +%d");
        enc.put(2L, "Max SP +%d");
        enc.put(3L, "Str +%d");
        enc.put(4L, "Agi +%d");
        enc.put(5L, "Vit +%d");
        enc.put(6L, "Int +%d");
        enc.put(7L, "Dex +%d");
        enc.put(8L, "Luk +%d");
        enc.put(13L, "Atk +%d%%");
        enc.put(15L, "Aspd +%d");
        enc.put(18L, "Hit +%d");
        enc.put(19L, "Matk +%d");
        enc.put(17L, "Atk +%d");
        enc.put(22L, "Flee +%d");
        enc.put(24L, "Crit +%d");

        enc.put(37L, "Damage to Neutral Enemies +%d%%");
        enc.put(39L, "Damage to Water Enemies +%d%%");
        enc.put(41L, "Damage to Earth Enemies +%d%%");
        enc.put(43L, "Damage to Fire Enemies +%d%%");
        enc.put(45L, "Damage to Wind Enemies +%d%%");
        enc.put(47L, "Damage to Poison Enemies +%d%%");
        enc.put(49L, "Damage to Holy Enemies +%d%%");
        enc.put(51L, "Damage to Shadow Enemies +%d%%");
        enc.put(53L, "Damage to Ghost Enemies +%d%%");
        enc.put(55L, "Damage to Undead Property Enemies +%d%%");

        enc.put(97L, "Damage to Formless Enemies +%d%%");
        enc.put(98L, "Damage to Undead Race Enemies +%d%%");
        enc.put(100L, "Damage to Plant Enemies +%d%%");
        enc.put(102L, "Damage to Fish Enemies +%d%%");
        enc.put(104L, "Damage to Demi-Human Enemies +%d%%");

        enc.put(57L, "Magic Damage to Neutral Enemies +%d%%");
        enc.put(59L, "Magic Damage to Water Enemies +%d%%");
        enc.put(61L, "Magic Damage to Earth Enemies +%d%%");
        enc.put(63L, "Magic Damage to Fire Enemies +%d%%");
        enc.put(65L, "Magic Damage to Wind Enemies +%d%%");
        enc.put(67L, "Magic Damage to Poison Enemies +%d%%");
        enc.put(69L, "Magic Damage to Holy Enemies +%d%%");

        enc.put(107L, "Magic Damage to Formless Enemies +%d%%");
        enc.put(108L, "Magic Damage to Undead Race Enemies +%d%%");
        enc.put(112L, "Magic Damage to Fish Enemies +%d%%");
        enc.put(113L, "Magic Damage to Demon Enemies +%d%%");
        enc.put(115L, "Magic Damage to Angel Enemies +%d%%");
        enc.put(116L, "Magic Damage to Dragon Enemies +%d%%");

        enc.put(164L, "Critical Damage +%d%%");
        enc.put(166L, "Long-Ranged Damage +%d%%");
        enc.put(168L, "Skill Healing Recovery Rate +%d%%");
        enc.put(170L, "Variable Caste Time -%d%%");


        enchants = enc;
    }

    public static String getEnchant(long property) {
        if (enchants.containsKey(property)) {
            return enchants.get(property);
        }
        return "("+ property +") Unknown %d";
    }
}