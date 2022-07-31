
package net.mcreator.euanshorrificsituations.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.euanshorrificsituations.procedures.WebberTransparentWhenTrueProcedure;
import net.mcreator.euanshorrificsituations.entity.WebberEntity;
import net.mcreator.euanshorrificsituations.client.model.Modelcustom_model;

public class WebberRenderer extends MobRenderer<WebberEntity, Modelcustom_model<WebberEntity>> {
	public WebberRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WebberEntity entity) {
		return new ResourceLocation("euans_horrific_situations:textures/webbah.png");
	}

	@Override
	protected boolean isBodyVisible(WebberEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return !WebberTransparentWhenTrueProcedure.execute(entity);
	}
}
