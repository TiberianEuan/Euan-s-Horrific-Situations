
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.euanshorrificsituations.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.euanshorrificsituations.item.SilkBindingItem;
import net.mcreator.euanshorrificsituations.EuansHorrificSituationsMod;

public class EuansHorrificSituationsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EuansHorrificSituationsMod.MODID);
	public static final RegistryObject<Item> SILK_BINDING_HELMET = REGISTRY.register("silk_binding_helmet", () -> new SilkBindingItem.Helmet());
	public static final RegistryObject<Item> SILK_BINDING_CHESTPLATE = REGISTRY.register("silk_binding_chestplate",
			() -> new SilkBindingItem.Chestplate());
	public static final RegistryObject<Item> SILK_BINDING_LEGGINGS = REGISTRY.register("silk_binding_leggings", () -> new SilkBindingItem.Leggings());
	public static final RegistryObject<Item> SILK_BINDING_BOOTS = REGISTRY.register("silk_binding_boots", () -> new SilkBindingItem.Boots());
	public static final RegistryObject<Item> WEBBER = REGISTRY.register("webber_spawn_egg",
			() -> new ForgeSpawnEggItem(EuansHorrificSituationsModEntities.WEBBER, -10066330, -1,
					new Item.Properties().tab(EuansHorrificSituationsModTabs.TAB_UNPLEASANT_MOBS)));
	public static final RegistryObject<Item> CARNIVOROUS_PLANT = block(EuansHorrificSituationsModBlocks.CARNIVOROUS_PLANT,
			EuansHorrificSituationsModTabs.TAB_UNPLEASANT_MOBS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
