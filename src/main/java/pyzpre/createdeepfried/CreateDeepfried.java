package pyzpre.createdeepfried;

import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;

import pyzpre.createdeepfried.index.ItemRegistry;

import java.util.*;

@Mod(CreateDeepfried.MOD_ID)
public class CreateDeepfried {
    public static final String MOD_ID = "create_deepfried";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateDeepfried.MOD_ID);

    public CreateDeepfried() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateDeepfriedTabs.register();
        ItemRegistry.register();
        REGISTRATE.registerEventListeners(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
