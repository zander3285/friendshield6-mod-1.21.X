package net._zander46_.friendshield.block.entity;

import net._zander46_.friendshield.FriendShield;
import net._zander46_.friendshield.block.ModBlocks;
import net._zander46_.friendshield.block.entity.custom.VpnBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<VpnBlockEntity> VPN_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FriendShield.MOD_ID, "vpn_be"),
                    FabricBlockEntityTypeBuilder.create(VpnBlockEntity::new, ModBlocks.VPN_BLOCK).build());

    public static void registerBlockEntites(){
        FriendShield.LOGGER.info("Registering BE for " + FriendShield.MOD_ID);

    }
}
