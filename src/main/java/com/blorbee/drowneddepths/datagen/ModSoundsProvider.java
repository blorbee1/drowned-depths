package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.sound.ModSounds;
import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {
    public ModSoundsProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registryLookup, SoundExporter exporter) {
        addSoundEvent(exporter, ModSounds.TEST_SOUND, SoundCategory.BLOCKS);
    }

    private void addSoundEvent(SoundExporter exporter, SoundEvent sound, SoundCategory category) {
        exporter.add(sound, SoundTypeBuilder.of(sound)
                .sound(SoundTypeBuilder.EntryBuilder.ofFile(Identifier.of(DrownedDepths.MOD_ID + ":" + sound.id().getPath())))
                .category(category)
                .subtitle(Util.createTranslationKey("sounds", sound.id())));
    }

    @Override
    public String getName() {
        return "Drowned Depths Sounds";
    }
}
