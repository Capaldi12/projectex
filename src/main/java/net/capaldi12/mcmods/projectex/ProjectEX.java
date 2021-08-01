package net.capaldi12.mcmods.projectex;

import net.capaldi12.mcmods.projectex.registry.PEXItems;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <h1>Project EX</h1>
 *
 * Main mod class
 * <p>
 * Controls mod initialization and even handling
 */
@Mod(ProjectEX.MOD_ID)
public class ProjectEX
{
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "projectex";

    // Author also uses this in @Mod, but it seems it works differently now:
    // the only thing @Mod accepts is `value` - mod id
    public static final String MOD_NAME = "Project EX";
    public static final String VERSION = "0.0.0.projectex";

    // Will use this bus to get events in other classes
    public static IEventBus BUS;

    // Creative tab - now Item Group
    public static final ProjectEXGroup TAB = new ProjectEXGroup(MOD_ID + "_tab");

    public static class ProjectEXGroup extends ItemGroup {
        public ProjectEXGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            // This is another placeholder for now
            return PEXItems.MATTERS.get(MatterType.MAGENTA).get().getDefaultInstance();
            // When I get to items
            //return new ItemStack(ProjectEXItems.PERSONAL_LINK);
        }


    }


    public ProjectEX() {
        BUS = FMLJavaModLoadingContext.get().getModEventBus();
        // I assumed I can just add @SubscribeEvent annotation for this, but, apparently, I can not.
        // Well, I can, but both methods end up never being called
        // Still can't see difference between this two and onServerStarting
        BUS.addListener(this::setup);
        BUS.addListener(this::doClientStuff);

        // Register mod items
        PEXItems.ITEMS.register(BUS);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // Keeping this, so I can use it later if I need
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

/* Inter-Mod communications. Doesn't seem I need them
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("projectex", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
*/



/* Class to contain RegistryEvents handlers. Can't I handle them in mod class itself?
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
*/
}
