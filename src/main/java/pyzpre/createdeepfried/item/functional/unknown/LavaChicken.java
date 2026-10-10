package pyzpre.createdeepfried.item.functional.unknown;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LavaChicken extends Item {
    public LavaChicken(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(Component.translatable("item.create_deepfried.minecraft"));
        tooltip.add(
            Component.translatable("effect.minecraft.fire_resistance")
                .withStyle(ChatFormatting.BLUE) // Fire Resistance is BENEFICIAL → BLUE
                .append(Component.literal(" ("))
                .append(MobEffectUtil.formatDuration(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60 * 3), 1.0F))
                .append(Component.literal(")"))
        );
    }
}
