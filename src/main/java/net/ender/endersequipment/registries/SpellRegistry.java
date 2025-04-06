package net.ender.endersequipment.registries;


import io.redspace.ironsspellbooks.api.spells.AbstractSpell;

import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import net.ender.endersequipment.effect.SoulLockEffect;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.spells.blade.*;
import net.ender.endersequipment.spells.blood.*;


import net.ender.endersequipment.spells.blood.divine.JudgementScaleSpell;
import net.ender.endersequipment.spells.blood.divine.TheDivinityOfAnubisSpell;
import net.ender.endersequipment.spells.blood.uncraftable.DarkSacrificeSpell;
import net.ender.endersequipment.spells.blood.uncraftable.LordOfDecaySpell;
import net.ender.endersequipment.spells.eldritch.EbonyArmorSpell;
import net.ender.endersequipment.spells.eldritch.MadnessWaveSpell;
import net.ender.endersequipment.spells.eldritch.TentacleShieldSpell;
import net.ender.endersequipment.spells.ender.SupernovaSpell;
import net.ender.endersequipment.spells.evocation.*;
import net.ender.endersequipment.spells.evocation.uncraftable.TrickerySpell;
import net.ender.endersequipment.spells.fire.CombustionSpell;
import net.ender.endersequipment.spells.fire.EruptionSpell;
import net.ender.endersequipment.spells.fire.PaleFlameSpell;
import net.ender.endersequipment.spells.fire.uncraftable.SearingSlamSpell;

import net.ender.endersequipment.spells.holy.AnglesBlessingSpell;
import net.ender.endersequipment.spells.holy.SacredSlashSpell;

import net.ender.endersequipment.spells.holy.SolarStormSpell;
import net.ender.endersequipment.spells.holy.uncraftable.FieldOfEverlastingLifeSpell;
import net.ender.endersequipment.spells.holy.uncraftable.SanctuarySpell;
import net.ender.endersequipment.spells.ice.FrostArmorSpell;
import net.ender.endersequipment.spells.ice.SnowgraveSpell;
import net.ender.endersequipment.spells.ice.uncraftable.BelowZeroSpell;
import net.ender.endersequipment.spells.lightning.RiseSpell;
import net.ender.endersequipment.spells.ice.FrostedSlamSpell;

import net.ender.endersequipment.spells.lightning.uncraftable.OverchargedSpell;
import net.ender.endersequipment.spells.nature.PetalBurstSpell;
import net.ender.endersequipment.spells.nature.PetalDanceSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.checkerframework.checker.units.qual.A;

import javax.print.attribute.standard.Sides;
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
        public static final Supplier<AbstractSpell> BLIZZARD_ARMOR =registerSpell(new FrostArmorSpell());
        public static final Supplier<AbstractSpell> SLASH =registerSpell(new SlashSpell());
        public static final Supplier<AbstractSpell> ERUPTION =registerSpell(new EruptionSpell());
        public static final Supplier<AbstractSpell> WHIP =registerSpell(new TentacleShieldSpell());
        public static final Supplier<AbstractSpell> SUPERNOVA =registerSpell(new SupernovaSpell());
        public static final Supplier<AbstractSpell> SUMMON_RAVAGER =registerSpell(new SummonRavagerSpell());
        public static final  Supplier<AbstractSpell> EXPLODE=registerSpell(new CombustionSpell());
        public static final Supplier <AbstractSpell> SNOWGRAVE =registerSpell(new SnowgraveSpell());
        public static final Supplier <AbstractSpell> SACRED =registerSpell(new SacredSlashSpell());
        public static final Supplier<AbstractSpell> WITHERING =registerSpell(new WitheringTouchSpell());
        public static final Supplier<AbstractSpell> HEARTWRENCH =registerSpell(new HeartwrenchSpell());
        public static final Supplier<AbstractSpell> EBONY =registerSpell(new EbonyArmorSpell());
        public static final Supplier <AbstractSpell> DARK_RITUAL =registerSpell(new DarkSacrificeSpell());
        public static final Supplier <AbstractSpell> OVERCHARGED =registerSpell(new OverchargedSpell());
        public static final Supplier <AbstractSpell> SANCTUARY =registerSpell(new SanctuarySpell());
        public static final Supplier<AbstractSpell> BELOW_ZERO =registerSpell(new BelowZeroSpell());
        public static final Supplier <AbstractSpell> SEARING_SLAM =registerSpell(new SearingSlamSpell());
        public static final Supplier <AbstractSpell> TRICKERY =registerSpell(new TrickerySpell());
        public static final Supplier <AbstractSpell> MADNESS_WAVE =registerSpell(new MadnessWaveSpell());
        public static final Supplier <AbstractSpell> ARROW_SPRAY =registerSpell(new ArrowSpraySpell());
        public static final Supplier <AbstractSpell> PETAL_BLIZZARD =registerSpell(new PetalBurstSpell());
        public static final Supplier <AbstractSpell> SLAM = registerSpell(new SlamSpell());
        public static final Supplier <AbstractSpell> FLURRY = registerSpell(new FlurrySpell());
        public static final Supplier <AbstractSpell> HONE_EDGE = registerSpell(new HoneEdgeSpell());
        public static final Supplier <AbstractSpell> SWORD_STANCE =registerSpell(new SwordStanceSpell());
        public static final Supplier <AbstractSpell> OVERWHELMING_FORCE =registerSpell(new OverwhelmingForceSpell());
        public static final Supplier <AbstractSpell> QUICK_SLICE =  registerSpell(new QuickSliceSpell());
        public static final Supplier <AbstractSpell> FINAL_BREATH =registerSpell (new FinalBreathSpell());
        public static final Supplier <AbstractSpell> LORD =registerSpell(new LordOfDecaySpell());
        public static final  Supplier <AbstractSpell> ANUBIS =registerSpell(new TheDivinityOfAnubisSpell());
        public static final Supplier <AbstractSpell> JUDGEMENT_SCALE =registerSpell(new JudgementScaleSpell());
        public static final Supplier <AbstractSpell> FIELD_OF_LIFE =registerSpell(new FieldOfEverlastingLifeSpell());
        public static final Supplier <AbstractSpell> PALE_FLAME =registerSpell(new PaleFlameSpell());




        public static void register(IEventBus eventBus)
        {
                SPELLS.register(eventBus);
        }
}
