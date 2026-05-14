package net._zander46_.friendshield.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tryAttack", at = @At("RETURN"))
    private void explodeOnPhantomAttack(ServerWorld world, Entity target, CallbackInfoReturnable<Boolean> cir) {
        // Проверяем: 1. Успешна ли атака? 2. Является ли атакующий фантомом?
        if (cir.getReturnValue() && (Object) this instanceof PhantomEntity phantom) {

            // Создаем взрыв
            // 3.0f - это сила взрыва обычного крипера
            world.createExplosion(
                    phantom,
                    phantom.getX(),
                    phantom.getY(),
                    phantom.getZ(),
                    3.0f,
                    World.ExplosionSourceType.MOB
            );

            // Если ты хочешь, чтобы фантом исчезал после взрыва (как крипер),
            // расскомментируй строку ниже:
            // phantom.discard();
        }
    }
}
