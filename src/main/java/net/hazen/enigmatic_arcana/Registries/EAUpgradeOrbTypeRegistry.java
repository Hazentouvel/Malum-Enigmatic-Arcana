package net.hazen.enigmatic_arcana.Registries;

import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.resources.ResourceKey;

public class EAUpgradeOrbTypeRegistry {

    public static ResourceKey<UpgradeOrbType> MAGIC_PROFICIENCY_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, EnigmaticArcana.id("magic_proficiency"));
}