
package fr.hogcraft.hogmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.block.state.IBlockState;

import java.util.Iterator;
import java.util.ArrayList;

import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class EntityBrowOwl extends ElementsHogmodMod.ModElement {
	public static final int ENTITYID = 9;
	public static final int ENTITYID_RANGED = 10;
	public EntityBrowOwl(ElementsHogmodMod instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("hogmod", "brow_owl"), ENTITYID)
				.name("brow_owl").tracker(64, 3, true).egg(-3381760, -16737997).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.CREATURE, spawnBiomes);
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelbrownowl(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hogmod:textures/tumblr_pikq270kyf1t6uw0uo1_400.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public EntityCustom createChild(EntityAgeable ageable) {
			return new EntityCustom(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Items.SUGAR, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.9.0
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelbrownowl extends ModelBase {
		private final ModelRenderer bone2;
		private final ModelRenderer body;
		private final ModelRenderer bone;
		private final ModelRenderer rightwing;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer leftwing;
		private final ModelRenderer cube_r3;
		private final ModelRenderer bb_main;
		public Modelbrownowl() {
			textureWidth = 64;
			textureHeight = 64;
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 23.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(body);
			body.cubeList.add(new ModelBox(body, 21, 25, -3.0F, -12.0F, -2.0F, 6, 12, 5, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 31, 44, -1.0F, -11.0F, -2.5F, 2, 1, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 31, 44, -1.0F, -2.0F, -2.5F, 2, 1, 1, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 30, 40, -2.0F, -10.0F, -2.5F, 4, 8, 1, 0.0F, false));
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(bone);
			bone.cubeList.add(new ModelBox(bone, 20, 27, -3.0F, -18.0F, -3.0F, 6, 6, 6, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 37, 43, -1.0F, -14.0F, -4.0F, 2, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -1.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 53, 56, -2.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 57, 4, 0.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 49, 53, 1.75F, -16.0F, -3.25F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 29, 30, 2.0F, -20.0F, 2.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 25, 29, -3.0F, -20.0F, 2.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 31, 29, -3.0F, -19.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 33, 28, 2.0F, -19.0F, 1.0F, 1, 1, 1, 0.0F, false));
			rightwing = new ModelRenderer(this);
			rightwing.setRotationPoint(-0.75F, 1.0F, 0.0F);
			bone2.addChild(rightwing);
			setRotationAngle(rightwing, 0.0F, 0.0F, 0.1309F);
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
			leftwing.setRotationPoint(8.0F, 0.0F, 0.0F);
			bone2.addChild(leftwing);
			setRotationAngle(leftwing, 0.0F, 0.0F, -0.1745F);
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
}
