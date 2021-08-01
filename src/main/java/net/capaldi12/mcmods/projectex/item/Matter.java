package net.capaldi12.mcmods.projectex.item;

import net.capaldi12.mcmods.projectex.MatterType;

import net.capaldi12.mcmods.projectex.ProjectEX;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>Matter Item</h1>
 *
 * Core crafting component of this mod
 * <p>
 * What matters are getting created depends on MatterType enum
 * @see MatterType
 */
public class Matter extends Item {
    // Type of this matter
    public MatterType type;

    public Matter(Properties prop, MatterType type) {
        super(prop);

        this.type = type;
    }

    /**
     * Registers matter items corresponding to existing matter types
     * @param r Deferred Register to register items in/with
     * @return Map of Registry Objects to access registered items
     */
    public static Map<MatterType, RegistryObject<Matter>> registerMatterItems(DeferredRegister<Item> r) {
        // So it looks like a good way to add matters like this. No way I am copy pasting same line 12 times

        Map<MatterType, RegistryObject<Matter>> map = new HashMap<>();

        for (MatterType type : MatterType.VALUES) {
            // Naming convention - for all matter-tiered items we prepend matter type
            String name = type.getSerializedName() + "_matter";

            map.put(type, // Set correspondence of matter type to created item
                    // Register item to deferred registry
                    r.register(name,
                            // Supplier - aka factory to get Item instance
                            () -> new Matter(new Properties().tab(ProjectEX.TAB), type)
                    )
            );
        }

        return map;
    }
}
