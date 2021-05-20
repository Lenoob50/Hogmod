
package fr.hogcraft.hogmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import fr.hogcraft.hogmod.creativetab.TabHogcraftItem;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class ItemHogGenerique extends ElementsHogmodMod.ModElement {
	@GameRegistry.ObjectHolder("hogmod:hog_generique")
	public static final Item block = null;
	public ItemHogGenerique(ElementsHogmodMod instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("hogmod:hog_generique", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("hog_generique", ElementsHogmodMod.sounds.get(new ResourceLocation("hogmod:hogmusique")));
			setUnlocalizedName("hog_generique");
			setRegistryName("hog_generique");
			setCreativeTab(TabHogcraftItem.tab);
		}
	}
}
