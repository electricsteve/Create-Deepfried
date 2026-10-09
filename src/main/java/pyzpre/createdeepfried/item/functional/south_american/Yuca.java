package pyzpre.createdeepfried.item.functional.south_american;

import com.simibubi.create.foundation.item.TooltipHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Yuca extends Item {
    public Yuca(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(Component.translatable("item.create_deepfried.south_american"));
        tooltip.add(TooltipHelper.holdShift(TooltipHelper.Palette.STANDARD_CREATE, true));

        if (Screen.hasShiftDown()) {
            MutableComponent part1 = Component.translatable("item.create_deepfried.yuca.tooltip.part1")
                    .setStyle(TooltipHelper.Palette.STANDARD_CREATE.primary());
            MutableComponent part2 = Component.translatable("item.create_deepfried.yuca.tooltip.part2")
                    .setStyle(TooltipHelper.Palette.STANDARD_CREATE.highlight());
            MutableComponent part3 = Component.translatable("item.create_deepfried.yuca.tooltip.part3")
                    .setStyle(TooltipHelper.Palette.STANDARD_CREATE.primary());

            tooltip.add(part1.append(part2).append(part3));
        }
    }
}