package net._zander46_.friendshield;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEquipmentAssets {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> WOODEN_ELYTRA =
            RegistryKey.of(REGISTRY_KEY, Identifier.of(FriendShield.MOD_ID, "wooden_elytra"));
}
