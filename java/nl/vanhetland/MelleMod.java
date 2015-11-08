package nl.vanhetland;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
// used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
//import cpw.mods.fml.common.Mod.Init;
//1.6.X
//import cpw.mods.fml.common.Mod.PostInit;
//import cpw.mods.fml.common.Mod.PreInit;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid="MelleMod", name="MelleMod", version="1.0.0")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class MelleMod {

        // The instance of your mod that Forge uses.
        @Instance(value = "MelleMod")
        public static MelleMod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="nl.vanhetland.client.ClientProxy", serverSide="nl.vanhetland.CommonProxy")
        public static CommonProxy proxy;
        
        public static MelleWorldGenerator melleWorldGenerator = new MelleWorldGenerator();
        
        public static Block pietBlock = new MelleBlock("pietBlock");
        public static Block sintBlock= new MelleBlock("sintBlock");
        public static Block kadoBlock = new KadoBlock("kadoBlock");
        
        public static ToolMaterial toolMaterial = EnumHelper.addToolMaterial("stafTool", 4, 1000, 15.0F, 4.0F, 30);
        public static Item stafItem = new MelleItem("stafItem", toolMaterial);
        public static Item melleItem = new MelleItem("melleItem", toolMaterial);
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void init(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                GameRegistry.registerWorldGenerator(melleWorldGenerator, 0);
                            
                pietBlock.setHardness(0.5F).setUnlocalizedName("pietBlock").setCreativeTab(CreativeTabs.tabBlock);
                sintBlock.setHardness(0.5F).setUnlocalizedName("sintBlock").setCreativeTab(CreativeTabs.tabBlock);
                kadoBlock.setHardness(80.0F).setUnlocalizedName("kadoBlock").setCreativeTab(CreativeTabs.tabBlock);

                stafItem.setMaxStackSize(1).setUnlocalizedName("stafItem").setCreativeTab(CreativeTabs.tabMisc);
                melleItem.setMaxStackSize(64).setUnlocalizedName("melleItem").setCreativeTab(CreativeTabs.tabMisc);
                
                if(event.getSide() == Side.CLIENT)
                {
                    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
                    
                    	// Blocks
                    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(pietBlock), 0, new ModelResourceLocation("mellemod:pietBlock", "inventory"));
                    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(sintBlock), 0, new ModelResourceLocation("mellemod:sintBlock", "inventory"));
                    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(kadoBlock), 0, new ModelResourceLocation("mellemod:kadoBlock", "inventory"));
                    	
                    	// Items
                    	renderItem.getItemModelMesher().register(stafItem, 0, new ModelResourceLocation("mellemod:stafItem", "inventory"));
                    	renderItem.getItemModelMesher().register(melleItem, 0, new ModelResourceLocation("mellemod:melleItem", "inventory"));
                }
                
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