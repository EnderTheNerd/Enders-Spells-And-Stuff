package net.ender.endersequipment.entity.spells.overhwhelming;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.madness_wave.MadnessWave;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

import java.util.Random;

public class OverwhelmingStrikeRenderer  extends EntityRenderer<OverwhelmingStrike> {

    private static final ResourceLocation[] TEXTURES = {
            ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/entity/spells/overwhelming_strike/overwhelming_strike1.png"),
            ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/entity/spells/overwhelming_strike/overwhelming_strike2.png"),
            ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/entity/spells/overwhelming_strike/overwhelming_strike3.png"),
            ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/entity/spells/overwhelming_strike/overwhelming_strike4.png"),
    };

    public OverwhelmingStrikeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }


    @Override
    public void render(OverwhelmingStrike entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();

        PoseStack.Pose pose = poseStack.last();
        poseStack.mulPose(Axis.YP.rotationDegrees(90 - entity.getYRot()));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getXRot()));
        float randomZ = new Random(31L * entity.getId()).nextInt(-8, 8);
        poseStack.mulPose(Axis.XP.rotationDegrees(randomZ));

        drawStrike(pose, entity, bufferSource, entity.getBbWidth() * 1.5f, entity.isMirrored());

        poseStack.popPose();

        super.render(entity, yaw, partialTicks, poseStack, bufferSource, light);
    }




    private void drawStrike(PoseStack.Pose pose, OverwhelmingStrike entity, MultiBufferSource bufferSource, float width, boolean mirrored) {
        Matrix4f poseMatrix = pose.pose();

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(entity)));
        float halfWidth = width * .5f;
        float height = entity.getBbHeight() * .5f;

        consumer.addVertex(poseMatrix, -halfWidth, height, -halfWidth).setColor(255, 255, 255, 255).setUv(0f, mirrored ? 0f : 1f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, halfWidth, height, -halfWidth).setColor(255, 255, 255, 255).setUv(1f, mirrored ? 0f : 1f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, halfWidth, height, halfWidth).setColor(255, 255, 255, 255).setUv(1f, mirrored ? 1f : 0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, -halfWidth, height, halfWidth).setColor(255, 255, 255, 255).setUv(0f, mirrored ? 1f : 0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(LightTexture.FULL_BRIGHT).setNormal(0f, 1f, 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(OverwhelmingStrike entity) {
        int frame = (entity.tickCount / entity.ticksPerFrame) % TEXTURES.length;
        return TEXTURES[frame];
        //return TEXTURE;
    }

}
