package com.blorbee.drowneddepths.item.custom;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class FullSetArmorItem extends Item {
    protected ArmorMaterial armorMaterial;

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.TEST_ARMOR,
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 1 * 20, 1, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1 * 20, 1, false, false))).build();

    public FullSetArmorItem(ArmorMaterial armorMaterial, EquipmentType equipmentType, Settings settings) {
        super(settings.armor(armorMaterial, equipmentType));
        this.armorMaterial = armorMaterial;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(DrownedDepths.BOOTS_INDEX);
        ItemStack leggings = player.getInventory().getStack(DrownedDepths.LEGGINGS_INDEX);
        ItemStack chestplate = player.getInventory().getStack(DrownedDepths.CHESTPLATE_INDEX);
        ItemStack helmet = player.getInventory().getStack(DrownedDepths.HELMET_INDEX);
        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            List<StatusEffectInstance> statusEffects = entry.getValue();

            if (hasCorrectArmorOn(armorMaterial, player)) {
                addStatusEffectsForMaterial(player, armorMaterial, statusEffects);
            }
        }
    }

    private void addStatusEffectsForMaterial(PlayerEntity player, ArmorMaterial armorMaterial, List<StatusEffectInstance> statusEffects) {
        boolean hasPlayerEffect = statusEffects.stream().allMatch(inst -> player.hasStatusEffect(inst.getEffectType()));
        if (!hasPlayerEffect) {
            for (StatusEffectInstance inst : statusEffects) {
                player.addStatusEffect(new StatusEffectInstance(inst));
            }
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, PlayerEntity player) {
        Item boots = player.getInventory().getStack(DrownedDepths.BOOTS_INDEX).getItem();
        Item leggings = player.getInventory().getStack(DrownedDepths.LEGGINGS_INDEX).getItem();
        Item chestplate = player.getInventory().getStack(DrownedDepths.CHESTPLATE_INDEX).getItem();
        Item helmet = player.getInventory().getStack(DrownedDepths.HELMET_INDEX).getItem();

        if (!(boots instanceof FullSetArmorItem) || !(leggings instanceof FullSetArmorItem) || !(chestplate instanceof FullSetArmorItem) || !(helmet instanceof FullSetArmorItem))
            return false;

        return ((FullSetArmorItem) boots).getMaterial() == armorMaterial &&
                ((FullSetArmorItem) leggings).getMaterial() == armorMaterial &&
                ((FullSetArmorItem) chestplate).getMaterial() == armorMaterial &&
                ((FullSetArmorItem) helmet).getMaterial() == armorMaterial;
    }

    public ArmorMaterial getMaterial() { return this.armorMaterial; }
}
