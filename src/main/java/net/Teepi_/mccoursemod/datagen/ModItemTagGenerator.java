package net.Teepi_.mccoursemod.datagen;

import net.Teepi_.mccoursemod.MCCourseMod;
import net.Teepi_.mccoursemod.block.ModBlocks;
import net.Teepi_.mccoursemod.item.ModItems;
import net.Teepi_.mccoursemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get(),
                    ModItems.ALEXANDRITE_CHESTPLATE.get(),
                    ModItems.ALEXANDRITE_LEGGINGS.get(),
                    ModItems.ALEXANDRITE_BOOTS.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
