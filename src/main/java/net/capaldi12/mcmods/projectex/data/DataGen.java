package net.capaldi12.mcmods.projectex.data;

import net.capaldi12.mcmods.projectex.ProjectEX;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

// Is subscription enough?
@Mod.EventBusSubscriber(modid = ProjectEX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ProjectEX.LOGGER.info("Gathering data");

        DataGenerator gen = event.getGenerator();

        gen.addProvider(new PEXRecipeProvider(gen));

        ProjectEX.LOGGER.info("Data gathered");
    }
}
