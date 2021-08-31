package net.capaldi12.mcmods.projectex.registry;

import net.capaldi12.mcmods.projectex.MatterType;
import net.capaldi12.mcmods.projectex.ProjectEX;
import net.capaldi12.mcmods.projectex.item.Matter;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

/**
 * <h1>Items Registry</h1>
 * Stores mod items
 * <p>
 * This is something between how it's made in ProjectE and tutorial
 */
public class PEXItems {
    // Deferred register is used to register all items in-game when it's time to
    // ProjectE uses it's own wrapped deferred register, but it's basically the same drill
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectEX.MOD_ID);

    // Here all added matters are stored
    public static final Map<MatterType, RegistryObject<Matter>> MATTERS = Matter.registerMatterItems(ITEMS);

    // Convenience methods to get respective matter items from matter types (or their ordinal)
    public static RegistryObject<Matter> getMatter(MatterType type) {
        return MATTERS.get(type);
    }
    public static RegistryObject<Matter> getMatter(int ordinal) {
        return MATTERS.get(MatterType.fromOrdinal(ordinal));
    }
}
