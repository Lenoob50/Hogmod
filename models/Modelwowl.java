// Made with Blockbench 3.9.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelwowl extends ModelBase {
	private final ModelRenderer bone2;
	private final ModelRenderer body;
	private final ModelRenderer bone;
	private final ModelRenderer rightwing;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer leftwing;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bb_main;

	public Modelwowl() {
		textureWidth = 64;
		textureHeight = 64;

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 23.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(body);
		body.cubeList.add(new ModelBox(body, 20, 20, -3.0F, -12.0F, -2.0F, 6, 12, 5, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 31, 28, -1.0F, -11.0F, -2.5F, 2, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 27, 27, -1.0F, -2.0F, -2.5F, 2, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 23, 19, -2.0F, -10.0F, -2.5F, 4, 8, 1, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 16, 24, -3.0F, -18.0F, -3.0F, 6, 6, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 58, 62, -1.0F, -14.0F, -4.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 59, 55, -1.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 33, 22, -2.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 60, 55, 0.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 33, 24, 1.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 29, 30, 2.0F, -20.0F, 2.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 29, -3.0F, -20.0F, 2.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 31, 29, -3.0F, -19.0F, 1.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 33, 28, 2.0F, -19.0F, 1.0F, 1, 1, 1, 0.0F, false));

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(3.25F, -2.5F, 0.0F);
		bone2.addChild(rightwing);
		setRotationAngle(rightwing, 0.0F, 0.0F, -0.2618F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightwing.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.6981F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 21, 28, -9.0F, 1.75F, 0.0F, 1, 1, 3, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightwing.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6109F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 20, 30, -9.0F, -7.0F, -1.0F, 1, 8, 3, 0.0F, false));

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(2.0F, -1.0F, 0.0F);
		bone2.addChild(leftwing);
		setRotationAngle(leftwing, 0.0F, 0.0F, 0.4363F);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftwing.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.6981F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 28, 29, 3.0F, -2.0F, 0.0F, 1, 1, 3, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 26, 28, 3.0F, -10.0F, -1.0F, 1, 8, 3, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 29, 44, -4.0F, -1.0F, -3.0F, 2, 1, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 29, 44, 2.0F, -1.0F, -3.0F, 2, 1, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 28, 29, -2.0F, -2.0F, 3.0F, 4, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 34, -2.0F, -1.0F, 3.0F, 4, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 29, 33, -2.0F, -1.0F, 4.0F, 4, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 33, 38, 1.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 31, 34, -2.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone2.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}