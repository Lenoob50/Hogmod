// Made with Blockbench 3.9.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelmgm extends ModelBase {
	private final ModelRenderer feet;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;

	public Modelmgm() {
		textureWidth = 64;
		textureHeight = 64;

		feet = new ModelRenderer(this);
		feet.setRotationPoint(-4.0F, 24.0F, -2.0F);
		feet.cubeList.add(new ModelBox(feet, 29, 2, -1.0F, -3.0F, 0.0F, 4, 3, 4, 0.0F, false));
		feet.cubeList.add(new ModelBox(feet, 27, 3, 5.0F, -3.0F, 0.0F, 4, 3, 4, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 28, 40, -6.0F, -19.0F, -3.0F, 12, 18, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 13, 52, -6.0F, -26.0F, -3.0F, 5, 7, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 13, 56, 1.0F, -26.0F, -3.0F, 5, 7, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 38, 58, -1.0F, -23.0F, -3.0F, 2, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 17, 52, -6.0F, -26.0F, -2.0F, 12, 7, 5, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-10.0F, 1.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.5236F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 11, 54, 5.0F, 3.0F, -3.0F, 10, 4, 6, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 49, 15.0F, -2.0F, -3.0F, 4, 9, 6, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 6, 49, 1.0F, -2.0F, -3.0F, 4, 9, 6, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 11, 44, -5.0F, -36.0F, -5.0F, 10, 10, 10, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -7.0F, -37.0F, -7.0F, 14, 1, 14, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -6.0F, -38.0F, -6.0F, 12, 1, 12, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 13, 0, -5.0F, -43.0F, -5.0F, 10, 5, 10, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -4.0F, -44.0F, -4.0F, 8, 1, 8, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -3.0F, -50.0F, -3.0F, 6, 6, 6, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -2.0F, -51.0F, -2.0F, 4, 1, 4, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -1.0F, -57.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 1.0F);
		bone5.cubeList.add(new ModelBox(bone5, 17, 17, -5.0F, -36.0F, -7.0F, 1, 11, 1, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 13, 16, 4.0F, -36.0F, -7.0F, 1, 11, 1, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 12, 20, -4.0F, -36.0F, -7.0F, 8, 2, 1, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 21, 21, -2.0F, -34.0F, -7.0F, 4, 3, 1, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 5, 19, -4.0F, -31.0F, -7.0F, 8, 6, 1, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -4.0F, -34.0F, -5.5F, 2, 3, 1, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, 2.0F, -34.0F, -5.5F, 2, 3, 1, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.75F);
		bone7.cubeList.add(new ModelBox(bone7, 16, 37, 3.0F, -30.0F, -7.0F, 1, 2, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 16, 34, 2.0F, -29.0F, -7.0F, 1, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 20, 35, -3.0F, -29.0F, -7.0F, 1, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 20, 39, -1.0F, -34.0F, -7.0F, 2, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 26, 37, -1.0F, -26.5F, -7.0F, 2, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 16, 33, 2.75F, -26.25F, -7.0F, 2, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 27, 37, -4.75F, -26.25F, -7.0F, 2, 1, 1, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 29, 38, -4.0F, -30.0F, -7.0F, 1, 2, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -40.0F, 0.75F);
		setRotationAngle(bone8, 0.0F, 0.0F, -3.1416F);
		bone8.cubeList.add(new ModelBox(bone8, 16, 34, 3.0F, -30.0F, -7.0F, 1, 2, 1, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 23, 34, 2.0F, -29.0F, -7.0F, 1, 1, 1, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 15, 38, -3.0F, -29.0F, -7.0F, 1, 1, 1, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 23, 35, -1.0F, -34.0F, -7.0F, 2, 1, 1, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 24, 36, -4.0F, -30.0F, -7.0F, 1, 2, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		feet.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
		bone5.render(f5);
		bone6.render(f5);
		bone7.render(f5);
		bone8.render(f5);
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