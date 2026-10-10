package pyzpre.createdeepfried.item.functional.south_american;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Yuca extends Item {
    public Yuca(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);

        tooltip.add(Component.translatable("item.create_deepfried.south_american"));

        Component holdShift = buildHoldShiftLine(/*highlighted=*/true);
        if (holdShift != null) tooltip.add(holdShift);

        if (Screen.hasShiftDown()) {
            Style primary = paletteStyle("primary");
            Style highlight = paletteStyle("highlight");
            if (primary == null || highlight == null) {
                tooltip.add(Component.translatable("item.create_deepfried.yuca.tooltip.part1")
                    .append(Component.translatable("item.create_deepfried.yuca.tooltip.part2"))
                    .append(Component.translatable("item.create_deepfried.yuca.tooltip.part3")));
                return;
            }

            MutableComponent part1 = Component.translatable("item.create_deepfried.yuca.tooltip.part1").setStyle(primary);
            MutableComponent part2 = Component.translatable("item.create_deepfried.yuca.tooltip.part2").setStyle(highlight);
            MutableComponent part3 = Component.translatable("item.create_deepfried.yuca.tooltip.part3").setStyle(primary);

            tooltip.add(part1.append(part2).append(part3));
        }
    }

    private static Object getPaletteInstance() {
        // Modern
        try {
            Class<?> c = Class.forName("net.createmod.catnip.lang.FontHelper$Palette");
            Field f = c.getField("STANDARD_CREATE");
            return f.get(null);
        } catch (Throwable ignored) {
        }

        // Old
        try {
            Class<?> c = Class.forName("com.simibubi.create.foundation.item.TooltipHelper$Palette");
            Field f = c.getField("STANDARD_CREATE");
            return f.get(null);
        } catch (Throwable ignored) {
        }

        return null;
    }

    private static Component buildHoldShiftLine(boolean highlighted) {
        Object palette = getPaletteInstance();
        if (palette == null) return null;

        try {
            Class<?> th = Class.forName("com.simibubi.create.foundation.item.TooltipHelper");
            Method m = th.getMethod("holdShift", palette.getClass(), boolean.class);
            Object result = m.invoke(null, palette, highlighted);
            return (result instanceof Component) ? (Component) result : null;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Style paletteStyle(String method) {
        Object palette = getPaletteInstance();
        if (palette == null) return null;

        try {
            Method m = palette.getClass().getMethod(method);
            Object s = m.invoke(palette);
            return (s instanceof Style) ? (Style) s : null;
        } catch (Throwable ignored) {
            return null;
        }
    }
}
