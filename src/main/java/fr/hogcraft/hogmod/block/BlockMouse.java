
package fr.hogcraft.hogmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.Block;

import fr.hogcraft.hogmod.creativetab.TabHogcraftItem;
import fr.hogcraft.hogmod.ElementsHogmodMod;

@ElementsHogmodMod.ModElement.Tag
public class BlockMouse extends ElementsHogmodMod.ModElement {
	@GameRegistry.ObjectHolder("hogmod:mouse")
	public static final Block block = null;
	public BlockMouse(ElementsHogmodMod instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("mouse"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("hogmod:mouse", "inventory"));
	}
	public static class BlockCustom extends BlockTrapDoor {
		public BlockCustom() {
			super(Material.CLOTH);
			setUnlocalizedName("mouse");
			setSoundType(SoundType.CLOTH);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabHogcraftItem.tab);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}
}
