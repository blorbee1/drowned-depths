package com.blorbee.drowneddepths.screen;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.screen.custom.PedestalScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL = register("pedestal_screen_handlder", PedestalScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, BlockPos> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(DrownedDepths.MOD_ID, name),
                new ExtendedScreenHandlerType<>(factory, BlockPos.PACKET_CODEC));
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering screen handlers for " + DrownedDepths.MOD_ID);
    }
}
