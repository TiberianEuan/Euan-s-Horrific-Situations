
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.euanshorrificsituations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.euanshorrificsituations.block.CarnivorousPlantBlock;
import net.mcreator.euanshorrificsituations.EuansHorrificSituationsMod;

public class EuansHorrificSituationsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EuansHorrificSituationsMod.MODID);
	public static final RegistryObject<Block> CARNIVOROUS_PLANT = REGISTRY.register("carnivorous_plant", () -> new CarnivorousPlantBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			CarnivorousPlantBlock.registerRenderLayer();
		}
	}
}
