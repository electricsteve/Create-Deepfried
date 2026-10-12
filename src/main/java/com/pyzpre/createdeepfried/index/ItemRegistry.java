package com.pyzpre.createdeepfried.index;

import static com.pyzpre.createdeepfried.CreateDeepfried.REGISTRATE;

import com.pyzpre.createdeepfried.item.asian.Asia;
import com.pyzpre.createdeepfried.item.asian.Japan;
import com.pyzpre.createdeepfried.item.europe.Europe;
import com.pyzpre.createdeepfried.item.europe.Germany;
import com.pyzpre.createdeepfried.item.europe.Greece;
import com.pyzpre.createdeepfried.item.europe.Italy;
import com.pyzpre.createdeepfried.item.europe.UnitedKingdom;
import com.pyzpre.createdeepfried.item.functional.north_american.GlowBerryDonut;
import com.pyzpre.createdeepfried.item.functional.south_american.Yuca;
import com.pyzpre.createdeepfried.item.functional.unknown.LavaChicken;
import com.pyzpre.createdeepfried.item.north_american.Canada;
import com.pyzpre.createdeepfried.item.north_american.NorthAmerica;
import com.pyzpre.createdeepfried.item.south_american.SouthAmerica;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ItemRegistry {
    public static final ItemEntry<NorthAmerica> RAW_CORN_DOG = REGISTRATE.item("raw_corn_dog", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
        .register();
    public static final ItemEntry<NorthAmerica> CORN_DOG = REGISTRATE.item("corn_dog", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> RAW_CHICKEN_NUGGETS = REGISTRATE.item("raw_chicken_nuggets", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).fast().saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
        .register();
    public static final ItemEntry<NorthAmerica> CHICKEN_NUGGETS = REGISTRATE.item("chicken_nuggets", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<Yuca> YUCA = REGISTRATE.item("yuca", Yuca::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<SouthAmerica> YUCA_FRIES = REGISTRATE.item("yuca_fries", SouthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(5).saturationModifier(0.4f).build()))
        .register();
    public static final ItemEntry<Asia> RAW_SPRINGROLL = REGISTRATE.item("raw_springroll", Asia::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<Asia> SPRINGROLL = REGISTRATE.item("springroll", Asia::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<Japan> RAW_TEMPURA = REGISTRATE.item("raw_tempura", Japan::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<Japan> TEMPURA = REGISTRATE.item("tempura", Japan::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.4f).build()))
        .register();
    public static final ItemEntry<Greece> CALAMARI = REGISTRATE.item("calamari", Greece::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(5).saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<Europe> APPLE_SLICES = REGISTRATE.item("apple_slices", Europe::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).fast().saturationModifier(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> APFELKUCHLE = REGISTRATE.item("apfelkuchle", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> BERLINER = REGISTRATE.item("berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_BERLINER = REGISTRATE.item("coated_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(9).saturationModifier(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_HONEY_BERLINER = REGISTRATE.item("coated_honey_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(11).saturationModifier(0.6f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_CHOCOLATE_BERLINER = REGISTRATE.item("coated_chocolate_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(13).saturationModifier(0.9f).build()))
        .register();
    public static final ItemEntry<Germany> HONEY_BERLINER = REGISTRATE.item("honey_filled_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<Germany> CHOCOLATE_BERLINER = REGISTRATE.item("chocolate_filled_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> DEEPFRIED_CHOCOLATE_BAR = REGISTRATE.item("deepfried_chocolate_bar", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> FISH_AND_CHIPS = REGISTRATE.item("fish_and_chips", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> FRIED_CHICKEN = REGISTRATE.item("fried_chicken", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<LavaChicken> LAVA_CHICKEN = REGISTRATE.item("lava_chicken", LavaChicken::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.8f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1F).build()))
        .register();
    public static final ItemEntry<Canada> CHEESE_CURD = REGISTRATE.item("cheese_curd", Canada::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.7f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> RAW_DONUT = REGISTRATE.item("raw_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
        .register();
    public static final ItemEntry<NorthAmerica> DONUT = REGISTRATE.item("donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(7).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> COATED_DONUT = REGISTRATE.item("coated_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.3f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> HONEY_GLAZED_DONUT = REGISTRATE.item("honey_glazed_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(9).saturationModifier(0.5f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> CHOCOLATE_GLAZED_DONUT = REGISTRATE.item("chocolate_glazed_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(11).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> SWEET_BERRY_HONEY_GLAZED_DONUT = REGISTRATE.item("sweet_berry_honey_glazed_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(13).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> SWEET_BERRY_CHOCOLATE_GLAZED_DONUT = REGISTRATE.item("sweet_berry_chocolate_glazed_donut", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(15).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<GlowBerryDonut> GLOW_BERRY_HONEY_GLAZED_DONUT = REGISTRATE.item("glow_berry_honey_glazed_donut", GlowBerryDonut::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(13).saturationModifier(0.8f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F).build()))
        .register();
    public static final ItemEntry<GlowBerryDonut> GLOW_BERRY_CHOCOLATE_GLAZED_DONUT = REGISTRATE.item("glow_berry_chocolate_glazed_donut", GlowBerryDonut::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(15).saturationModifier(0.8f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F).build()))
        .register();


    //Farmers Delight
    public static final ItemEntry<Italy> RAW_PANZEROTTO = REGISTRATE.item("raw_panzerotto", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4f).build()))
        .register();
    public static final ItemEntry<Italy> PANZEROTTO = REGISTRATE.item("panzerotto", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> RAW_ONION_RINGS = REGISTRATE.item("raw_onion_rings", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> ONION_RINGS = REGISTRATE.item("onion_rings", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> BLOOMING_ONION = REGISTRATE.item("blooming_onion", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(7).saturationModifier(0.8f).build()))
        .register();
    public static final ItemEntry<Italy> RAW_ARANCINI = REGISTRATE.item("raw_arancini", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2f).build()))
        .register();
    public static final ItemEntry<Italy> ARANCINI = REGISTRATE.item("arancini", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8f).build()))
        .register();

    public static void register() {
    }
}