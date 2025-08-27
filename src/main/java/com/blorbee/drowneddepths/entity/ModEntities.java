package com.blorbee.drowneddepths.entity;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.entity.custom.MantisEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MantisEntity> MANTIS = register("mantis", MantisEntity::new, SpawnGroup.CREATURE, 2.5f, 2f);

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory,
                                                             SpawnGroup spawnGroup, float collisionWidth, float collisionHeight) {
        Identifier id = Identifier.of(DrownedDepths.MOD_ID, name);
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);

        return Registry.register(Registries.ENTITY_TYPE, key,
                EntityType.Builder.create(factory, spawnGroup)
                        .dimensions(collisionWidth, collisionHeight).build(key));
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering entities for" + DrownedDepths.MOD_ID);
    }
}
