package net.hazen.enigmatic_arcana.Items.Equipment.Armor.AgroconicSets.ApothicCrusader;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.hazen.enigmatic_arcana.Items.Important.EAArmorMaterials;
import net.hazen.enigmatic_arcana.Items.Important.EAImbuableArmorItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ApothicCrusaderArmorItem extends EAImbuableArmorItem {
    public ApothicCrusaderArmorItem(Type type, Properties properties) {
        super(EAArmorMaterials.AGROCONIC_MATERIAL,
                type,
                properties,
                paragon(
                        150,
                        0.10F,
                        0.10F,
                        0.05F,
                        0.05F)
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new ApothicCrusaderArmorModel());
    }
}