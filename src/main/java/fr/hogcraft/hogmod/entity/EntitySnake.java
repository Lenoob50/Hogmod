
package fr.hogcraft.hogmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class EntitySnake extends ElementsHogmodMod.ModElement {
	public static final int ENTITYID = 7;
	public static final int ENTITYID_RANGED = 8;
	public EntitySnake(ElementsHogmodMod instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("hogmod", "snake"), ENTITYID)
				.name("snake").tracker(64, 3, true).egg(-16724992, -16724890).build());
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
			return new RenderLiving(renderManager, new Modelcustom_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hogmod:textures/green_snake_scales_850px.jpg.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.3f);
			experienceValue = 3;
			this.isImmuneToFire = false;
			setNoAI(!true);
			setCustomNameTag("Naguini");
			setAlwaysRenderNameTag(true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("hogmod:snake_living_sound"));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public boolean canBeCollidedWith() {
			return false;
		}
	}

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
}
