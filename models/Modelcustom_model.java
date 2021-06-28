// Made with Blockbench 3.9.0
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bb_main;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, -1.0F);
		head.cubeList.add(new ModelBox(head, 20, 13, -1.0F, -1.0F, -7.75F, 1, 1, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 21, 16, 0.0F, -1.0F, -7.0F, 1, 1, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 22, 15, -1.5F, -1.5F, -5.75F, 2, 1, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 19, 19, -2.0F, -1.0F, -7.0F, 1, 1, 3, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, -1.0F);
		bone.cubeList.add(new ModelBox(bone, 17, 42, -2.0F, -1.0F, -4.0F, 3, 1, 3, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.0873F, 0.3491F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 26, 27, -1.5F, -1.0F, -2.0F, 3, 1, 3, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone2, 0.0F, 2.6616F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 24, 12, -1.5F, -1.0F, -4.0F, 2, 1, 3, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, 0.3491F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 26, 23, -1.0F, -1.0F, -2.0F, 2, 1, 3, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.0F, 24.0F, 7.0F);
		setRotationAngle(bone3, 0.0F, -0.0436F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 16, 36, -1.0F, -1.0F, -4.0F, 2, 1, 3, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0873F, 0.3491F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 13, 38, 0.0F, -1.0F, -2.0F, 1, 1, 3, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 56, 33, -1.75F, -1.25F, -6.0F, 3, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 56, 34, -2.25F, -1.25F, -6.0F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
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