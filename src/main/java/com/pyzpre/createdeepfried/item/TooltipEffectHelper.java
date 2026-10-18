package com.pyzpre.createdeepfried.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;

public class TooltipEffectHelper {
    public static Component vanillaEffectLine(MobEffectInstance inst, float durationFactor, float ticksPerSecond) {
        var effectHolder = inst.getEffect();
        var base = Component.translatable(inst.getDescriptionId());

        if (inst.getAmplifier() > 0) {
            base = Component.translatable(
                    "potion.withAmplifier",
                    base,
                    Component.translatable("potion.potency." + inst.getAmplifier())
            );
        }

        if (!inst.endsWithin(20)) {
            base = Component.translatable(
                    "potion.withDuration",
                    base,
                    MobEffectUtil.formatDuration(inst, durationFactor, ticksPerSecond)
            );
        }

        return base.withStyle(effectHolder.value().getCategory().getTooltipFormatting());
    }
}
