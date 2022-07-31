package net.mcreator.euanshorrificsituations.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.euanshorrificsituations.entity.WebberEntity;

public class WebberTryStealthProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(WebberEntity.class, AABB.ofSize(new Vec3(x, y, z), 26, 26, 26), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
