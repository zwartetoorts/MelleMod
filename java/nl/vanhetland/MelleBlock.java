package nl.vanhetland;

import java.util.Random;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MelleBlock extends Block{
	private String blockName;
	
	public MelleBlock(String name) {
		super(new Material(MapColor.blackColor));
		blockName = name;
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	public String getName() {
		return blockName;
	}
}
