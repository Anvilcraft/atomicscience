package atomicscience.muoxing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class MAtomicAssembler extends ModelBase {
    ModelRenderer Safety_Glass_Front;
    ModelRenderer Safety_Glass_Right;
    ModelRenderer Safety_Glass_Back;
    ModelRenderer Safety_Glass_Left;
    ModelRenderer Safety_Glass_Top;
    ModelRenderer Circuit1;
    ModelRenderer Circuit2;
    ModelRenderer Circuit3;
    ModelRenderer Circuit4;
    ModelRenderer RAM1;
    ModelRenderer Control_Pad;
    ModelRenderer RAM2;
    ModelRenderer Control_Pad_Ribbon_Cable;
    ModelRenderer RAM3;
    ModelRenderer Control_Pad_Ribbon_Connector;
    ModelRenderer RAM4;
    ModelRenderer Plinth_Base_Ribbon_Connector;
    ModelRenderer Material_Plinth_Core;
    ModelRenderer Material_Plinth_Base;
    ModelRenderer Material_Plinth_Stand;
    ModelRenderer Plinth_Base_Plate;
    ModelRenderer Back_Arm_Upper;
    ModelRenderer Back_Arm_Lower;
    ModelRenderer Right_Arm_Upper;
    ModelRenderer Right_Arm_Lower;
    ModelRenderer Front_Arm_Upper;
    ModelRenderer Front_Arm_Lower;
    ModelRenderer Left_Arm_Upper;
    ModelRenderer Left_Arm_Lower;
    ModelRenderer Middle_Rotor_Focus_Lazer;
    ModelRenderer Middle_Rotor_Uppper_Arm;
    ModelRenderer Middle_Rotor_Lower_Arm;
    ModelRenderer Middle_Rotor_Arm_Base;
    ModelRenderer Middle_Rotor;
    ModelRenderer Bottom_Rotor_Upper_Arm;
    ModelRenderer Bottom_Rotor_Lower_Arm;
    ModelRenderer Bottom_Rotor_Arm_Base;
    ModelRenderer Bottom_Rotor;
    ModelRenderer Resonance_Crystal;
    ModelRenderer Resonator_Unit;
    ModelRenderer Resonator_Assembly;
    ModelRenderer Bottom_Rotor_Resonator_Arm;

    public MAtomicAssembler() {
        super.textureWidth = 65;
        super.textureHeight = 32;
        this.Safety_Glass_Front = new ModelRenderer(this, 35, 0);
        this.Safety_Glass_Front.addBox(0.0F, 0.0F, 0.0F, 15, 15, 0);
        this.Safety_Glass_Front.setRotationPoint(-7.5F, 8.0F, -7.5F);
        this.Safety_Glass_Front.setTextureSize(65, 32);
        this.Safety_Glass_Front.mirror = true;
        this.setRotation(this.Safety_Glass_Front, 0.0F, 0.0F, 0.0F);
        this.Safety_Glass_Right = new ModelRenderer(this, 35, -15);
        this.Safety_Glass_Right.addBox(0.0F, 0.0F, 0.0F, 0, 15, 15);
        this.Safety_Glass_Right.setRotationPoint(-7.5F, 8.0F, -7.5F);
        this.Safety_Glass_Right.setTextureSize(65, 32);
        this.Safety_Glass_Right.mirror = true;
        this.setRotation(this.Safety_Glass_Right, 0.0F, 0.0F, 0.0F);
        this.Safety_Glass_Back = new ModelRenderer(this, 35, 0);
        this.Safety_Glass_Back.addBox(0.0F, 0.0F, 0.0F, 15, 15, 0);
        this.Safety_Glass_Back.setRotationPoint(-7.5F, 8.0F, 7.5F);
        this.Safety_Glass_Back.setTextureSize(65, 32);
        this.Safety_Glass_Back.mirror = true;
        this.setRotation(this.Safety_Glass_Back, 0.0F, 0.0F, 0.0F);
        this.Safety_Glass_Left = new ModelRenderer(this, 35, -15);
        this.Safety_Glass_Left.addBox(0.0F, 0.0F, 0.0F, 0, 15, 15);
        this.Safety_Glass_Left.setRotationPoint(7.5F, 8.0F, -7.5F);
        this.Safety_Glass_Left.setTextureSize(65, 32);
        this.Safety_Glass_Left.mirror = true;
        this.setRotation(this.Safety_Glass_Left, 0.0F, 0.0F, 0.0F);
        this.Safety_Glass_Top = new ModelRenderer(this, 20, 0);
        this.Safety_Glass_Top.addBox(0.0F, 0.0F, 0.0F, 15, 0, 15);
        this.Safety_Glass_Top.setRotationPoint(-7.5F, 8.0F, -7.5F);
        this.Safety_Glass_Top.setTextureSize(65, 32);
        this.Safety_Glass_Top.mirror = true;
        this.setRotation(this.Safety_Glass_Top, 0.0F, 0.0F, 0.0F);
        this.Circuit1 = new ModelRenderer(this, 27, 11);
        this.Circuit1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Circuit1.setRotationPoint(-6.0F, 22.5F, -6.25F);
        this.Circuit1.setTextureSize(65, 32);
        this.Circuit1.mirror = true;
        this.setRotation(this.Circuit1, 0.0F, 0.0F, 0.0F);
        this.Circuit2 = new ModelRenderer(this, 27, 11);
        this.Circuit2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Circuit2.setRotationPoint(-5.0F, 22.5F, -1.0F);
        this.Circuit2.setTextureSize(65, 32);
        this.Circuit2.mirror = true;
        this.setRotation(this.Circuit2, 0.0F, 0.0F, 0.0F);
        this.Circuit3 = new ModelRenderer(this, 27, 11);
        this.Circuit3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Circuit3.setRotationPoint(3.0F, 22.5F, 0.0F);
        this.Circuit3.setTextureSize(65, 32);
        this.Circuit3.mirror = true;
        this.setRotation(this.Circuit3, 0.0F, 0.0F, 0.0F);
        this.Circuit4 = new ModelRenderer(this, 27, 11);
        this.Circuit4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Circuit4.setRotationPoint(-1.0F, 22.5F, -6.0F);
        this.Circuit4.setTextureSize(65, 32);
        this.Circuit4.mirror = true;
        this.setRotation(this.Circuit4, 0.0F, 0.0F, 0.0F);
        this.RAM1 = new ModelRenderer(this, 27, 11);
        this.RAM1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 0);
        this.RAM1.setRotationPoint(2.0F, 22.0F, 6.0F);
        this.RAM1.setTextureSize(65, 32);
        this.RAM1.mirror = true;
        this.setRotation(this.RAM1, 0.0F, 1.570796F, 0.0F);
        this.Control_Pad = new ModelRenderer(this, 50, 25);
        this.Control_Pad.addBox(-3.0F, -1.5F, -1.0F, 4, 4, 1);
        this.Control_Pad.setRotationPoint(-4.0F, 10.0F, -7.0F);
        this.Control_Pad.setTextureSize(65, 32);
        this.Control_Pad.mirror = true;
        this.setRotation(this.Control_Pad, 0.0F, 0.0F, 0.0F);
        this.RAM2 = new ModelRenderer(this, 27, 11);
        this.RAM2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 0);
        this.RAM2.setRotationPoint(2.5F, 22.0F, 6.0F);
        this.RAM2.setTextureSize(65, 32);
        this.RAM2.mirror = true;
        this.setRotation(this.RAM2, 0.0F, 1.570796F, 0.0F);
        this.Control_Pad_Ribbon_Cable = new ModelRenderer(this, 61, 18);
        this.Control_Pad_Ribbon_Cable.addBox(0.0F, 0.0F, 0.0F, 2, 12, 0);
        this.Control_Pad_Ribbon_Cable.setRotationPoint(-6.0F, 11.0F, -6.7F);
        this.Control_Pad_Ribbon_Cable.setTextureSize(65, 32);
        this.Control_Pad_Ribbon_Cable.mirror = true;
        this.setRotation(this.Control_Pad_Ribbon_Cable, 0.0F, 0.0F, 0.0F);
        this.RAM3 = new ModelRenderer(this, 27, 11);
        this.RAM3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 0);
        this.RAM3.setRotationPoint(1.5F, 22.0F, 6.0F);
        this.RAM3.setTextureSize(65, 32);
        this.RAM3.mirror = true;
        this.setRotation(this.RAM3, 0.0F, 1.570796F, 0.0F);
        this.Control_Pad_Ribbon_Connector = new ModelRenderer(this, 50, 16);
        this.Control_Pad_Ribbon_Connector.addBox(0.0F, 0.0F, -0.5F, 3, 1, 1);
        this.Control_Pad_Ribbon_Connector.setRotationPoint(-6.5F, 11.0F, -6.7F);
        this.Control_Pad_Ribbon_Connector.setTextureSize(65, 32);
        this.Control_Pad_Ribbon_Connector.mirror = true;
        this.setRotation(this.Control_Pad_Ribbon_Connector, 0.0F, 0.0F, 0.0F);
        this.RAM4 = new ModelRenderer(this, 27, 11);
        this.RAM4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 0);
        this.RAM4.setRotationPoint(1.0F, 22.0F, 6.0F);
        this.RAM4.setTextureSize(65, 32);
        this.RAM4.mirror = true;
        this.setRotation(this.RAM4, 0.0F, 1.570796F, 0.0F);
        this.Plinth_Base_Ribbon_Connector = new ModelRenderer(this, 50, 16);
        this.Plinth_Base_Ribbon_Connector.addBox(0.0F, 0.0F, -0.5F, 3, 1, 1);
        this.Plinth_Base_Ribbon_Connector.setRotationPoint(-6.5F, 22.0F, -6.7F);
        this.Plinth_Base_Ribbon_Connector.setTextureSize(65, 32);
        this.Plinth_Base_Ribbon_Connector.mirror = true;
        this.setRotation(this.Plinth_Base_Ribbon_Connector, 0.0F, 0.0F, 0.0F);
        this.Material_Plinth_Core = new ModelRenderer(this, 5, 27);
        this.Material_Plinth_Core.addBox(-1.0F, -1.5F, -1.0F, 2, 1, 2);
        this.Material_Plinth_Core.setRotationPoint(0.0F, 18.4F, 0.0F);
        this.Material_Plinth_Core.setTextureSize(65, 32);
        this.Material_Plinth_Core.mirror = true;
        this.setRotation(this.Material_Plinth_Core, 0.0F, 0.7853982F, 0.0F);
        this.Material_Plinth_Base = new ModelRenderer(this, 4, 6);
        this.Material_Plinth_Base.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3);
        this.Material_Plinth_Base.setRotationPoint(0.0F, 18.4F, 0.0F);
        this.Material_Plinth_Base.setTextureSize(65, 32);
        this.Material_Plinth_Base.mirror = true;
        this.setRotation(this.Material_Plinth_Base, 0.0F, 0.7853982F, 0.0F);
        this.Material_Plinth_Stand = new ModelRenderer(this, 0, 9);
        this.Material_Plinth_Stand.addBox(-0.5F, -9.0F, -0.5F, 1, 6, 1);
        this.Material_Plinth_Stand.setRotationPoint(0.0F, 26.5F, 0.0F);
        this.Material_Plinth_Stand.setTextureSize(65, 32);
        this.Material_Plinth_Stand.mirror = true;
        this.setRotation(this.Material_Plinth_Stand, 0.0F, 0.7853982F, 0.0F);
        this.Plinth_Base_Plate = new ModelRenderer(this, 1, 15);
        this.Plinth_Base_Plate.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16);
        this.Plinth_Base_Plate.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Plinth_Base_Plate.setTextureSize(65, 32);
        this.Plinth_Base_Plate.mirror = true;
        this.setRotation(this.Plinth_Base_Plate, 0.0F, 0.0F, 0.0F);
        this.Back_Arm_Upper = new ModelRenderer(this, 30, 1);
        this.Back_Arm_Upper.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Back_Arm_Upper.setRotationPoint(0.0F, 16.9F, 2.5F);
        this.Back_Arm_Upper.setTextureSize(65, 32);
        this.Back_Arm_Upper.mirror = true;
        this.setRotation(this.Back_Arm_Upper, 2.281837F, 3.141593F, 0.0F);
        this.Back_Arm_Lower = new ModelRenderer(this, 30, 5);
        this.Back_Arm_Lower.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Back_Arm_Lower.setRotationPoint(0.0F, 17.4F, 1.0F);
        this.Back_Arm_Lower.setTextureSize(65, 32);
        this.Back_Arm_Lower.mirror = true;
        this.setRotation(this.Back_Arm_Lower, -2.356194F, 3.141593F, 0.0F);
        this.Right_Arm_Upper = new ModelRenderer(this, 30, 1);
        this.Right_Arm_Upper.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Right_Arm_Upper.setRotationPoint(-2.5F, 16.9F, 0.0F);
        this.Right_Arm_Upper.setTextureSize(65, 32);
        this.Right_Arm_Upper.mirror = true;
        this.setRotation(this.Right_Arm_Upper, 2.281837F, 1.570796F, 0.0F);
        this.Right_Arm_Lower = new ModelRenderer(this, 30, 5);
        this.Right_Arm_Lower.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Right_Arm_Lower.setRotationPoint(-1.0F, 17.4F, 0.0F);
        this.Right_Arm_Lower.setTextureSize(65, 32);
        this.Right_Arm_Lower.mirror = true;
        this.setRotation(this.Right_Arm_Lower, -2.356194F, 1.570796F, 0.0F);
        this.Front_Arm_Upper = new ModelRenderer(this, 30, 1);
        this.Front_Arm_Upper.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Front_Arm_Upper.setRotationPoint(0.0F, 16.9F, -2.5F);
        this.Front_Arm_Upper.setTextureSize(65, 32);
        this.Front_Arm_Upper.mirror = true;
        this.setRotation(this.Front_Arm_Upper, 2.281837F, 0.0F, 0.0F);
        this.Front_Arm_Lower = new ModelRenderer(this, 30, 5);
        this.Front_Arm_Lower.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Front_Arm_Lower.setRotationPoint(0.0F, 17.4F, -1.0F);
        this.Front_Arm_Lower.setTextureSize(65, 32);
        this.Front_Arm_Lower.mirror = true;
        this.setRotation(this.Front_Arm_Lower, -2.356194F, 0.0F, 0.0F);
        this.Left_Arm_Upper = new ModelRenderer(this, 30, 1);
        this.Left_Arm_Upper.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Left_Arm_Upper.setRotationPoint(2.5F, 16.9F, 0.0F);
        this.Left_Arm_Upper.setTextureSize(65, 32);
        this.Left_Arm_Upper.mirror = true;
        this.setRotation(this.Left_Arm_Upper, 2.281837F, -1.570796F, 0.0F);
        this.Left_Arm_Lower = new ModelRenderer(this, 30, 5);
        this.Left_Arm_Lower.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.Left_Arm_Lower.setRotationPoint(1.0F, 17.4F, 0.0F);
        this.Left_Arm_Lower.setTextureSize(65, 32);
        this.Left_Arm_Lower.mirror = true;
        this.setRotation(this.Left_Arm_Lower, -2.356194F, -1.570796F, 0.0F);
        this.Middle_Rotor_Focus_Lazer = new ModelRenderer(this, 11, 18);
        this.Middle_Rotor_Focus_Lazer.addBox(2.5F, -0.5F, -0.5F, 2, 1, 1);
        this.Middle_Rotor_Focus_Lazer.setRotationPoint(0.0F, 14.8F, 0.0F);
        this.Middle_Rotor_Focus_Lazer.setTextureSize(65, 32);
        this.Middle_Rotor_Focus_Lazer.mirror = true;
        this.setRotation(this.Middle_Rotor_Focus_Lazer, 0.0F, -0.7853982F, -0.3316126F);
        this.Middle_Rotor_Uppper_Arm = new ModelRenderer(this, 50, 19);
        this.Middle_Rotor_Uppper_Arm.addBox(0.8F, -4.0F, -0.5F, 3, 1, 1);
        this.Middle_Rotor_Uppper_Arm.setRotationPoint(0.0F, 14.3F, 0.0F);
        this.Middle_Rotor_Uppper_Arm.setTextureSize(65, 32);
        this.Middle_Rotor_Uppper_Arm.mirror = true;
        this.setRotation(this.Middle_Rotor_Uppper_Arm, 0.0F, -0.7853982F, 1.082104F);
        this.Middle_Rotor_Lower_Arm = new ModelRenderer(this, 17, 7);
        this.Middle_Rotor_Lower_Arm.addBox(-0.5F, -0.6F, 4.5F, 1, 5, 1);
        this.Middle_Rotor_Lower_Arm.setRotationPoint(0.0F, 14.3F, 0.0F);
        this.Middle_Rotor_Lower_Arm.setTextureSize(65, 32);
        this.Middle_Rotor_Lower_Arm.mirror = true;
        this.setRotation(this.Middle_Rotor_Lower_Arm, -0.3839724F, 0.7853982F, 0.0F);
        this.Middle_Rotor_Arm_Base = new ModelRenderer(this, 11, 21);
        this.Middle_Rotor_Arm_Base.addBox(1.5F, -0.5F, -0.5F, 2, 1, 1);
        this.Middle_Rotor_Arm_Base.setRotationPoint(0.0F, 20.6F, 0.0F);
        this.Middle_Rotor_Arm_Base.setTextureSize(65, 32);
        this.Middle_Rotor_Arm_Base.mirror = true;
        this.setRotation(this.Middle_Rotor_Arm_Base, 0.0F, -0.7853982F, 0.0F);
        this.Middle_Rotor = new ModelRenderer(this, 4, 1);
        this.Middle_Rotor.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3);
        this.Middle_Rotor.setRotationPoint(0.0F, 20.6F, 0.0F);
        this.Middle_Rotor.setTextureSize(65, 32);
        this.Middle_Rotor.mirror = true;
        this.setRotation(this.Middle_Rotor, 0.0F, 0.0F, 0.0F);
        this.Bottom_Rotor_Upper_Arm = new ModelRenderer(this, 17, 6);
        this.Bottom_Rotor_Upper_Arm.addBox(-0.5F, -6.2F, -4.1F, 1, 1, 8);
        this.Bottom_Rotor_Upper_Arm.setRotationPoint(0.0F, 15.3F, 0.0F);
        this.Bottom_Rotor_Upper_Arm.setTextureSize(65, 32);
        this.Bottom_Rotor_Upper_Arm.mirror = true;
        this.setRotation(this.Bottom_Rotor_Upper_Arm, -1.082104F, -0.7853982F, 0.0F);
        this.Bottom_Rotor_Lower_Arm = new ModelRenderer(this, 0, 0);
        this.Bottom_Rotor_Lower_Arm.addBox(-0.5F, -2.2F, 6.0F, 1, 7, 1);
        this.Bottom_Rotor_Lower_Arm.setRotationPoint(0.0F, 15.3F, 0.0F);
        this.Bottom_Rotor_Lower_Arm.setTextureSize(65, 32);
        this.Bottom_Rotor_Lower_Arm.mirror = true;
        this.setRotation(this.Bottom_Rotor_Lower_Arm, -0.3839724F, -0.7853982F, 0.0F);
        this.Bottom_Rotor_Arm_Base = new ModelRenderer(this, 50, 22);
        this.Bottom_Rotor_Arm_Base.addBox(1.0F, -0.5F, -0.5F, 4, 1, 1);
        this.Bottom_Rotor_Arm_Base.setRotationPoint(0.0F, 21.9F, 0.0F);
        this.Bottom_Rotor_Arm_Base.setTextureSize(65, 32);
        this.Bottom_Rotor_Arm_Base.mirror = true;
        this.setRotation(this.Bottom_Rotor_Arm_Base, 0.0F, -2.356194F, 0.0F);
        this.Bottom_Rotor = new ModelRenderer(this, 4, 11);
        this.Bottom_Rotor.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3);
        this.Bottom_Rotor.setRotationPoint(0.0F, 21.9F, 0.0F);
        this.Bottom_Rotor.setTextureSize(65, 32);
        this.Bottom_Rotor.mirror = true;
        this.setRotation(this.Bottom_Rotor, 0.0F, -1.570796F, 0.0F);
        this.Resonance_Crystal = new ModelRenderer(this, 0, 27);
        this.Resonance_Crystal.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
        this.Resonance_Crystal.setRotationPoint(0.0F, 10.7F, 0.0F);
        this.Resonance_Crystal.setTextureSize(65, 32);
        this.Resonance_Crystal.mirror = true;
        this.setRotation(this.Resonance_Crystal, 0.7853982F, 3.141593F, 0.6108652F);
        this.Resonator_Unit = new ModelRenderer(this, 17, 1);
        this.Resonator_Unit.addBox(-1.0F, -8.0F, -1.0F, 2, 2, 2);
        this.Resonator_Unit.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.Resonator_Unit.setTextureSize(65, 32);
        this.Resonator_Unit.mirror = true;
        this.setRotation(this.Resonator_Unit, 0.0F, -2.356194F, 0.0F);
        this.Resonator_Assembly = new ModelRenderer(this, 0, 21);
        this.Resonator_Assembly.addBox(-1.5F, -8.9F, -1.5F, 3, 2, 3);
        this.Resonator_Assembly.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.Resonator_Assembly.setTextureSize(65, 32);
        this.Resonator_Assembly.mirror = true;
        this.setRotation(this.Resonator_Assembly, 0.0F, -1.570796F, 0.0F);
        this.Bottom_Rotor_Resonator_Arm = new ModelRenderer(this, 0, 17);
        this.Bottom_Rotor_Resonator_Arm.addBox(1.5F, -10.6F, -1.0F, 3, 1, 2);
        this.Bottom_Rotor_Resonator_Arm.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Bottom_Rotor_Resonator_Arm.setTextureSize(65, 32);
        this.Bottom_Rotor_Resonator_Arm.mirror = true;
        this.setRotation(this.Bottom_Rotor_Resonator_Arm, 0.0F, -2.356194F, 0.0F);
    }

    public void
    render(float rotationYaw, float rotationYaw2, float rotationYaw3, float f5) {
        this.Safety_Glass_Front.render(f5);
        this.Safety_Glass_Right.render(f5);
        this.Safety_Glass_Back.render(f5);
        this.Safety_Glass_Left.render(f5);
        this.Safety_Glass_Top.render(f5);
        this.Circuit1.render(f5);
        this.Circuit2.render(f5);
        this.Circuit3.render(f5);
        this.Circuit4.render(f5);
        this.RAM1.render(f5);
        this.Control_Pad.render(f5);
        this.RAM2.render(f5);
        this.Control_Pad_Ribbon_Cable.render(f5);
        this.RAM3.render(f5);
        this.Control_Pad_Ribbon_Connector.render(f5);
        this.RAM4.render(f5);
        this.Plinth_Base_Ribbon_Connector.render(f5);
        this.Material_Plinth_Core.render(f5);
        this.Material_Plinth_Base.render(f5);
        this.Material_Plinth_Stand.render(f5);
        this.Plinth_Base_Plate.render(f5);
        GL11.glPushMatrix();
        GL11.glRotatef(-rotationYaw, 0.0F, 1.0F, 0.0F);
        this.Back_Arm_Upper.render(f5);
        this.Back_Arm_Lower.render(f5);
        this.Right_Arm_Upper.render(f5);
        this.Right_Arm_Lower.render(f5);
        this.Front_Arm_Upper.render(f5);
        this.Front_Arm_Lower.render(f5);
        this.Left_Arm_Upper.render(f5);
        this.Left_Arm_Lower.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glRotatef(rotationYaw2, 0.0F, 1.0F, 0.0F);
        this.Middle_Rotor_Focus_Lazer.render(f5);
        this.Middle_Rotor_Uppper_Arm.render(f5);
        this.Middle_Rotor_Lower_Arm.render(f5);
        this.Middle_Rotor_Arm_Base.render(f5);
        this.Middle_Rotor.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glRotatef(-rotationYaw3, 0.0F, 1.0F, 0.0F);
        this.Bottom_Rotor_Upper_Arm.render(f5);
        this.Bottom_Rotor_Lower_Arm.render(f5);
        this.Bottom_Rotor_Arm_Base.render(f5);
        this.Bottom_Rotor.render(f5);
        this.Bottom_Rotor_Resonator_Arm.render(f5);
        GL11.glPopMatrix();
        this.Resonance_Crystal.rotateAngleY
            = (float) Math.toRadians((double) rotationYaw);
        this.Resonance_Crystal.render(f5);
        this.Resonator_Unit.render(f5);
        this.Resonator_Assembly.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
