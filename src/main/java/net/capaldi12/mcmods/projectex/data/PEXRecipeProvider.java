package net.capaldi12.mcmods.projectex.data;

import moze_intel.projecte.gameObjs.registration.impl.ItemRegistryObject;
import net.capaldi12.mcmods.projectex.MatterType;
import net.capaldi12.mcmods.projectex.ProjectEX;
import net.capaldi12.mcmods.projectex.item.Matter;
import net.capaldi12.mcmods.projectex.registry.PEXItems;

import moze_intel.projecte.gameObjs.registries.PEItems;

import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

/**
 * <h1>Recipe Provider</h1>
 *
 * Handles creation of mod's recipes during data generation
 */
public class PEXRecipeProvider extends RecipeProvider {

    public PEXRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    // Creates resource location with mod as root
    private static ResourceLocation rl(String s) {
        return new ResourceLocation(ProjectEX.MOD_ID, s);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ProjectEX.LOGGER.info("Providing recipes");

        makeMatterRecipes(consumer);

//        ShapelessRecipeBuilder
//                .shapeless(PEXItems.getMatter(MatterType.CYAN).get())
//                .requires(PEXItems.getMatter(MatterType.YELLOW).get())
//                .unlockedBy("has_yellow_matter", has(PEXItems.getMatter(MatterType.YELLOW).get()))
//                .save(consumer, rl("cyan_matter_from_yellow"));
//
//        ShapedRecipeBuilder.shaped(PEXItems.getMatter(MatterType.CYAN).get(), 5)
//                .define('M', PEXItems.getMatter(MatterType.BLUE).get())
//                .pattern(" M ")
//                .pattern("MMM")
//                .pattern(" M ")
//                .unlockedBy("has_blue_matter", has(PEXItems.getMatter(MatterType.BLUE).get()))
//                .save(consumer);

        ProjectEX.LOGGER.info("Recipes provided");
    }

    private void makeMatterRecipes(Consumer<IFinishedRecipe> consumer) {
        Item redMatter = PEItems.RED_MATTER.get();
        Item fuel = PEItems.AETERNALIS_FUEL.get();

        for (MatterType type : MatterType.VALUES) {
            Matter resultMatter = PEXItems.getMatter(type).get();

            Item matter = type.ordinal() - 1 < 0 ? redMatter : PEXItems.getMatter(type.ordinal() - 1).get();

            String adv_name = "has_" + matter.getRegistryName().getPath();
            String recipe_name = resultMatter.getRegistryName().getPath();

            ShapedRecipeBuilder
                    .shaped(resultMatter)
                    .define('M', matter)
                    .define('F', fuel)
                    .pattern("FFF")
                    .pattern("MMM")
                    .pattern("FFF")
                    .unlockedBy(adv_name + "_h", has(matter))
                    .save(consumer, rl(recipe_name + "_h"));

            ShapedRecipeBuilder
                    .shaped(resultMatter)
                    .define('M', matter)
                    .define('F', fuel)
                    .pattern("FMF")
                    .pattern("FMF")
                    .pattern("FMF")
                    .unlockedBy(adv_name + "_v", has(matter))
                    .save(consumer, rl(recipe_name + "_v"));
        }
    }
}
