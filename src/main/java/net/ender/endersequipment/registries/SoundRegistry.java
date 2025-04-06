package net.ender.endersequipment.registries;

import net.ender.endersequipment.endersequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundRegistry {
    private static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, endersequipment.MOD_ID);



    // Anubis Spell Cast
    public static DeferredHolder<SoundEvent, SoundEvent> ANUBIS_SPELL_CAST = registerSoundEvent("anubis_cast");

    //Judgement Scale Cast
    public static DeferredHolder<SoundEvent, SoundEvent> JUDGEMENT_SPELL_CAST =registerSoundEvent("judgement_cast");


    //Anubis Divinity Spell End
    public static DeferredHolder<SoundEvent, SoundEvent> ANUBIS_DIVINITY_SPELL_END =registerSoundEvent("anubis_divinity_rasp");

    //PALE FLAME
    public static DeferredHolder<SoundEvent, SoundEvent> PALE_FLAME_START =registerSoundEvent("pale_flame_start");

    public static DeferredHolder<SoundEvent, SoundEvent> PALE_FLAME_END =registerSoundEvent("pale_flame_end");

    public static DeferredHolder<SoundEvent, SoundEvent> PALE_FLAME_CURSE =registerSoundEvent("cursed");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent
                (ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENT.register(eventBus);
    }






}
