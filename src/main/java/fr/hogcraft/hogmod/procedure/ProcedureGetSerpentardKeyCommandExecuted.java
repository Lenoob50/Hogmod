package fr.hogcraft.hogmod.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.hogcraft.hogmod.item.ItemSerpentardKey;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureGetSerpentardKeyCommandExecuted extends ElementsHogmodMod.ModElement {
	public ProcedureGetSerpentardKeyCommandExecuted(ElementsHogmodMod instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GetSerpentardKeyCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemSerpentardKey.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
