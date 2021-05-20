package fr.hogcraft.hogmod.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureCommandDeTestDuModCommandExecuted extends ElementsHogmodMod.ModElement {
	public ProcedureCommandDeTestDuModCommandExecuted(ElementsHogmodMod instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CommandDeTestDuModCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("\u00A76[Hogmod]:\u00A73Le Hogmod est bien fonctionel"), (true));
		}
	}
}
