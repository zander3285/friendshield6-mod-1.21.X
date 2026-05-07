package net._zander46_.friendshield.item;

import net._zander46_.friendshield.FriendShield;
import net._zander46_.friendshield.item.custom.WoodenElytraItem;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FireworksComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item WOODEN_ELYTRA = registerItem("wooden_elytra", new WoodenElytraItem(new Item.Settings().maxDamage(300)));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(FriendShield.MOD_ID, name), item);
    }

    public static void registerModItems(){
        FriendShield.LOGGER.info("Registering Mod Items for " + FriendShield.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WOODEN_ELYTRA);
        });
    }
}
