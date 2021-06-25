package fr.hogcraft.hogmod.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.hogcraft.hogmod.item.ItemGryffondorKey;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureGetgemCommandExecuted extends ElementsHogmodMod.ModElement {
	public ProcedureGetgemCommandExecuted(ElementsHogmodMod instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GetgemCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemGryffondorKey.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
