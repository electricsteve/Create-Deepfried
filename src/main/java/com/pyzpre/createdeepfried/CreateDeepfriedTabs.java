package com.pyzpre.createdeepfried;


import com.pyzpre.createbitterballen.index.FluidRegistry;
import com.pyzpre.createdeepfried.index.ItemRegistry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;


public class CreateDeepfriedTabs {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister
        .create(Registries.CREATIVE_MODE_TAB, "create_deepfried");
    public static final Holder<CreativeModeTab> BASE = TAB_REGISTER.register("base", CreateDeepfriedTabs::base);

    public static void register(IEventBus modBus) {
        TAB_REGISTER.register(modBus);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private static CreativeModeTab base(ResourceLocation id) {
        return CreativeModeTab.builder()
            .title(Component.translatable("item_group.create_deepfried.tabs"))
            .icon(() -> FluidRegistry.FRYING_OIL.getBucket().get().getDefaultInstance())
            .displayItems(CreateDeepfriedTabs::buildBaseContents)
            .build();
    }

    private static void buildBaseContents(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(ItemRegistry.RAW_CORN_DOG.get());
        output.accept(ItemRegistry.CORN_DOG.get());
        output.accept(ItemRegistry.RAW_CHICKEN_NUGGETS.get());
        output.accept(ItemRegistry.CHICKEN_NUGGETS.get());
        output.accept(ItemRegistry.YUCA.get());
        output.accept(ItemRegistry.YUCA_FRIES.get());
        output.accept(ItemRegistry.CHEESE_CURD.get());
        output.accept(ItemRegistry.RAW_SPRINGROLL.get());
        output.accept(ItemRegistry.SPRINGROLL.get());
        output.accept(ItemRegistry.RAW_TEMPURA.get());
        output.accept(ItemRegistry.TEMPURA.get());
        output.accept(ItemRegistry.CALAMARI.get());
        output.accept(ItemRegistry.RAW_DONUT.get());
        output.accept(ItemRegistry.DONUT.get());
        output.accept(ItemRegistry.COATED_DONUT.get());
        output.accept(ItemRegistry.HONEY_GLAZED_DONUT.get());
        output.accept(ItemRegistry.CHOCOLATE_GLAZED_DONUT.get());
        output.accept(ItemRegistry.SWEET_BERRY_HONEY_GLAZED_DONUT.get());
        output.accept(ItemRegistry.SWEET_BERRY_CHOCOLATE_GLAZED_DONUT.get());
        output.accept(ItemRegistry.GLOW_BERRY_HONEY_GLAZED_DONUT.get());
        output.accept(ItemRegistry.GLOW_BERRY_CHOCOLATE_GLAZED_DONUT.get());
        output.accept(ItemRegistry.BERLINER.get());
        output.accept(ItemRegistry.HONEY_BERLINER.get());
        output.accept(ItemRegistry.CHOCOLATE_BERLINER.get());
        output.accept(ItemRegistry.COATED_BERLINER.get());
        output.accept(ItemRegistry.COATED_HONEY_BERLINER.get());
        output.accept(ItemRegistry.COATED_CHOCOLATE_BERLINER.get());
        output.accept(ItemRegistry.APPLE_SLICES.get());
        output.accept(ItemRegistry.APFELKUCHLE.get());
        output.accept(ItemRegistry.DEEPFRIED_CHOCOLATE_BAR.get());
        output.accept(ItemRegistry.FISH_AND_CHIPS.get());
        output.accept(ItemRegistry.FRIED_CHICKEN.get());
        output.accept(ItemRegistry.LAVA_CHICKEN.get());
        // Check if Farmer's Delight is loaded before adding these foods
        if (ModList.get().isLoaded("farmersdelight")) {
            output.accept(ItemRegistry.RAW_ONION_RINGS.get());
            output.accept(ItemRegistry.ONION_RINGS.get());
            output.accept(ItemRegistry.BLOOMING_ONION.get());
            output.accept(ItemRegistry.RAW_PANZEROTTO.get());
            output.accept(ItemRegistry.PANZEROTTO.get());
            output.accept(ItemRegistry.RAW_ARANCINI.get());
            output.accept(ItemRegistry.ARANCINI.get());
        }
    }
}