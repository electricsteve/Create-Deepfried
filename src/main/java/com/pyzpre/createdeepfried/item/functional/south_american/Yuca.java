package com.pyzpre.createdeepfried.item.functional.south_american;

import com.simibubi.create.foundation.item.TooltipHelper;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class Yuca extends Item {
    public Yuca(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, context, tooltip, flag);
        tooltip.add(Component.translatable("item.create_deepfried.south_american"));
        FontHelper.Palette palette = FontHelper.Palette.STANDARD_CREATE;

        // Add a "Hold Shift" message for extended tooltip using the new translation method
        tooltip.add(TooltipHelper.holdShift(FontHelper.Palette.STANDARD_CREATE, true));

        if (Screen.hasShiftDown()) {
            MutableComponent part1 = Component.translatable("item.create_deepfried.yuca.tooltip.part1")
                    .withStyle(palette.primary());
            MutableComponent part2 = Component.translatable("item.create_deepfried.yuca.tooltip.part2")
                    .withStyle(palette.primary());
            MutableComponent part3 = Component.translatable("item.create_deepfried.yuca.tooltip.part3")
                    .withStyle(palette.primary());

            tooltip.add(part1.append(part2).append(part3));
        }
    }
}