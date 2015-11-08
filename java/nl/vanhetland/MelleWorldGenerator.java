package nl.vanhetland;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable; 
import net.minecraftforge.fml.common.IWorldGenerator;


public class MelleWorldGenerator implements IWorldGenerator{
	
	private int count = 0;
	
	private void addBlock(int x, int z, World world, Block block, Random random) {
		int y;
		
		// Find first air at Y
		for(y = 0; y < 255; y++) {
			Block upperBlock = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			if(upperBlock == Blocks.air)
				break;
		}
		world.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
	}
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimensionId()) {
		case 0:
			if (count % 4 == 0) {
				addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.pietBlock, random);
				if (count % 8 == 0) { 
					addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.sintBlock, random);
					if (count % 16 == 0) 
						addBlock(chunkX*16 + random.nextInt(16), chunkZ*16 + random.nextInt(16), world, MelleMod.kadoBlock, random);
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
