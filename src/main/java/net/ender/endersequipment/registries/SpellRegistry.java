package net.ender.endersequipment.registries;


import io.redspace.ironsspellbooks.api.spells.AbstractSpell;

import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.summoned_knight.SummonedKnight;
import net.ender.endersequipment.spells.blood.BloodWaveSpell;
import net.ender.endersequipment.spells.blood.BoilingBloodSpell;
import net.ender.endersequipment.spells.blood.RaiseKnightsSpell;
import net.ender.endersequipment.spells.blood.StrainSpell;


import net.ender.endersequipment.spells.eldritch.TentacleShieldSpell;
import net.ender.endersequipment.spells.ender.SupernovaSpell;
import net.ender.endersequipment.spells.evocation.SlashSpell;
import net.ender.endersequipment.spells.evocation.SummonRavagerSpell;
import net.ender.endersequipment.spells.fire.EruptionSpell;
import net.ender.endersequipment.spells.holy.AnglesBlessingSpell;
import net.ender.endersequipment.spells.holy.GreaterWispSpell;
import net.ender.endersequipment.spells.ice.BlizzardSpell;
import net.ender.endersequipment.spells.lightning.RiseSpell;
import net.ender.endersequipment.spells.evocation.GigantismSpell;
import net.ender.endersequipment.spells.evocation.MinimizeSpell;
import net.ender.endersequipment.spells.ice.FrostedSlamSpell;
import net.ender.endersequipment.spells.primeval.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@AutoSpellConfig
public class SpellRegistry {
        public static final DeferredRegister<AbstractSpell> SPELLS =
                DeferredRegister.create(io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY, endersequipment.MOD_ID);

        public static DeferredHolder<AbstractSpell, AbstractSpell> registerSpell(AbstractSpell spell) {
                return SPELLS.register(spell.getSpellName(), () -> spell);
        }

        public static final Supplier<AbstractSpell> STRAIN_SPELL = registerSpell(new StrainSpell());
        public static final Supplier<AbstractSpell> GIGANTISM_SPELL = registerSpell(new GigantismSpell());
        public static final Supplier<AbstractSpell> FROSTEDSLAM_SPELL =registerSpell(new FrostedSlamSpell());
        public static final Supplier<AbstractSpell> MINIMIZE_SPELL =registerSpell(new MinimizeSpell());
        public static final Supplier<AbstractSpell> RISE_SPELL =registerSpell(new RiseSpell());
        public static final Supplier<AbstractSpell> ANGELSBLESSING =registerSpell(new AnglesBlessingSpell());
        public static final Supplier<AbstractSpell> BLOODWAVE =registerSpell(new BloodWaveSpell());
        public static final Supplier<AbstractSpell> BOILING_BLOOD =registerSpell(new BoilingBloodSpell());
        public static final Supplier<AbstractSpell> GREATER_WISP =registerSpell(new GreaterWispSpell());
        public static final Supplier<AbstractSpell> BLIZZARD_ARMOR =registerSpell(new BlizzardSpell());
        public static final Supplier<AbstractSpell> SLASH =registerSpell(new SlashSpell());
        public static final Supplier<AbstractSpell> ERUPTION =registerSpell(new EruptionSpell());
        public static final Supplier<AbstractSpell> WHIP =registerSpell(new TentacleShieldSpell());
        public static final Supplier<AbstractSpell> SUPERNOVA =registerSpell(new SupernovaSpell());
        public static final Supplier<AbstractSpell> EXTINCTION =registerSpell(new ExtinctionSpell());
        public static final Supplier<AbstractSpell> METEOR =registerSpell(new MeteorSpell());
        public static final Supplier<AbstractSpell> SANGUINE =registerSpell(new SanguineImplosionSpell());
        public static final Supplier<AbstractSpell> ZEUS =registerSpell(new ZeusSpearSpell());
        public static final Supplier<AbstractSpell> IMPULSE =registerSpell(new ImpulseSpell());
        public static final Supplier<AbstractSpell> SUMMON_RAVAGER =registerSpell(new SummonRavagerSpell());
        public static final Supplier<AbstractSpell> SUMMON_KNIGHT =registerSpell(new RaiseKnightsSpell());
        public static final Supplier<AbstractSpell> VOIDS_REBOUND =registerSpell(new VoidsReboundSpell());
        public static final Supplier<AbstractSpell> ICEBERG =registerSpell(new IcebergSpell());
        public static final Supplier<AbstractSpell> SNARLING_GROUND =registerSpell(new SnarlingGroundSpell());
        public static final Supplier<AbstractSpell> EVISCERATE =registerSpell(new EviscerateSpell());
        public static final Supplier<AbstractSpell> ARROW_STORM =registerSpell(new ArrowCloudSpell());



        public static void register(IEventBus eventBus)
        {
                SPELLS.register(eventBus);
        }
}
