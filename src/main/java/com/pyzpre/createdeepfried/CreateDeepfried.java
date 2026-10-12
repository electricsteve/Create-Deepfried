package com.pyzpre.createdeepfried;


import com.pyzpre.createdeepfried.events.LootTables;
import com.pyzpre.createdeepfried.index.ItemRegistry;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;

import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(CreateDeepfried.MOD_ID)
public class CreateDeepfried {
    public static final String MOD_ID = "create_deepfried";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateDeepfried.MOD_ID)
        .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
        .setTooltipModifierFactory(item ->
            new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
        );

    public CreateDeepfried(IEventBus eventBus) {
        REGISTRATE.registerEventListeners(eventBus);

        ItemRegistry.register();
        LootTables.register();
        CreateDeepfriedTabs.register(eventBus);

//        NeoForge.EVENT_BUS.register(this);
    }
}
