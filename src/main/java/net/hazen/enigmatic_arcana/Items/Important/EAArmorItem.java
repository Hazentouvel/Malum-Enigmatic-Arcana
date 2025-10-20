package net.hazen.enigmatic_arcana.Items.Important;

import com.google.common.base.Suppliers;
import com.sammy.malum.registry.common.MalumAttributes;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EAArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<ItemAttributeModifiers> defaultModifiers;

    public EAArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, AttributeContainer... attributeContainers) {
        super(material, type, properties);
        this.defaultModifiers = Suppliers.memoize(() ->
        {
            int i = material.value().getDefense(type);
            float f = material.value().toughness();
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
            builder.add(Attributes.ARMOR, new AttributeModifier(resourceLocation, i, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourceLocation, f, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);

            float resistance = material.value().knockbackResistance();
            if (resistance > 0.0F)
            {
                builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourceLocation, resistance, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            }
            for (AttributeContainer holder : attributeContainers)
            {
                builder.add(holder.attribute(), holder.createModifier(type.getSlot().getName()), equipmentSlotGroup);
            }

            return builder.build();
        });
    }

    public static AttributeContainer[] warlock(
                                               int mana,
                                               float spellPower,
                                               float resistSpellPower,
                                               float soulWardCapacity,
                                               float soulWardRecovery
    )
    {
        return new AttributeContainer[]{
                new AttributeContainer(AttributeRegistry.MAX_MANA, mana, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, resistSpellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, spellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(MalumAttributes.SOUL_WARD_CAPACITY, soulWardCapacity, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(MalumAttributes.SOUL_WARD_RECOVERY_RATE, soulWardRecovery, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        };
    }

    public static AttributeContainer[] paragon(
                                                                      int mana,
                                                                      float spellPower,
                                                                      float resistSpellPower,
                                                                      float scytheProficiency,
                                                                      float arcaneResonance
    )
    {
        return new AttributeContainer[]{
                new AttributeContainer(AttributeRegistry.MAX_MANA, mana, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, resistSpellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, spellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(MalumAttributes.SCYTHE_PROFICIENCY, scytheProficiency, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(MalumAttributes.ARCANE_RESONANCE, arcaneResonance, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        };
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.defaultModifiers.get();
    }

    // Geckolib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<EAArmorItem>(this, "controller", this::predicate));
    }

    private PlayState predicate(AnimationState<EAArmorItem> itemAnimationState)
    {
        itemAnimationState.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                if (this.renderer == null) {
                    this.renderer = supplyRenderer();
                }
                return this.renderer;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return null;
    }
}