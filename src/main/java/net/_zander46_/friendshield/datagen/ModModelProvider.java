package net._zander46_.friendshield.datagen;

import net._zander46_.friendshield.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WOODEN_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARIA_BASS_MUSIC_DISC, Models.GENERATED);

        //itemModelGenerator.registerWithTextureSource(ModItems.WOODEN_ELYTRA, Models.);
    }


}
