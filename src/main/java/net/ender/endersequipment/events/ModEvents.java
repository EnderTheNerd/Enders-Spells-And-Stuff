package net.ender.endersequipment.events;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.ender.endersequipment.item.swordtiers.bloodthirst;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

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
    public static void onPlayerLivingDamage1(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntitiy = event.getEntity();
        if (attacker instanceof ServerPlayer livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.BLESSEDEFFECT)) {
            SpellRegistry.SUNBEAM_SPELL.get().castSpell(event.getEntity().level(), 5, (ServerPlayer) attacker, CastSource.SCROLL, true);
            SpellRegistry.ANGEL_WINGS_SPELL.get().castSpell(event.getEntity().level(), 3, (ServerPlayer) attacker, CastSource.SCROLL, true);
        }


    }



    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Post event) {
        var attacked = event.getEntity();
        var attacker = event.getSource().getDirectEntity();
        var entity = event.getEntity();
        var ServerEntitiy = event.getEntity();
        if (attacker instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(ModEffectRegistry.BLESSEDEFFECT)) {
            attacked.addEffect(new MobEffectInstance(ModEffectRegistry.BLOODIEDWOUNDSEFFECT));

        }


    }



    }
    //Love it! - Grandma





