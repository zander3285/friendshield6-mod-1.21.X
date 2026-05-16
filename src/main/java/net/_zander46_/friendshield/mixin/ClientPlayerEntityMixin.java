package net._zander46_.friendshield.mixin;

import net._zander46_.friendshield.ModCommandManager;
import net._zander46_.friendshield.effect.ModEffects;
import net._zander46_.friendshield.item.ModItems;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Замените на ваши реальные пути // Если VPN — ваш кастомный эффект

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @Inject(method = "tickMovement", at = @At(value = "FIELD", target = "Lnet/minecraft/client/network/ClientPlayerEntity;falling:Z", shift = At.Shift.AFTER))
    private void checkWoodenElytraFlightConditions(CallbackInfo ci) {
        if (!ModCommandManager.isBannedElytraMixinEnabled()) {
            return; // Просто выходим, оригинальный код Minecraft продолжит работу
        }

        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;

        // Работаем только если игрок сейчас летит на элитрах
        if (player.isGliding()) {
            ItemStack chestStack = player.getEquippedStack(EquipmentSlot.CHEST);

            // Замените StatusEffectsRegistry.VPN на ваше поле эффекта
            boolean hasVPN = player.hasStatusEffect(ModEffects.VPN);

            boolean shouldStop = false;

            // Условие 1: Деревянные элитры + есть эффект VPN -> Стоп
            if (chestStack.isOf(ModItems.WOODEN_ELYTRA) && hasVPN) {
                shouldStop = true;
            }

            // Условие 2: Обычные элитры + НЕТ эффекта VPN -> Стоп
            if (chestStack.isOf(Items.ELYTRA) && !hasVPN) {
                shouldStop = true;
            }

            if (shouldStop) {
                // Отправляем пакет серверу о прекращении полета
                player.stopGliding();
            }
        }
    }
}
