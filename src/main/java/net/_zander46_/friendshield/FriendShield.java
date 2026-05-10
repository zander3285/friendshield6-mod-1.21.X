package net._zander46_.friendshield;

import net._zander46_.friendshield.block.ModBlocks;
import net._zander46_.friendshield.block.entity.ModBlockEntities;
import net._zander46_.friendshield.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendShield implements ModInitializer {
	public static final String MOD_ID = "friendshield";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntites();
	}
}