package net.hazen.enigmatic_arcana.Registries;

import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class EADamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(
                Registries.DAMAGE_TYPE,
                ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, name).toString())
        );
    }



    public static final ResourceKey<DamageType> DARK_ARTS_MAGIC = register("dark_arts_magic");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(DARK_ARTS_MAGIC, new DamageType(DARK_ARTS_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}