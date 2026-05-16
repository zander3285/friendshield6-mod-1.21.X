package net._zander46_.friendshield;


import com.mojang.brigadier.arguments.BoolArgumentType;
import net._zander46_.friendshield.block.ModBlocks;
import net._zander46_.friendshield.block.entity.ModBlockEntities;
import net._zander46_.friendshield.effect.ModEffects;
import net._zander46_.friendshield.item.ModItems;
import net._zander46_.friendshield.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Статические импорты делают код Brigadier НАМНОГО чище и читаемее
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;

public class FriendShield implements ModInitializer {
	public static final String MOD_ID = "friendshield";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.registerSounds();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntites();
		ModEffects.registerEffects();
		//ModVillagers.registerVillagers();


		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {

			dispatcher.register(literal("friendshield_mixins")
					// Проверка прав (1.21.11 Yarn): только для Гейм-мастеров/Админов
					.requires(source -> CommandManager.GAMEMASTERS_CHECK.allows(source.getPermissions()))

					// ВЕТКА 1: Фантомы
					.then(literal("exploding_phantoms")
							.then(argument("enabled", BoolArgumentType.bool())
									.executes(context -> {
										// 1. Получаем значение true/false из аргумента "enabled"
										boolean value = BoolArgumentType.getBool(context, "enabled");

										// 2. Вызываем твой метод
										ModCommandManager.setExplodingPhantomsMixin(value);

										// 3. Отправляем красивый фидбек
										String status = value ? "§aВКЛЮЧЕН" : "§cВЫКЛЮЧЕН";
										context.getSource().sendFeedback(() ->
												Text.literal("Миксин exploding_phantoms теперь " + status), false);

										return 1; // Успех
									})
							)
					) // Конец ветки фантомов

					// ВЕТКА 2: Элитры (вешается на тот же корень через .then)
					.then(literal("banned_elytra")
							.then(argument("enabled", BoolArgumentType.bool())
									.executes(context -> {
										boolean value = BoolArgumentType.getBool(context, "enabled");
										ModCommandManager.setBannedElytraMixin(value);

										String status = value ? "§aВКЛЮЧЕН" : "§cВЫКЛЮЧЕН";
										context.getSource().sendFeedback(() ->
												Text.literal("Миксин banned_elytra теперь " + status), false);

										return 1;
									})
							)
					) // Конец ветки элитр
			);

		});
	}
}