package atomicscience.muoxing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class MReactorCellBottom extends ModelBase {
    ModelRenderer BaseWidth;
    ModelRenderer BottomPad;
    ModelRenderer BaseDepth;
    ModelRenderer Base;
    ModelRenderer MiddleFrontRight;
    ModelRenderer MiddleFrontLeft;
    ModelRenderer MiddleBackLeft;
    ModelRenderer MiddleBackRight;
    ModelRenderer MiddlePLeft;
    ModelRenderer MiddlePFront;
    ModelRenderer MiddlePBack;
    ModelRenderer MiddlePRight;
    ModelRenderer OPLeftFront;
    ModelRenderer OPFrontRight;
    ModelRenderer OPBackLeft;
    ModelRenderer OPLeftFront2;
    ModelRenderer OPRightBack;
    ModelRenderer OPFrontLeft;
    ModelRenderer OPLeftBack;
    ModelRenderer OPBackRight;

    public MReactorCellBottom() {
        super.textureWidth = 128;
        super.textureHeight = 128;
        this.BaseWidth = new ModelRenderer(this, 53, 16);
        this.BaseWidth.addBox(0.0F, 0.0F, 0.0F, 14, 1, 10);
        this.BaseWidth.setRotationPoint(-7.0F, 22.0F, -5.0F);
        this.BaseWidth.setTextureSize(128, 128);
        this.BaseWidth.mirror = true;
        this.setRotation(this.BaseWidth, 0.0F, 0.0F, 0.0F);
        this.BottomPad = new ModelRenderer(this, 53, 42);
        this.BottomPad.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
        this.BottomPad.setRotationPoint(-5.0F, 23.0F, -5.0F);
        this.BottomPad.setTextureSize(128, 128);
        this.BottomPad.mirror = true;
        this.setRotation(this.BottomPad, 0.0F, 0.0F, 0.0F);
        this.BaseDepth = new ModelRenderer(this, 53, 0);
        this.BaseDepth.addBox(0.0F, 0.0F, 0.0F, 10, 1, 14);
        this.BaseDepth.setRotationPoint(-5.0F, 22.0F, -7.0F);
        this.BaseDepth.setTextureSize(128, 128);
        this.BaseDepth.mirror = true;
        this.setRotation(this.BaseDepth, 0.0F, 0.0F, 0.0F);
        this.Base = new ModelRenderer(this, 53, 28);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12);
        this.Base.setRotationPoint(-6.0F, 22.0F, -6.0F);
        this.Base.setTextureSize(128, 128);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
        this.MiddleFrontRight = new ModelRenderer(this, 0, 68);
        this.MiddleFrontRight.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.MiddleFrontRight.setRotationPoint(3.0F, 8.0F, -4.0F);
        this.MiddleFrontRight.setTextureSize(128, 128);
        this.MiddleFrontRight.mirror = true;
        this.setRotation(this.MiddleFrontRight, 0.0F, 0.0F, 0.0F);
        this.MiddleFrontLeft = new ModelRenderer(this, 0, 68);
        this.MiddleFrontLeft.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.MiddleFrontLeft.setRotationPoint(-4.0F, 8.0F, -4.0F);
        this.MiddleFrontLeft.setTextureSize(128, 128);
        this.MiddleFrontLeft.mirror = true;
        this.setRotation(this.MiddleFrontLeft, 0.0F, 0.0F, 0.0F);
        this.MiddleBackLeft = new ModelRenderer(this, 0, 68);
        this.MiddleBackLeft.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.MiddleBackLeft.setRotationPoint(-4.0F, 8.0F, 3.0F);
        this.MiddleBackLeft.setTextureSize(128, 128);
        this.MiddleBackLeft.mirror = true;
        this.setRotation(this.MiddleBackLeft, 0.0F, 0.0F, 0.0F);
        this.MiddleBackRight = new ModelRenderer(this, 0, 68);
        this.MiddleBackRight.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.MiddleBackRight.setRotationPoint(3.0F, 8.0F, 3.0F);
        this.MiddleBackRight.setTextureSize(128, 128);
        this.MiddleBackRight.mirror = true;
        this.setRotation(this.MiddleBackRight, 0.0F, 0.0F, 0.0F);
        this.MiddlePLeft = new ModelRenderer(this, 5, 68);
        this.MiddlePLeft.addBox(0.0F, 1.466667F, 0.0F, 1, 14, 6);
        this.MiddlePLeft.setRotationPoint(-5.0F, 6.5F, -3.0F);
        this.MiddlePLeft.setTextureSize(128, 128);
        this.MiddlePLeft.mirror = true;
        this.setRotation(this.MiddlePLeft, 0.0F, 0.0F, 0.0F);
        this.MiddlePFront = new ModelRenderer(this, 23, 83);
        this.MiddlePFront.addBox(0.0F, 0.0F, 0.0F, 6, 14, 1);
        this.MiddlePFront.setRotationPoint(-3.0F, 8.0F, -5.0F);
        this.MiddlePFront.setTextureSize(128, 128);
        this.MiddlePFront.mirror = true;
        this.setRotation(this.MiddlePFront, 0.0F, 0.0F, 0.0F);
        this.MiddlePBack = new ModelRenderer(this, 23, 83);
        this.MiddlePBack.addBox(0.0F, 0.0F, 0.0F, 6, 14, 1);
        this.MiddlePBack.setRotationPoint(-3.0F, 8.0F, 4.0F);
        this.MiddlePBack.setTextureSize(128, 128);
        this.MiddlePBack.mirror = true;
        this.setRotation(this.MiddlePBack, 0.0F, 0.0F, 0.0F);
        this.MiddlePRight = new ModelRenderer(this, 5, 68);
        this.MiddlePRight.addBox(0.0F, 0.0F, 0.0F, 1, 14, 6);
        this.MiddlePRight.setRotationPoint(4.0F, 8.0F, -3.0F);
        this.MiddlePRight.setTextureSize(128, 128);
        this.MiddlePRight.mirror = true;
        this.setRotation(this.MiddlePRight, 0.0F, 0.0F, 0.0F);
        this.OPLeftFront = new ModelRenderer(this, 0, 0);
        this.OPLeftFront.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPLeftFront.setRotationPoint(-7.0F, 8.0F, -4.0F);
        this.OPLeftFront.setTextureSize(128, 128);
        this.OPLeftFront.mirror = true;
        this.setRotation(this.OPLeftFront, 0.0F, 0.0F, 0.0F);
        this.OPFrontRight = new ModelRenderer(this, 0, 0);
        this.OPFrontRight.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPFrontRight.setRotationPoint(3.0F, 8.0F, -7.0F);
        this.OPFrontRight.setTextureSize(128, 128);
        this.OPFrontRight.mirror = true;
        this.setRotation(this.OPFrontRight, 0.0F, 0.0F, 0.0F);
        this.OPBackLeft = new ModelRenderer(this, 0, 0);
        this.OPBackLeft.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPBackLeft.setRotationPoint(-4.0F, 8.0F, 6.0F);
        this.OPBackLeft.setTextureSize(128, 128);
        this.OPBackLeft.mirror = true;
        this.setRotation(this.OPBackLeft, 0.0F, 0.0F, 0.0F);
        this.OPLeftFront2 = new ModelRenderer(this, 0, 0);
        this.OPLeftFront2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPLeftFront2.setRotationPoint(6.0F, 8.0F, -4.0F);
        this.OPLeftFront2.setTextureSize(128, 128);
        this.OPLeftFront2.mirror = true;
        this.setRotation(this.OPLeftFront2, 0.0F, 0.0F, 0.0F);
        this.OPRightBack = new ModelRenderer(this, 0, 0);
        this.OPRightBack.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPRightBack.setRotationPoint(6.0F, 8.0F, 3.0F);
        this.OPRightBack.setTextureSize(128, 128);
        this.OPRightBack.mirror = true;
        this.setRotation(this.OPRightBack, 0.0F, 0.0F, 0.0F);
        this.OPFrontLeft = new ModelRenderer(this, 0, 0);
        this.OPFrontLeft.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPFrontLeft.setRotationPoint(-4.0F, 8.0F, -7.0F);
        this.OPFrontLeft.setTextureSize(128, 128);
        this.OPFrontLeft.mirror = true;
        this.setRotation(this.OPFrontLeft, 0.0F, 0.0F, 0.0F);
        this.OPLeftBack = new ModelRenderer(this, 0, 0);
        this.OPLeftBack.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPLeftBack.setRotationPoint(-7.0F, 8.0F, 3.0F);
        this.OPLeftBack.setTextureSize(128, 128);
        this.OPLeftBack.mirror = true;
        this.setRotation(this.OPLeftBack, 0.0F, 0.0F, 0.0F);
        this.OPBackRight = new ModelRenderer(this, 0, 0);
        this.OPBackRight.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
        this.OPBackRight.setRotationPoint(3.0F, 8.0F, 6.0F);
        this.OPBackRight.setTextureSize(128, 128);
        this.OPBackRight.mirror = true;
        this.setRotation(this.OPBackRight, 0.0F, 0.0F, 0.0F);
    }

    public void render(float f5) {
        this.BaseWidth.render(f5);
        this.BottomPad.render(f5);
        this.BaseDepth.render(f5);
        this.Base.render(f5);
        this.MiddleFrontRight.render(f5);
        this.MiddleFrontLeft.render(f5);
        this.MiddleBackLeft.render(f5);
        this.MiddleBackRight.render(f5);
        this.MiddlePLeft.render(f5);
        this.MiddlePFront.render(f5);
        this.MiddlePBack.render(f5);
        this.MiddlePRight.render(f5);
        this.OPLeftFront.render(f5);
        this.OPFrontRight.render(f5);
        this.OPBackLeft.render(f5);
        this.OPLeftFront2.render(f5);
        this.OPRightBack.render(f5);
        this.OPFrontLeft.render(f5);
        this.OPLeftBack.render(f5);
        this.OPBackRight.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
