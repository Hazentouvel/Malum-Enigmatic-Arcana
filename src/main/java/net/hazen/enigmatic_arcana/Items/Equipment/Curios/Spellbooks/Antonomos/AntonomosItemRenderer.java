package net.hazen.enigmatic_arcana.Items.Equipment.Curios.Spellbooks.Antonomos;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.resources.ResourceLocation;

public class AntonomosItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "geo/curios/antonomos.geo.json"
    );

    public static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "textures/curios/antonomos.png"
    );

    public AntonomosItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(AntonomosAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}