package net.hazen.enigmatic_arcana.Utils;

import com.sammy.malum.common.item.curiosities.weapons.scythe.MagicScytheItem;
import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import team.lodestar.lodestone.systems.item.LodestoneItemProperties;

public class ArcaneScytheItem extends MagicScytheItem implements IPresetSpellContainer {
    public ArcaneScytheItem(Tier tier, float attackDamage, float attackSpeed, float magicDamage, LodestoneItemProperties properties) {
        super(tier, attackDamage, attackSpeed, magicDamage, properties);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
    }
}
