package nl.vanhetland;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.biome.BiomeGenBase;


public class MelleWorldGenerator implements IWorldGenerator{
	
	private int count = 0;
	
	private void addBlock(int x, int z, World world, Block block) {
		int y;
		
		// Find first air at Y
		for(y = 0; y < 255; y++) {
			Block upperBlock = world.getBlock(x,  y,  z);
			if(upperBlock == Blocks.air)
				break;
		}
		world.setBlock(x, y, z, block);
	}
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId) {
		case 0:
			if (count % 4 == 0) {
				addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.pietBlock);
				if (count % 8 == 0) { 
					addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.sintBlock);
					if (count % 16 == 0) 
						addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.kadoBlock);
				}
			}
			count++;
			break;
		case -1:
		case 1:
			break;
		}
		
		
    }

}
