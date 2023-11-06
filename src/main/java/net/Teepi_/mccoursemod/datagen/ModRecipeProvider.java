package net.Teepi_.mccoursemod.datagen;

import net.Teepi_.mccoursemod.MCCourseMod;
import net.Teepi_.mccoursemod.block.ModBlocks;
import net.Teepi_.mccoursemod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
            ModBlocks.NETHER_ALEXANDRITE_ORE.get(), ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

    private static final List<ItemLike> ALEXANDRITE_CRAFTABLES = List.of(ModBlocks.ALEXANDRITE_STAIRS.get(),
            ModBlocks.ALEXANDRITE_SLAB.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Raw Alexandrite to Raw Alexandrite Block
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                "mccourse:raw_alexandrite", "alexandrite", "mccourse:raw_alexandrite_block", "alexandrite");

        // Alexandrite Smeltables Smelting Recipe
        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");

        // Alexandrite Smeltables Blasting Recipe
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        // Alexandrite Item from Alexandrite Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Block from Alexandrite Item
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Slab from Alexandrite Block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Stairs from Alexandrite Block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Pressure Plate from Alexandrite Block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Button from Alexandrite Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.ALEXANDRITE_BUTTON.get(), 1)
                .requires(ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Fence from Alexandrite Block and Alexandrite
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_FENCE.get())
                .pattern("W#W")
                .pattern("W#W")
                .define('#', ModItems.ALEXANDRITE.get())
                .define('W', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Fence Gate from Alexandrite Block and Alexandrite
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_FENCE_GATE.get())
                .pattern("#W#")
                .pattern("#W#")
                .define('#', ModItems.ALEXANDRITE.get())
                .define('W', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        // Alexandrite Wall from Alexandrite Block
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_WALL.get())
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Door
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_DOOR.get(), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        // Alexandrite Trapdoor
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_TRAPDOOR.get(), 2)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

            // Alexandrite Sword
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ALEXANDRITE_SWORD.get())
                    .pattern("X")
                    .pattern("X")
                    .pattern("#")
                    .define('X', ModItems.ALEXANDRITE.get())
                    .define('#', Items.STICK)
                    .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(ModItems.ALEXANDRITE.get()).build()))
                    .save(pWriter);

            // Alexandrite Pickaxe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_PICKAXE.get())
                    .pattern("XXX")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('X', ModItems.ALEXANDRITE.get())
                    .define('#', Items.STICK)
                    .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(ModItems.ALEXANDRITE.get()).build()))
                    .save(pWriter);

            // Alexandrite Shovel
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_SHOVEL.get())
                    .pattern("X")
                    .pattern("#")
                    .pattern("#")
                    .define('X', ModItems.ALEXANDRITE.get())
                    .define('#', Items.STICK)
                    .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(ModItems.ALEXANDRITE.get()).build()))
                    .save(pWriter);

            // Alexandrite Axe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_AXE.get())
                    .pattern("XX")
                    .pattern("X#")
                    .pattern(" #")
                    .define('X', ModItems.ALEXANDRITE.get())
                    .define('#', Items.STICK)
                    .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(ModItems.ALEXANDRITE.get()).build()))
                    .save(pWriter);

            // Alexandrite Hoe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_HOE.get())
                    .pattern("XX")
                    .pattern(" #")
                    .pattern(" #")
                    .define('X', ModItems.ALEXANDRITE.get())
                    .define('#', Items.STICK)
                    .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(ModItems.ALEXANDRITE.get()).build()))
                    .save(pWriter);



    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MCCourseMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
