package net._zander46_.friendshield.effect;

import net._zander46_.friendshield.FriendShield;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> VPN = registerStatusEffect("vpn",
            new VpnEffect(StatusEffectCategory.BENEFICIAL, 0x08D186));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(FriendShield.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        FriendShield.LOGGER.info("Registering Mod effects for " + FriendShield.MOD_ID);
    }
}
