package com.pyzpre.createdeepfried.events;


import com.pyzpre.createdeepfried.index.ItemRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;

public class LootTables {
    private static final ResourceLocation DEAD_BUSH = ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/dead_bush");

    public static void register() {
        NeoForge.EVENT_BUS.addListener(com.pyzpre.createdeepfried.events.LootTables::onLootTableLoad);
    }

    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (event.getName().equals(DEAD_BUSH)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .name("yuca_drop")
                .add(LootItem.lootTableItem(ItemRegistry.YUCA.get()))
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance(0.3f)); // 10% chance

            event.getTable().addPool(poolBuilder.build());
        }
    }
}
