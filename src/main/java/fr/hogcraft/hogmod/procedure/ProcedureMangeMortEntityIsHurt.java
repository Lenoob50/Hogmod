package fr.hogcraft.hogmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureMangeMortEntityIsHurt extends ElementsHogmodMod.ModElement {
	public ProcedureMangeMortEntityIsHurt(ElementsHogmodMod instance) {
		super(instance, 64);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MangeMortEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MangeMortEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && entity instanceof EntityLivingBase) {
			EntityTippedArrow entityToSpawn = new EntityTippedArrow(world, (EntityLivingBase) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 1) * 2.0F, 0);
			entityToSpawn.setDamage(((float) 5) * 2.0F);
			entityToSpawn.setKnockbackStrength((int) 5);
			world.spawnEntity(entityToSpawn);
		}
		entity.setFire((int) 15);
	}
}
