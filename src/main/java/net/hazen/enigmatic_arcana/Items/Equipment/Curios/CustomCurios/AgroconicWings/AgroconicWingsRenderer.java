package net.hazen.enigmatic_arcana.Items.Equipment.Curios.CustomCurios.AgroconicWings;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.model.AzBakedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

@OnlyIn(Dist.CLIENT)
public class AgroconicWingsRenderer implements ICurioRenderer {
    private final AgroconicWingsItemRenderer curioRenderer = new AgroconicWingsItemRenderer();

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource renderTypeBuffer,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {

        LivingEntity entity = slotContext.entity();

        matrixStack.pushPose();

        curioRenderer.prepForRender(entity, stack, EquipmentSlot.BODY, (HumanoidModel<?>) renderLayerParent.getModel());

        matrixStack.translate(0.0D, -0.8D, 0.0D); // x = sideways, y = up/down, z = forward/back

        AzBakedModel model = curioRenderer.provider().provideBakedModel(entity, stack);
        ResourceLocation textureLocation = AgroconicWingsItemRenderer.TEX;
        RenderType renderType = RenderType.entityCutout(textureLocation);
        VertexConsumer buffer = renderTypeBuffer.getBuffer(renderType);

        curioRenderer.rendererPipeline().render(matrixStack, model, stack, renderTypeBuffer, renderType, buffer, netHeadYaw, partialTicks, light);

        matrixStack.popPose();

    }
}