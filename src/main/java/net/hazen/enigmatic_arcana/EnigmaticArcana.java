package net.hazen.enigmatic_arcana;

import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import net.acetheeldritchking.aces_spell_utils.entity.render.items.SheathCurioRenderer;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.enigmatic_arcana.Items.Equipment.Armor.AgroconicSets.ApothicCrusader.ApothicCrusaderArmorRenderer;
import net.hazen.enigmatic_arcana.Items.Equipment.Curios.CustomCurios.AgroconicBulwark.AgroconicBulwarkItemRenderer;
import net.hazen.enigmatic_arcana.Items.Equipment.Curios.CustomCurios.AgroconicBulwark.AgroconicBulwarkRenderer;
import net.hazen.enigmatic_arcana.Items.Equipment.Curios.Spellbooks.Antonomos.AntonomosItemRenderer;
import net.hazen.enigmatic_arcana.Items.Equipment.Curios.Spellbooks.Antonomos.AntonomosRenderer;
import net.hazen.enigmatic_arcana.Items.Important.EAArmorMaterials;
import net.hazen.enigmatic_arcana.Registries.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(EnigmaticArcana.MOD_ID)
public class EnigmaticArcana {
    public static final String MOD_ID = "enigmatic_arcana";
    public static final Logger LOGGER = LogUtils.getLogger();


    public EnigmaticArcana(IEventBus modEventBus, ModContainer modContainer) {


        EAItemRegistry.register(modEventBus);
        EAArmorMaterials.register(modEventBus);
        EACreativeModeTabs.register(modEventBus);

        EASchoolRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, EAConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


    public static ResourceLocation id(@NotNull String path)
    {
        return ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, path);
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                EAItemRegistry.getEAItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
                EAItemRegistry.getEAItems().stream().filter(item -> item.get() instanceof SheathCurioItem).forEach((item) -> CuriosRendererRegistry.register(item.get(), SheathCurioRenderer::new));
            });

            /*
             *** Armor Rendering Registry
             */

            //Apothic Crusader
            AzArmorRendererRegistry.register(ApothicCrusaderArmorRenderer::new,
                    EAItemRegistry.APOTHIC_CRUSADER_HELMET.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_CHESTPLATE.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_LEGGINGS.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_BOOTS.get()
            );

            /*
            *** Curio Renderer
             */

            // Agroconic Bulwark
            AzArmorRendererRegistry.register(AgroconicBulwarkItemRenderer::new, EAItemRegistry.AGROCONIC_BULWARK.get());
            CuriosRendererRegistry.register(
                    EAItemRegistry.AGROCONIC_BULWARK.get(), AgroconicBulwarkRenderer::new
            );

            /*
             *** Spellbooks
             */

            // Agroconic Bulwark
            AzArmorRendererRegistry.register(AntonomosItemRenderer::new, EAItemRegistry.ANTONOMOS.get());
            CuriosRendererRegistry.register(
                    EAItemRegistry.ANTONOMOS.get(), AntonomosRenderer::new
            );

            /*
             *** Animation Registry
             */

            AzIdentityRegistry.register(

                    EAItemRegistry.APOTHIC_CRUSADER_HELMET.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_CHESTPLATE.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_LEGGINGS.get(),
                    EAItemRegistry.APOTHIC_CRUSADER_BOOTS.get(),

                    EAItemRegistry.AGROCONIC_BULWARK.get()

            );
        }
    }
}
