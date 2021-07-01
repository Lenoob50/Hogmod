package fr.hogcraft.hogmod.procedure;

import net.minecraft.item.ItemStack;

import java.util.Random;
import java.util.Map;

import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ProcedureWandClickedBox extends ElementsHogmodMod.ModElement {
	public ProcedureWandClickedBox(ElementsHogmodMod instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure WandClickedBox!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double Random = 0;
		double R2 = 0;
		Random = (double) Math.random();
		if (((Random) > 0.5)) {
			R2 = (double) Math.random();
			if (((R2) > 0.5)) {
				((itemstack)).setStackDisplayName("\u00A73Baguette de Feu");
			} else if (((R2) <= 0.5)) {
				((itemstack)).setStackDisplayName("\u00A73Baguette des airs");
			}
		} else if (((Random) <= 0.5)) {
			R2 = (double) Math.random();
			if (((R2) > 0.5)) {
				((itemstack)).setStackDisplayName("\u00A73Baguette d'eau");
			} else if (((R2) <= 0.5)) {
				((itemstack)).setStackDisplayName("\u00A73Baguette de terre");
			}
		}
	}
}
