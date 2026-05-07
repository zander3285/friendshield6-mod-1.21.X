package net._zander46_.friendshield.item.custom;

import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class WoodenElytraItem extends ElytraItem {

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.BIRCH_LOG);
    }

    public WoodenElytraItem(Settings settings) {
        super(settings);
    }
}
