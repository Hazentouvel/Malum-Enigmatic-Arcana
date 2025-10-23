package net.hazen.enigmatic_arcana.Registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.enigmatic_arcana.Datagen.EATags;
import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class EASchoolRegistry {
    private static final DeferredRegister<SchoolType> EA_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, EnigmaticArcana.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        EA_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return EA_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    public static final ResourceLocation DARK_ARTS_RESOURCE = EnigmaticArcana.id("dark_arts");

    public static final Supplier<SchoolType> DARK_ARTS = registerSchool(new SchoolType
            (
                    DARK_ARTS_RESOURCE,
                    EATags.DARK_ARTS_FOCUS,
                    Component.translatable("school.enigmatic_arcana.dark_arts").withStyle(Style.EMPTY.withColor(0x841236)),
                    LodestoneAttributes.MAGIC_PROFICIENCY,
                    LodestoneAttributes.MAGIC_RESISTANCE,
                    SoundRegistry.BLOOD_CAST,
                    EADamageTypes.DARK_ARTS_MAGIC
            ));
}