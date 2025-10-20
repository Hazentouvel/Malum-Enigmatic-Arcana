package net.hazen.enigmatic_arcana.Items.Equipment.Armor.AgroconicSets.ApothicCrusader;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ApothicCrusaderArmorModel extends DefaultedEntityGeoModel<ApothicCrusaderArmorItem> {
    public ApothicCrusaderArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ApothicCrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, "geo/armor/apothic_crusader_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ApothicCrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, "textures/armor/apothic_crusader_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ApothicCrusaderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

