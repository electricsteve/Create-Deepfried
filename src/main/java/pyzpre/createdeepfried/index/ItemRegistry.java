package pyzpre.createdeepfried.index;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import com.tterrag.registrate.util.entry.ItemEntry;

import pyzpre.createdeepfried.item.asian.Asia;
import pyzpre.createdeepfried.item.asian.Japan;
import pyzpre.createdeepfried.item.europe.*;
import pyzpre.createdeepfried.item.functional.south_american.Yuca;
import pyzpre.createdeepfried.item.north_american.NorthAmerica;
import pyzpre.createdeepfried.item.south_american.SouthAmerica;


import static pyzpre.createdeepfried.CreateDeepfried.REGISTRATE;

public class ItemRegistry {
    public static final ItemEntry<NorthAmerica> RAW_CORN_DOG = REGISTRATE.item("raw_corn_dog", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
        .register();
    public static final ItemEntry<NorthAmerica> CORN_DOG = REGISTRATE.item("corn_dog", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.5f).meat().build()))
        .register();
    public static final ItemEntry<NorthAmerica> RAW_CHICKEN_NUGGETS = REGISTRATE.item("raw_chicken_nuggets", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).fast().saturationMod(0.2f).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
        .register();
    public static final ItemEntry<NorthAmerica> CHICKEN_NUGGETS = REGISTRATE.item("chicken_nuggets", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).fast().saturationMod(0.5f).meat().build()))
        .register();
    public static final ItemEntry<Yuca> YUCA = REGISTRATE.item("yuca", Yuca::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.2f).build()))

        .register();
    public static final ItemEntry<SouthAmerica> YUCA_FRIES = REGISTRATE.item("yuca_fries", SouthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f).build()))
        .register();
    public static final ItemEntry<Asia> RAW_SPRINGROLL = REGISTRATE.item("raw_springroll", Asia::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f).build()))
        .register();
    public static final ItemEntry<Asia> SPRINGROLL = REGISTRATE.item("springroll", Asia::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.5f).build()))
        .register();
    public static final ItemEntry<Japan> RAW_TEMPURA = REGISTRATE.item("raw_tempura", Japan::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.2f).build()))
        .register();
    public static final ItemEntry<Japan> TEMPURA = REGISTRATE.item("tempura", Japan::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationMod(0.4f).build()))
        .register();
    public static final ItemEntry<Greece> CALAMARI = REGISTRATE.item("calamari", Greece::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f).build()))
        .register();
    public static final ItemEntry<Europe> APPLE_SLICES = REGISTRATE.item("apple_slices", Europe::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).fast().saturationMod(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> APFELKUCHLE = REGISTRATE.item("apfelkuchle", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).fast().saturationMod(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> BERLINER = REGISTRATE.item("berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.2f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_BERLINER = REGISTRATE.item("coated_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(9).saturationMod(0.3f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_HONEY_BERLINER = REGISTRATE.item("coated_honey_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(11).saturationMod(0.6f).build()))
        .register();
    public static final ItemEntry<Germany> COATED_CHOCOLATE_BERLINER = REGISTRATE.item("coated_chocolate_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(13).saturationMod(0.9f).build()))
        .register();
    public static final ItemEntry<Germany> HONEY_BERLINER = REGISTRATE.item("honey_filled_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.5f).build()))
        .register();
    public static final ItemEntry<Germany> CHOCOLATE_BERLINER = REGISTRATE.item("chocolate_filled_berliner", Germany::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationMod(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> DEEPFRIED_CHOCOLATE_BAR = REGISTRATE.item("deepfried_chocolate_bar", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> FISH_AND_CHIPS = REGISTRATE.item("fish_and_chips", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationMod(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> FRIED_CHICKEN = REGISTRATE.item("fried_chicken", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.8f).meat().build()))
        .register();


    //Farmers Delight
    public static final ItemEntry<Italy> RAW_PANZEROTTO = REGISTRATE.item("raw_panzerotto", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4f).build()))
        .register();
    public static final ItemEntry<Italy> PANZEROTTO = REGISTRATE.item("panzerotto", Italy::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(12).saturationMod(0.8f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> RAW_ONION_RINGS = REGISTRATE.item("raw_onion_rings", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.4f).build()))
        .register();
    public static final ItemEntry<UnitedKingdom> ONION_RINGS = REGISTRATE.item("onion_rings", UnitedKingdom::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.8f).build()))
        .register();
    public static final ItemEntry<NorthAmerica> BLOOMING_ONION = REGISTRATE.item("blooming_onion", NorthAmerica::new)
        .properties(p -> p.food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8f).build()))
        .register();

    public static void register() {
    }
}