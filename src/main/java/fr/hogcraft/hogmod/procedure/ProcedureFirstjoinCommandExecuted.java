package fr.hogcraft.hogmod.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.hogcraft.hogmod.item.ItemGlowTenGallions;
import fr.hogcraft.hogmod.item.ItemGlowOneGallions;
import fr.hogcraft.hogmod.item.ItemGlowFiftyGallion;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureFirstjoinCommandExecuted extends ElementsHogmodMod.ModElement {
	public ProcedureFirstjoinCommandExecuted(ElementsHogmodMod instance) {
		super(instance, 56);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirstjoinCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemGlowOneGallions.block, (int) (1));
			_setstack.setCount(100);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemGlowTenGallions.block, (int) (1));
			_setstack.setCount(50);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemGlowFiftyGallion.block, (int) (1));
			_setstack.setCount(10);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
