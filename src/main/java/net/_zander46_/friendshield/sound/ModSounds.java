package net._zander46_.friendshield.sound;

import net._zander46_.friendshield.FriendShield;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

        private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(FriendShield.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        FriendShield.LOGGER.info("Registering Mod Sounds for " + FriendShield.MOD_ID);
    }
}
