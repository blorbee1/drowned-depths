package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.util.ModTags;
import com.google.common.collect.Maps;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

// new ArmorMaterial(
// base durability
// map of each armor slot with a value to say the defense of that armor slot
// enchantment value
// equip sound
// toughness
// knockback resistance
// repair ingredient (tag)
// registry key for material

public class ModArmorMaterials {
    public static final RegistryKey<EquipmentAsset> TEST_ARMOR_MATERIAL_KEY = registerKey("test");
    public static final ArmorMaterial TEST_ARMOR = new ArmorMaterial(
            15,
            createDefenseMap(2, 4, 6, 2, 4),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f,
            0.0f,
            ModTags.Items.TEST_TOOL_MATERIALS,
            TEST_ARMOR_MATERIAL_KEY
    );

    public static final int BOOTS_INDEX = 36;
    public static final int LEGGINGS_INDEX = 37;
    public static final int CHESTPLATE_INDEX = 38;
    public static final int HELMET_INDEX = 39;

    private static RegistryKey<EquipmentAsset> registerKey(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(DrownedDepths.MOD_ID, name));
    }

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering armor materials for " + DrownedDepths.MOD_ID);
    }
}
