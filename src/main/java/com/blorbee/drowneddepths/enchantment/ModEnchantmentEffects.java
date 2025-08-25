package com.blorbee.drowneddepths.enchantment;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.enchantment.custom.LightningStrikerEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends  EnchantmentEntityEffect> LIGHTNING_STRIKER =
            register("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> register(String name, MapCodec<? extends  EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(DrownedDepths.MOD_ID, name), codec);
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering enchantment effects for " + DrownedDepths.MOD_ID);
    }
}
