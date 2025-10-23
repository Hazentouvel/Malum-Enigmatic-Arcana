package net.hazen.enigmatic_arcana.Items.Equipment.Curios.Spellbooks.Antonomos;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.enigmatic_arcana.Items.Important.EADispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Antonomos extends SpellBook {
    public final EADispatcher dispatcher;
    public Antonomos() {
        super(10);
        this.withSpellbookAttributes(new AttributeContainer[]{
                new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)200.0F, AttributeModifier.Operation.ADD_VALUE)

        });

        this.dispatcher = new EADispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }

}
