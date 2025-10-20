package net.hazen.enigmatic_arcana.Utils;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.UnaryOperator;

public class EARarities {

    public static final EnumProxy<Rarity> AGROCONIC_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "discerning_the_eldritch:apothic",
            (UnaryOperator<Style>) ((style) -> style.withColor(0x841236))
            );
}