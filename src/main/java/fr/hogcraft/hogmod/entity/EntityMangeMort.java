
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
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

import fr.hogcraft.hogmod.procedure.ProcedureMangeMortEntityIsHurt;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class EntityMangeMort extends ElementsHogmodMod.ModElement {
	public static final int ENTITYID = 13;
	public static final int ENTITYID_RANGED = 14;
	public EntityMangeMort(ElementsHogmodMod instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("hogmod", "mange_mort"), ENTITYID)
				.name("mange_mort").tracker(64, 3, true).egg(-26215, -16777216).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
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
			return new RenderLiving(renderManager, new Modelmgm(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hogmod:textures/mangemortcouleurs.png.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
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
			return EnumCreatureAttribute.UNDEAD;
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ProcedureMangeMortEntityIsHurt.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

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
}
