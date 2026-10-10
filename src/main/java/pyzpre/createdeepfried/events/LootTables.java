package pyzpre.createdeepfried.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import pyzpre.createdeepfried.CreateDeepfried;
import pyzpre.createdeepfried.index.ItemRegistry;

@Mod.EventBusSubscriber(modid = CreateDeepfried.MOD_ID)
public class LootTables {
    @SuppressWarnings("removal") // Since 1.20.6, we're in 1.20.1
    private static final ResourceLocation DEAD_BUSH = new ResourceLocation("minecraft", "blocks/dead_bush");

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getName().equals(DEAD_BUSH)) {
            var table = event.getTable();

            LootItemCondition.Builder randomChance = LootItemRandomChanceCondition.randomChance(0.3f);

            LootPool.Builder pool = LootPool.lootPool()
                .add(LootItem.lootTableItem(ItemRegistry.YUCA.get()).when(randomChance));

            table.addPool(pool.build());
        }
    }
}
