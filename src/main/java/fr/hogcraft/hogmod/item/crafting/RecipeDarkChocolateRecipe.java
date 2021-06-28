
package fr.hogcraft.hogmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import fr.hogcraft.hogmod.item.ItemDarkChocolate;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class RecipeDarkChocolateRecipe extends ElementsHogmodMod.ModElement {
	public RecipeDarkChocolateRecipe(ElementsHogmodMod instance) {
		super(instance, 50);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.DYE, (int) (1), 3), new ItemStack(ItemDarkChocolate.block, (int) (1)), 1F);
	}
}
