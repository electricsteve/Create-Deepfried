package com.pyzpre.createdeepfried.item.oceanian;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class Oceania extends Item {
    public Oceania(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, context, tooltip, flag);
        tooltip.add(Component.translatable("item.create_deepfried.oceanian"));
    }
}
