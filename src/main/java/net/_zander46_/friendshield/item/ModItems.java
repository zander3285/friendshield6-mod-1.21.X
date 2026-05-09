package net._zander46_.friendshield.item;

import net._zander46_.friendshield.FriendShield;
import net._zander46_.friendshield.ModEquipmentAssets;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

import java.util.function.Function;

public class ModItems {

    public static final Item WOODEN_ELYTRA = registerItem("wooden_elytra",
            setting -> new Item(
                    setting.maxDamage(300)
                        .component(DataComponentTypes.GLIDER, Unit.INSTANCE)
                        .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.CHEST)
                        .model(ModEquipmentAssets.WOODEN_ELYTRA)
                        .equipSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA)
                        .damageOnHurt(false).build())
                        .repairable(Items.BIRCH_LOG)

            ));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(FriendShield.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FriendShield.MOD_ID, name)))));
    }

    public static void registerModItems(){
        FriendShield.LOGGER.info("Registering Mod Items for " + FriendShield.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WOODEN_ELYTRA);
        });
    }
}