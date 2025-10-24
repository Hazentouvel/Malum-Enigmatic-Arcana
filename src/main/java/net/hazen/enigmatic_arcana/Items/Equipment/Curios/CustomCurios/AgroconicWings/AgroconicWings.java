package net.hazen.enigmatic_arcana.Items.Equipment.Curios.CustomCurios.AgroconicWings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.enigmatic_arcana.Items.Important.EADispatcher;
import net.hazen.enigmatic_arcana.Utils.EARarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class AgroconicWings extends CurioBaseItem {
    public final EADispatcher dispatcher;

    public AgroconicWings() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(EARarities.AGROCONIC_RARITY.getValue())
        );

        this.dispatcher = new EADispatcher();
    }



    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(ALObjects.Attributes.ELYTRA_FLIGHT, new AttributeModifier(id, 1f, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }

    private static final int GLIDE_ANIMATION = 0;

    private void handleFlightState(Player player, ItemStack stack) {
        if (GLIDE_ANIMATION == 0) {
            dispatcher.flight(player, stack);
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!(entity instanceof Player player) || player.level().isClientSide) return;

        if (!player.level().isClientSide && player.isFallFlying()) {
            elytraFlightTick(stack, player, 0);
        }
        if (player.isFallFlying()) {
            handleFlightState(player, stack);
            player.fallDistance = 0.0f;
        } else {
            dispatcher.idle(player, stack);
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
