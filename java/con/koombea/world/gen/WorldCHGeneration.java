package con.koombea.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldCHGeneration extends WorldGenerator  implements IWorldGenerator{

	protected Block[] getValidSpawnBlocks() {
		return new Block[] {
				Blocks.grass,
				Blocks.dirt,
				Blocks.cobblestone,
				Blocks.planks,
				Blocks.sapling,
				Blocks.stone
		};
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);

		while (check != Blocks.air){	
			if (distanceToAir > 3){
 
				return false;
			}

			distanceToAir++;
			check = world.getBlock(i, j + distanceToAir, k);
		}

		j += distanceToAir - 1;

		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j+1, k);
		Block blockBelow = world.getBlock(i, j-1, k);
		
		for (Block x : getValidSpawnBlocks()){
			if (blockAbove != Blocks.air){
				
				return false;
			}
			if (block == x){
				return true;
			}else if (block == Blocks.snow && blockBelow == x){
				return true;
			}
		}
		
		return false;
	}

	public WorldCHGeneration() { }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
        switch(world.provider.dimensionId){
        case -1:
//            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
        	
        	generate(world, random, chunkX * 16, random.nextInt(64), chunkZ * 16);
            break;
        case 1:
//            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		Block b1 = world.getBlock(x, y, z);

		if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
		{
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
 
		
		if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 6, j, k) || !locationIsValidSpawn(world, i + 6, j, k + 0) || !locationIsValidSpawn(world, i, j, k + 0))
		{
			return false;
		}


		k = k - 10;
		i = i - 10;
		System.out.println("GENERO UNO EN X"+ i +"Y" + j +"Z"+k);
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 0, j + 2, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 0, j + 3, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 0, j + 4, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 1, j + 4, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 2, j + 4, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 4, j + 1, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 4, j + 2, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 4, j + 3, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 4, j + 4, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 5, j + 2, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 6, j + 0, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 6, j + 1, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 6, j + 2, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 6, j + 3, k + 0, Blocks.dirt, 0);
		this.setBlock(world, i + 6, j + 4, k + 0, Blocks.dirt, 0);

		return true;
	}

 


}
