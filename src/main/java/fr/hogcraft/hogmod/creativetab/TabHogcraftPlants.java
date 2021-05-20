
package fr.hogcraft.hogmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import fr.hogcraft.hogmod.item.ItemLogoCreativeTab;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class TabHogcraftPlants extends ElementsHogmodMod.ModElement {
	public TabHogcraftPlants(ElementsHogmodMod instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabhogcraft_plants") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemLogoCreativeTab.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
