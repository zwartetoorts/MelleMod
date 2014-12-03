package nl.vanhetland;

import java.util.Random;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class KadoBlock extends Block{

	public KadoBlock() {
		super(Material.iron);
	}
	
	@Override
	public String getHarvestTool(int metadata) {
		return "stafTool";
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return MelleMod.melleItem;
	}
}
