package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.entity.ModEntities;
import com.blorbee.drowneddepths.entity.custom.MantisEntity;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.util.HammerUsageEvent;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.TEST_LOG, ModBlocks.STRIPPED_TEST_LOG);
        StrippableBlockRegistry.register(ModBlocks.TEST_WOOD, ModBlocks.STRIPPED_TEST_WOOD);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry flammables = FlammableBlockRegistry.getDefaultInstance();

        flammables.add(ModBlocks.TEST_LOG, 5, 5);
        flammables.add(ModBlocks.TEST_WOOD, 5, 5);
        flammables.add(ModBlocks.STRIPPED_TEST_LOG, 5, 5);
        flammables.add(ModBlocks.STRIPPED_TEST_WOOD, 5, 5);

        flammables.add(ModBlocks.TEST_LEAVES, 30, 60);
        flammables.add(ModBlocks.TEST_PLANKS, 5, 20);
    }

    public static void registerFuel() {
        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModItems.TEST_FOOD, context.baseSmeltTime() / 4);
        }));
    }

    public static void registerEvents() {
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
    }
}
