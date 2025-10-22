package net.hazen.enigmatic_arcana.Items.Equipment.Curios.CustomCurios.AgroconicBulwark;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.resources.ResourceLocation;

public class AgroconicBulwarkItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "geo/curios/agroconic_bulwark.geo.json"
    );

    public static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "textures/curios/agroconic_bulwark.png"
    );

    public AgroconicBulwarkItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(AgroconicBulwarkAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}