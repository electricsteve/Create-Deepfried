package pyzpre.createdeepfried;

import com.pyzpre.create_bic_bit.index.FluidRegistry;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

import pyzpre.createdeepfried.index.ItemRegistry;

public class CreateDeepfriedTabs {
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("create_deepfried.deepfried") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FluidRegistry.FRYING_OIL.getBucket().get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.clear();
            items.add(new ItemStack(ItemRegistry.RAW_CORN_DOG.get()));
            items.add(new ItemStack(ItemRegistry.CORN_DOG.get()));
            items.add(new ItemStack(ItemRegistry.RAW_CHICKEN_NUGGETS.get()));
            items.add(new ItemStack(ItemRegistry.CHICKEN_NUGGETS.get()));
            items.add(new ItemStack(ItemRegistry.YUCA.get()));
            items.add(new ItemStack(ItemRegistry.YUCA_FRIES.get()));
            items.add(new ItemStack(ItemRegistry.RAW_SPRINGROLL.get()));
            items.add(new ItemStack(ItemRegistry.SPRINGROLL.get()));
            items.add(new ItemStack(ItemRegistry.RAW_TEMPURA.get()));
            items.add(new ItemStack(ItemRegistry.TEMPURA.get()));
            items.add(new ItemStack(ItemRegistry.CALAMARI.get()));
            items.add(new ItemStack(ItemRegistry.BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.HONEY_BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.CHOCOLATE_BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.COATED_BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.COATED_HONEY_BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.COATED_CHOCOLATE_BERLINER.get()));
            items.add(new ItemStack(ItemRegistry.APPLE_SLICES.get()));
            items.add(new ItemStack(ItemRegistry.APFELKUCHLE.get()));
            items.add(new ItemStack(ItemRegistry.DEEPFRIED_CHOCOLATE_BAR.get()));
            items.add(new ItemStack(ItemRegistry.FISH_AND_CHIPS.get()));
            items.add(new ItemStack(ItemRegistry.FRIED_CHICKEN.get()));
            // Check if Farmer's Delight is loaded before adding these foods
            if (ModList.get().isLoaded("farmersdelight")) {
                items.add(new ItemStack(ItemRegistry.RAW_ONION_RINGS.get()));
                items.add(new ItemStack(ItemRegistry.ONION_RINGS.get()));
                items.add(new ItemStack(ItemRegistry.BLOOMING_ONION.get()));
                items.add(new ItemStack(ItemRegistry.RAW_PANZEROTTO.get()));
                items.add(new ItemStack(ItemRegistry.PANZEROTTO.get()));
            }
        }
    };

    public static void register() {
    }
}

