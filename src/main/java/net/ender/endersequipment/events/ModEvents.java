package net.ender.endersequipment.events;
import ca.weblite.objc.Message;
import io.redspace.ironsspellbooks.api.events.CounterSpellEvent;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.item.ModItems;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.ender.endersequipment.item.swordtiers.bloodthirst;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import java.util.concurrent.atomic.AtomicBoolean;

import static net.minecraft.tags.EntityTypeTags.UNDEAD;

@EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void livingDamageEvent(LivingDamageEvent.Post event) {
        var sourceEntity = event.getSource().getEntity();
        var target = event.getEntity();
        var projectile = event.getSource().getDirectEntity();


        if (sourceEntity instanceof LivingEntity livingEntity) {
            ItemStack mainhandItem = livingEntity.getMainHandItem();
            if (mainhandItem.getItem() instanceof bloodthirst) {
                if (target instanceof LivingEntity livingTarget) {
                    livingTarget.addEffect(new MobEffectInstance(ModEffectRegistry.BLOODIEDWOUNDSEFFECT, 60, 0));
                }
            }
        }


    }



    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof IMagicSummon) {
            IMagicSummon summon = (IMagicSummon) event.getEntity();
            if (summon.getSummoner() != null && summon.getSummoner() instanceof ServerPlayer) {
                ServerPlayer summoner = (ServerPlayer) summon.getSummoner();
                MagicData magicData = MagicData.getPlayerMagicData(summoner);
                if (summoner.hasEffect(ModEffectRegistry.LORD_OF_DECAY) && magicData.getMana() > 50) {
                    magicData.setMana(magicData.getMana() - 50);


                    summoner.displayClientMessage(Component.literal(ChatFormatting.ITALIC + "Revived Summon")
                            .withStyle(s -> s.withColor(TextColor.fromRgb(3289650))), true);
                    event.setCanceled(true);
                    event.getEntity().setHealth(event.getEntity().getMaxHealth());
                    if (event.getSource().getEntity() instanceof LivingEntity) {

                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void onLivingDeath2(LivingDeathEvent event) {
        if (event.getEntity() instanceof IMagicSummon) {
            IMagicSummon summon = (IMagicSummon) event.getEntity();
            if (summon.getSummoner() != null && summon.getSummoner() instanceof ServerPlayer) {
                ServerPlayer summoner = (ServerPlayer) summon.getSummoner();
                MagicData magicData = MagicData.getPlayerMagicData(summoner);
                if (summoner.hasEffect(ModEffectRegistry.ANUBIS_DIVINITY) && magicData.getMana() > 0) {



                    summoner.displayClientMessage(Component.literal(ChatFormatting.GOLD + "Loyal Minion Returned from Death")
                            .withStyle(s -> s.withColor(TextColor.fromRgb(3289650))), true);
                    event.setCanceled(true);
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 150, 1));
                    event.getEntity().setHealth(event.getEntity().getMaxHealth());
                    if (event.getSource().getEntity() instanceof LivingEntity) {

                    }
                }
            }
        }
    }



    @SubscribeEvent
    public static void onPlayerCastEvent(SpellPreCastEvent event) {
        var entity = event.getEntity();
        boolean hasEbonyEffect = entity.hasEffect(ModEffectRegistry.EBONY_ARMOR);
        if (entity instanceof ServerPlayer player && !player.level().isClientSide) {
            if (hasEbonyEffect) {
                event.setCanceled(true);
                // Effect Duration
                int time = player.getEffect(ModEffectRegistry.EBONY_ARMOR).getDuration();
                // convert duration to time format  using the method convertTicksToTime
                String formattedTime = convertTicksToTime(time);
                // display a message to the player
                player.displayClientMessage(Component.literal(ChatFormatting.BOLD + "The Curse Prevents you from casting for : " + formattedTime)
                        .withStyle(s -> s.withColor(TextColor.fromRgb(3289650))), true);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.WITHER_HURT, SoundSource.PLAYERS, 0.3f, 1f);
            }
        }
    }

    public static String convertTicksToTime(int ticks) {
        // Convert ticks to seconds
        int totalSeconds = ticks / 20;

        // Calculate minutes and seconds
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        // Format the result as mm:ss
        return String.format("%02d:%02d", minutes, seconds);
    }


    @SubscribeEvent
    public static void onPlayerLivingDamage1(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntity = event.getEntity();
        if (attacker instanceof ServerPlayer livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.BLESSEDEFFECT)) {
            SpellRegistry.SUNBEAM_SPELL.get().castSpell(event.getEntity().level(), 5, (ServerPlayer) attacker, CastSource.SCROLL, true);
            SpellRegistry.ANGEL_WINGS_SPELL.get().castSpell(event.getEntity().level(), 3, (ServerPlayer) attacker, CastSource.SCROLL, true);
        }


    }


    @SubscribeEvent
    public static void onPlayerLivingDamage(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntity = event.getEntity();
        if (attacker instanceof ServerPlayer livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.OVERCHARGED)) {
            SpellRegistry.BALL_LIGHTNING_SPELL.get().castSpell(event.getEntity().level(), 5, (ServerPlayer) attacker, CastSource.SCROLL, true);

        }


    }

    @SubscribeEvent
    public static void onLivingDamage3(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntity = event.getEntity();
        if (attacked instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.BLIZARDARMOR)) {
            livingAttacker.addEffect(new MobEffectInstance(MobEffectRegistry.CHILLED));

        }


    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntity = event.getEntity();
        if (attacker instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.BLESSEDEFFECT)) {
            attacked.addEffect(new MobEffectInstance(ModEffectRegistry.BLOODIEDWOUNDSEFFECT));

        }


    }

    @SubscribeEvent
    public static void onLivingDamage2(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntity = event.getEntity();
        if (attacker instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.WITHERING_TOUCH)) {
            attacked.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 2));

        }


    }


    @SubscribeEvent
    public static void livingDamageEvent2(LivingDamageEvent.Post event) {
        var sourceEntity = event.getSource().getEntity();
        var target = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var attacked = event.getEntity();
        var projectile = event.getSource().getDirectEntity();

        if (sourceEntity != null) {
            if (sourceEntity instanceof Player player) {

                {
                    if (projectile instanceof Projectile) {
                        if (attacker instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.WITHERING_TOUCH)) {
                            attacked.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 2));
                        }
                    }
                }
            }
        }
    }


}























