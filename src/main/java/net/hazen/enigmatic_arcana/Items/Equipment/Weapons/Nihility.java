package net.hazen.enigmatic_arcana.Items.Equipment.Weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import net.hazen.enigmatic_arcana.Items.Important.EAExtendedWeaponsTiers;
import net.hazen.enigmatic_arcana.Utils.ArcaneScytheItem;
import net.hazen.enigmatic_arcana.Utils.EARarities;
import team.lodestar.lodestone.systems.item.LodestoneItemProperties;

public class Nihility extends ArcaneScytheItem {

    public Nihility() {
        super(
                EAExtendedWeaponsTiers.NIHILITY,
                EAExtendedWeaponsTiers.NIHILITY.getAttackDamageBonus(),
                EAExtendedWeaponsTiers.NIHILITY.getSpeed(),
                6.0f,
                new LodestoneItemProperties()
                        .fireResistant()
                        .rarity(EARarities.AGROCONIC_RARITY_PROXY.getValue())
                        .attributes(
                               ExtendedSwordItem.createAttributes(EAExtendedWeaponsTiers.NIHILITY)
                        )
        );
    }
}
