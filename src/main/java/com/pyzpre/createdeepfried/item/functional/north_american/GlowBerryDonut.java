package com.pyzpre.createdeepfried.item.functional.north_american;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import java.util.List;

import static com.pyzpre.createdeepfried.item.functional.TooltipEffectHelper.vanillaEffectLine;

public class GlowBerryDonut extends Item {

    public GlowBerryDonut(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, context, tooltip, flag);
        tooltip.add(Component.translatable("item.create_deepfried.north_american"));
        MobEffectInstance inst = new MobEffectInstance(MobEffects.GLOWING, 20 * 5, 0); //ticks > seconds > amplifier
        tooltip.add(vanillaEffectLine(
                inst,
                1.0F,
                context.tickRate()
        ));
    }
}
