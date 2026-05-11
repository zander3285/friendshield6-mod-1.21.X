package net._zander46_.friendshield.mixin;

import net._zander46_.friendshield.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Замените на ваш реальный путь к классу предметов мода

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {

    @Inject(
            method = "use",
            at = @At("HEAD"),
            cancellable = true
    )
    private void preventWoodenElytraBoost(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        // Проверяем, летит ли игрок (так как в оригинале проверка идет первой)
        if (user.isGliding()) {
            // Получаем предмет в слоте нагрудника
            ItemStack chestStack = user.getEquippedStack(EquipmentSlot.CHEST);

            // Проверяем, являются ли надетые элитры деревянными
            if (chestStack.isOf(ModItems.WOODEN_ELYTRA)) {
                // Возвращаем PASS (или FAIL), чтобы предотвратить использование ракеты
                cir.setReturnValue(ActionResult.PASS);
            }
        }
    }
}
