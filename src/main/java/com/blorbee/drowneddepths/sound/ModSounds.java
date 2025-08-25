package com.blorbee.drowneddepths.sound;

import com.blorbee.drowneddepths.DrownedDepths;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent TEST_SOUND = register("test_sound");

    private static SoundEvent register(String name) {
        Identifier id = Identifier.of(DrownedDepths.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering sounds for " + DrownedDepths.MOD_ID);
    }
}
