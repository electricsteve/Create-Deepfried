package pyzpre.createdeepfried;

import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import pyzpre.createdeepfried.index.ItemRegistry;

@Mod(CreateDeepfried.MOD_ID)
public class CreateDeepfried {
    public static final String MOD_ID = "create_deepfried";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateDeepfried.MOD_ID);

    @SuppressWarnings("removal") // Since 1.21.1, we're in 1.20.1
    public CreateDeepfried() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.register();
        CreateDeepfriedTabs.register(eventBus);
        REGISTRATE.registerEventListeners(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
