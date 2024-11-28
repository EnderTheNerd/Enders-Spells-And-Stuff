package net.ender.endersequipment.item.curios;

import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.effect.ModEffectRegistry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class WardingCharm extends SimpleDescriptiveCurio  {
    public WardingCharm() {
        super(ItemPropertiesHelper.equipment().stacksTo(1), Curios.NECKLACE_SLOT);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        slotContext.entity().removeEffect(MobEffects.BLINDNESS);
        slotContext.entity().removeEffect(MobEffects.DARKNESS);
        slotContext.entity().removeEffect(MobEffects.WEAKNESS);
        slotContext.entity().removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        slotContext.entity().removeEffect(MobEffects.WITHER);
        slotContext.entity().removeEffect(MobEffects.CONFUSION);
        slotContext.entity().removeEffect(MobEffects.HUNGER);
        slotContext.entity().removeEffect(MobEffects.POISON);
        slotContext.entity().removeEffect(MobEffects.LEVITATION);
        slotContext.entity().removeEffect(ModEffectRegistry.BLOODIEDWOUNDSEFFECT);
        slotContext.entity().removeEffect(MobEffectRegistry.BLIGHT);
        slotContext.entity().removeEffect(MobEffectRegistry.SLOWED);
        slotContext.entity().removeEffect(MobEffectRegistry.REND);
        slotContext.entity().removeEffect(MobEffectRegistry.CHILLED);






    }

}

