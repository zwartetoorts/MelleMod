package nl.vanhetland;

import java.util.Random;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MelleBlock extends Block{

	public MelleBlock() {
		super(Material.ground);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
}
