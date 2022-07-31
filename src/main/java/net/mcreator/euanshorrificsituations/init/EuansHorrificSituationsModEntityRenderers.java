
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.euanshorrificsituations.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.euanshorrificsituations.client.renderer.WebberRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EuansHorrificSituationsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EuansHorrificSituationsModEntities.WEBBER.get(), WebberRenderer::new);
	}
}
