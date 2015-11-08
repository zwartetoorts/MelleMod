package nl.vanhetland;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MelleItem extends ItemPickaxe {
	private String itemName;
	
	public MelleItem(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		itemName = name;
		GameRegistry.registerItem(this, name);
	}

	public String getName() {
		return itemName;
	}
}
