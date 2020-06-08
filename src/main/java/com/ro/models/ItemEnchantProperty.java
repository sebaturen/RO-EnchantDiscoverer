package com.ro.models;

import java.util.HashMap;
import java.util.Map;

public class ItemEnchantProperty {

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
        // 9
        // 10
        // 11
        // 12
        enc.put(13L, "Atk +%d%%");
        // 14
        enc.put(15L, "Aspd +%d");
        // 16
        enc.put(17L, "Atk +%d");
        enc.put(18L, "Hit +%d");
        enc.put(19L, "Matk +%d");
        // 20
        // 21
        enc.put(22L, "Flee +%d");
        // 23
        enc.put(24L, "Crit +%d");
        // 25 - 28
        enc.put(29L, "Wind Property Resistance +%d%%");
        // 36
        enc.put(37L, "Damage to Neutral Enemies +%d%%");
        //38
        enc.put(39L, "Damage to Water Enemies +%d%%");
        // 40
        enc.put(41L, "Damage to Earth Enemies +%d%%");
        // 42
        enc.put(43L, "Damage to Fire Enemies +%d%%");
        // 44
        enc.put(45L, "Damage to Wind Enemies +%d%%");
        // 46
        enc.put(47L, "Damage to Poison Enemies +%d%%");
        // 48
        enc.put(49L, "Damage to Holy Enemies +%d%%");
        // 50
        enc.put(51L, "Damage to Shadow Enemies +%d%%");
        // 52
        enc.put(53L, "Damage to Ghost Enemies +%d%%");
        // 54
        enc.put(55L, "Damage to Undead Property Enemies +%d%%");
        // 56
        enc.put(57L, "Magic Damage to Neutral Enemies +%d%%");
        // 58
        enc.put(59L, "Magic Damage to Water Enemies +%d%%");
        // 60
        enc.put(61L, "Magic Damage to Earth Enemies +%d%%");
        // 62
        enc.put(63L, "Magic Damage to Fire Enemies +%d%%");
        // 64
        enc.put(65L, "Magic Damage to Wind Enemies +%d%%");
        // 66
        enc.put(67L, "Magic Damage to Poison Enemies +%d%%");
        // 68
        enc.put(69L, "Magic Damage to Holy Enemies +%d%%");
        // 70
        enc.put(71L, "Magic Damage to Shadow Enemies +%d%%");
        // 72
        // 73
        // 74
        enc.put(75L, "Undead Property Enemy +%d%%");
        // 76 - 96
        enc.put(97L, "Damage to Formless Enemies +%d%%");
        enc.put(98L, "Damage to Undead Race Enemies +%d%%");
        enc.put(99L, "Damage to Brute Enemies +%d%%");
        enc.put(100L, "Damage to Plant Enemies +%d%%");
        enc.put(101L, "Damage to Insect Enemies +%d%%");
        enc.put(102L, "Damage to Fish Enemies +%d%%");
        enc.put(103L, "Damage to Demon Enemies +%d%%");
        enc.put(104L, "Damage to Demi-Human Enemies +%d%%");
        enc.put(105L, "Damage to Angel Enemies +%d%%");
        enc.put(106L, "Damage to Dragon Enemies +%d%%");
        enc.put(107L, "Magic Damage to Formless Enemies +%d%%");
        enc.put(108L, "Magic Damage to Undead Race Enemies +%d%%");
        // 109
        enc.put(110L, "Magic Damage to Plant Race Enemies +%d%%");
        // 111
        enc.put(112L, "Magic Damage to Fish Enemies +%d%%");
        enc.put(113L, "Magic Damage to Demon Enemies +%d%%");
        // 114
        enc.put(115L, "Magic Damage to Angel Enemies +%d%%");
        enc.put(116L, "Magic Damage to Dragon Enemies +%d%%");
        // 117 - 163
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