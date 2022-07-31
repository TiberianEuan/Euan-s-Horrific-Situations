
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.euanshorrificsituations.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class EuansHorrificSituationsModTabs {
	public static CreativeModeTab TAB_UNPLEASANT_EQUIPMENT;
	public static CreativeModeTab TAB_UNPLEASANT_MOBS;

	public static void load() {
		TAB_UNPLEASANT_EQUIPMENT = new CreativeModeTab("tabunpleasant_equipment") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.IRON_HELMET);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_UNPLEASANT_MOBS = new CreativeModeTab("tabunpleasant_mobs") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.SPIDER_EYE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
