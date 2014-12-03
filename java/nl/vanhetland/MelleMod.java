package nl.vanhetland;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;  //1.6.X
//import cpw.mods.fml.common.Mod.PostInit;
//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="MelleModID", name="MelleMod", version="1.0.0")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class MelleMod {

        // The instance of your mod that Forge uses.
        @Instance(value = "MelleModID")
        public static MelleMod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="nl.vanhetland.client.ClientProxy", serverSide="nl.vanhetland.CommonProxy")
        public static CommonProxy proxy;
        
        public static MelleWorldGenerator melleWorldGenerator = new MelleWorldGenerator();
        
        public static Block pietBlock = new MelleBlock();
        public static Block sintBlock= new MelleBlock();
        public static Block kadoBlock = new KadoBlock();
        
        public static ToolMaterial toolMaterial = EnumHelper.addToolMaterial("stafTool", 4, 1000, 15.0F, 4.0F, 30);
        public static Item stafItem = new MelleItem(toolMaterial);
        public static Item melleItem = new MelleItem(toolMaterial);
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                GameRegistry.registerWorldGenerator(melleWorldGenerator, 0);
                            
                pietBlock.setHardness(0.5F).setBlockName("pietBlock").setCreativeTab(CreativeTabs.tabBlock);
                pietBlock.setBlockTextureName("mellemod:pietBlock");
                GameRegistry.registerBlock(pietBlock, "pietBlock");
                
                sintBlock.setHardness(0.5F).setBlockName("sintBlock").setCreativeTab(CreativeTabs.tabBlock);
                sintBlock.setBlockTextureName("mellemod:sintBlock");
                GameRegistry.registerBlock(sintBlock, "sintBlock");
                
                kadoBlock.setHardness(80.0F).setBlockName("kadoBlock").setCreativeTab(CreativeTabs.tabBlock);
                kadoBlock.setBlockTextureName("mellemod:kadoBlock");
                GameRegistry.registerBlock(kadoBlock, "kadoBlock");
                
                stafItem.setMaxStackSize(1).setUnlocalizedName("stafItem").setCreativeTab(CreativeTabs.tabMisc);
                stafItem.setTextureName("mellemod:stafItem");
                GameRegistry.registerItem(stafItem, "stafItem");
                
                melleItem.setMaxStackSize(64).setUnlocalizedName("melleItem").setCreativeTab(CreativeTabs.tabMisc);
                melleItem.setTextureName("melleMod:melleItem");
                GameRegistry.registerItem(melleItem, "melleItem");
                
                ItemStack pietStack = new ItemStack(pietBlock);
                ItemStack sintStack = new ItemStack(sintBlock);
                
                GameRegistry.addRecipe(new ItemStack(this.stafItem), 
                		new Object[] {
                			"xxx",
                			"xyx",
                			"xxx",
                			'x', pietStack,
                			'y', sintStack });
                
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}