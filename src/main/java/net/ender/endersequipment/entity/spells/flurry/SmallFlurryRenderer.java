package net.ender.endersequipment.entity.spells.flurry;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.holy_wave.HolyWaveProjectile;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.Random;

public class SmallFlurryRenderer extends EntityRenderer<SmallFlurryProjectile> {



    private static final ResourceLocation[] TEXTURE = {
            ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/entity/spells/small_flurry.png")
    };
    public SmallFlurryRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(SmallFlurryProjectile wave, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        PoseStack.Pose pose = poseStack.last();

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, wave.yRotO, wave.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, wave.xRotO, wave.getXRot())));
        float randomZ = new Random(31L * wave.getId()).nextInt(-8, 8);
        poseStack.mulPose(Axis.XP.rotationDegrees(randomZ));

        createSlashTexture(pose, wave, bufferSource, wave.getBbWidth() * 1.1F);

        poseStack.popPose();

        super.render(wave, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SmallFlurryProjectile smallFlurryProjectile) {
        int frame = 0;
        return TEXTURE[frame];
    }

    private void createSlashTexture(PoseStack.Pose pose, SmallFlurryProjectile wave, MultiBufferSource bufferSource, float width)
    {
        Matrix4f poseMatrix = pose.pose();

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(wave)));

        float halfWidth = width * 0.2F;
        float height = wave.getBbHeight() * 0.5F;

        consumer.addVertex(poseMatrix, -halfWidth, height, -halfWidth).setColor(255, 255, 255, 255).setUv(0F, 1F).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0F, 1F, 0F);
        consumer.addVertex(poseMatrix, halfWidth, height, -halfWidth).setColor(255, 255, 255, 255).setUv(1F, 1F).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0F, 1F, 0F);
        consumer.addVertex(poseMatrix, halfWidth, height, halfWidth).setColor(255, 255, 255, 255).setUv(1F, 0F).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0F, 1F, 0F);
        consumer.addVertex(poseMatrix, -halfWidth, height, halfWidth).setColor(255, 255, 255, 255).setUv(0F, 0F).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0F, 1F, 0F);
    }





}
