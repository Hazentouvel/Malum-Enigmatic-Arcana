package net.hazen.enigmatic_arcana.Items.Equipment.Armor.AgroconicSets.ApothicCrusader;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.hazen.enigmatic_arcana.Items.Important.EAAzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class ApothicCrusaderArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "geo/armor/apothic_crusader_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            EnigmaticArcana.MOD_ID,
            "textures/armor/apothic_crusader_armor.png"
    );

    public ApothicCrusaderArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(ApothicCrusaderAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(EAAzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}