
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.euanshorrificsituations.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.decoration.Motive;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EuansHorrificSituationsModPaintings {
	@SubscribeEvent
	public static void registerMotives(RegistryEvent.Register<Motive> event) {
		event.getRegistry().register(new Motive(64, 16).setRegistryName("peculiar_painting"));
	}
}
