package com.pyzpre.createdeepfried.index;

import static com.pyzpre.createdeepfried.CreateDeepfried.MOD_ID;
import static com.pyzpre.createdeepfried.CreateDeepfried.REGISTRATE;

import com.mojang.serialization.Codec;
import com.pyzpre.createdeepfried.item.GlowBerryDonut;
import com.pyzpre.createdeepfried.item.Yuca;
import com.pyzpre.createdeepfried.item.LavaChicken;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;


public class ItemRegistry {
    private static final String NORTH_AMERICA = "north_america";
    private static final String SOUTH_AMERICA = "south_america";
    private static final String ASIA = "asia";
    private static final String JAPAN = "japan";
    private static final String GREECE = "greece";
    private static final String EUROPE = "europe";
    private static final String GERMANY = "germany";
    private static final String UNITED_KINGDOM = "united_kingdom";
    private static final String ITALY = "italy";
    private static final String CANADA = "canada";
    private static final String OCEANIA = "oceania";
    private static final String AFRICA = "africa";
    private static final String MINECRAFT = "minecraft";

    public static final DeferredRegister.DataComponents DATA_COMPONENT_REGISTRAR = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> FOOD_ORIGIN = DATA_COMPONENT_REGISTRAR.registerComponentType(
        "food_origin",
        builder -> builder
            .persistent(Codec.STRING)
    );

    private static <T extends Item> ItemEntry<T> registerItem(NonNullFunction<Item.Properties, T> itemConstructor, String item_id, int nutrition, float saturationModifier, boolean fast, String origin, Function<FoodProperties.Builder, FoodProperties.Builder> foodFunction) {
        return REGISTRATE.item(item_id, itemConstructor)
            .properties(p -> {
                FoodProperties.Builder foodPropBuilder = (new FoodProperties.Builder()).nutrition(nutrition).saturationModifier(saturationModifier);
                if (fast) foodPropBuilder.fast();
                foodFunction.apply(foodPropBuilder);
                return p.food(foodPropBuilder.build()).component(FOOD_ORIGIN, origin);
            })
            .register();
    }

    private static ItemEntry<Item> registerItem(String item_id, int nutrition, float saturationModifier, boolean fast, String origin, Function<FoodProperties.Builder, FoodProperties.Builder> foodFunction) {
        return registerItem(Item::new, item_id, nutrition, saturationModifier, fast, origin, foodFunction);
    }

    private static ItemEntry<Item> registerItem(String item_id, int nutrition, float saturationModifier, boolean fast, String origin) {
        return registerItem(item_id, nutrition, saturationModifier, fast, origin, b -> b);
    }

    public static final ItemEntry<Item> RAW_CORN_DOG = registerItem("raw_corn_dog", 4, 0.2f, false, NORTH_AMERICA,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F));
    public static final ItemEntry<Item> CORN_DOG = registerItem("corn_dog", 8, 0.5f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> RAW_CHICKEN_NUGGETS = registerItem("raw_chicken_nuggets", 2, 0.2f, true, NORTH_AMERICA,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F));
    public static final ItemEntry<Item> CHICKEN_NUGGETS = registerItem("chicken_nuggets", 4, 0.5f, true, NORTH_AMERICA);
    public static final ItemEntry<Yuca> YUCA = registerItem(Yuca::new, "yuca", 1, 0.2f, false, SOUTH_AMERICA, b -> b);
    public static final ItemEntry<Item> YUCA_FRIES = registerItem("yuca_fries", 5, 0.4f, false, SOUTH_AMERICA);
    public static final ItemEntry<Item> RAW_SPRINGROLL = registerItem("raw_springroll", 4, 0.2f, false, ASIA);
    public static final ItemEntry<Item> SPRINGROLL = registerItem("springroll", 10, 0.5f, false, ASIA);
    public static final ItemEntry<Item> RAW_TEMPURA = registerItem("raw_tempura", 4, 0.2f, false, JAPAN);
    public static final ItemEntry<Item> TEMPURA = registerItem("tempura", 12, 0.4f, false, JAPAN);
    public static final ItemEntry<Item> CALAMARI = registerItem("calamari", 5, 0.5f, false, GREECE);
    public static final ItemEntry<Item> APPLE_SLICES = registerItem("apple_slices", 2, 0.3f, true, EUROPE);
    public static final ItemEntry<Item> APFELKUCHLE = registerItem("apfelkuchle", 4, 0.3f, true, GERMANY);
    public static final ItemEntry<Item> BERLINER = registerItem("berliner", 8, 0.2f, false, GERMANY);
    public static final ItemEntry<Item> COATED_BERLINER = registerItem("coated_berliner", 9, 0.3f, false, GERMANY);
    public static final ItemEntry<Item> COATED_HONEY_BERLINER = registerItem("coated_honey_berliner", 11, 0.6f, false, GERMANY);
    public static final ItemEntry<Item> COATED_CHOCOLATE_BERLINER = registerItem("coated_chocolate_berliner", 13, 0.9f, false, GERMANY);
    public static final ItemEntry<Item> HONEY_BERLINER = registerItem("honey_filled_berliner", 10, 0.5f, false, GERMANY);
    public static final ItemEntry<Item> CHOCOLATE_BERLINER = registerItem("chocolate_filled_berliner", 12, 0.8f, false, GERMANY);
    public static final ItemEntry<Item> DEEPFRIED_CHOCOLATE_BAR = registerItem("deepfried_chocolate_bar", 10, 0.8f, false, UNITED_KINGDOM);
    public static final ItemEntry<Item> FISH_AND_CHIPS = registerItem("fish_and_chips", 12, 0.8f, false, UNITED_KINGDOM);
    public static final ItemEntry<Item> FRIED_CHICKEN = registerItem("fried_chicken", 8, 0.8f, false, UNITED_KINGDOM);
    public static final ItemEntry<LavaChicken> LAVA_CHICKEN = registerItem(LavaChicken::new, "lava_chicken", 8, 0.8f, false, MINECRAFT,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1F));
    public static final ItemEntry<Item> CHEESE_CURD = registerItem("cheese_curd", 8, 0.7f, false, CANADA);
    public static final ItemEntry<Item> RAW_DONUT = registerItem("raw_donut", 2, 0.2f, false, NORTH_AMERICA,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F));
    public static final ItemEntry<Item> DONUT = registerItem("donut", 7, 0.2f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> COATED_DONUT = registerItem("coated_donut", 8, 0.3f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> HONEY_GLAZED_DONUT = registerItem("honey_glazed_donut", 9, 0.5f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> CHOCOLATE_GLAZED_DONUT = registerItem("chocolate_glazed_donut", 11, 0.8f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> SWEET_BERRY_HONEY_GLAZED_DONUT = registerItem("sweet_berry_honey_glazed_donut", 13, 0.8f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> SWEET_BERRY_CHOCOLATE_GLAZED_DONUT = registerItem("sweet_berry_chocolate_glazed_donut", 15, 0.8f, false, NORTH_AMERICA);
    public static final ItemEntry<GlowBerryDonut> GLOW_BERRY_HONEY_GLAZED_DONUT = registerItem(GlowBerryDonut::new, "glow_berry_honey_glazed_donut", 13, 0.8f, false, NORTH_AMERICA,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F));
    public static final ItemEntry<GlowBerryDonut> GLOW_BERRY_CHOCOLATE_GLAZED_DONUT = registerItem(GlowBerryDonut::new, "glow_berry_chocolate_glazed_donut", 15, 0.8f, false, NORTH_AMERICA,
        builder -> builder.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F));


    //Farmers Delight
    public static final ItemEntry<Item> RAW_PANZEROTTO = registerItem("raw_panzerotto", 4, 0.4f, false, ITALY);
    public static final ItemEntry<Item> PANZEROTTO = registerItem("panzerotto", 12, 0.8f, false, ITALY);
    public static final ItemEntry<Item> RAW_ONION_RINGS = registerItem("raw_onion_rings", 2, 0.4f, false, UNITED_KINGDOM);
    public static final ItemEntry<Item> ONION_RINGS = registerItem("onion_rings", 4, 0.8f, false, UNITED_KINGDOM);
    public static final ItemEntry<Item> BLOOMING_ONION = registerItem("blooming_onion", 7, 0.8f, false, NORTH_AMERICA);
    public static final ItemEntry<Item> RAW_ARANCINI = registerItem("raw_arancini", 2, 0.2f, false, ITALY);
    public static final ItemEntry<Item> ARANCINI = registerItem("arancini", 10, 0.8f, false, ITALY);

    public static void register(IEventBus modBus) {
        DATA_COMPONENT_REGISTRAR.register(modBus);
    }
}