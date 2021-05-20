
package fr.hogcraft.hogmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import fr.hogcraft.hogmod.item.ItemPotionOfGellyweed;
import fr.hogcraft.hogmod.block.BlockGellyWeedPlants;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class RecipeRecipePotions extends ElementsHogmodMod.ModElement {
	public RecipeRecipePotions(ElementsHogmodMod instance) {
		super(instance, 16);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGellyWeedPlants.block, (int) (1)), new ItemStack(ItemPotionOfGellyweed.block, (int) (1)), 1F);
	}
}
