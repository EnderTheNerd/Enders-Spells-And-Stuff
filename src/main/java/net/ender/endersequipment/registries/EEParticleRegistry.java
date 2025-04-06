package net.ender.endersequipment.registries;

import net.ender.endersequipment.endersequipment;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EEParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, endersequipment.MOD_ID);

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static final Supplier<SimpleParticleType> ANUBIS_ANKH = PARTICLE_TYPES.register("anubis_ankh", () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> GREATER_ANUBIS_ANKH = PARTICLE_TYPES.register("greater_anubis_ankh", () -> new SimpleParticleType(false));

}
