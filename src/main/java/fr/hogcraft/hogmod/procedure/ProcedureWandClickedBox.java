package fr.hogcraft.hogmod.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import fr.hogcraft.hogmod.item.ItemWaterWand;
import fr.hogcraft.hogmod.item.ItemWandBox;
import fr.hogcraft.hogmod.item.ItemFireWand;
import fr.hogcraft.hogmod.item.ItemEarthWand;
import fr.hogcraft.hogmod.item.ItemAirWand;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureWandClickedBox extends ElementsHogmodMod.ModElement {
	public ProcedureWandClickedBox(ElementsHogmodMod instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WandClickedBox!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Random = 0;
		double R2 = 0;
		Random = (double) Math.random();
		if (((Random) > 0.5)) {
			R2 = (double) Math.random();
			if (((R2) > 0.5)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemWandBox.block, (int) (1)).getItem(), -1, (int) 1, null);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemFireWand.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else if (((R2) <= 0.5)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemWandBox.block, (int) (1)).getItem(), -1, (int) 1, null);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemWaterWand.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
		} else if (((Random) <= 0.5)) {
			R2 = (double) Math.random();
			if (((R2) > 0.5)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemWandBox.block, (int) (1)).getItem(), -1, (int) 1, null);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAirWand.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else if (((R2) <= 0.5)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemWandBox.block, (int) (1)).getItem(), -1, (int) 1, null);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemEarthWand.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
		}
	}
}
