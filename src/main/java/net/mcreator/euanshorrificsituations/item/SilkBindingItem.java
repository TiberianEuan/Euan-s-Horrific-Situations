
package net.mcreator.euanshorrificsituations.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.euanshorrificsituations.procedures.SilkBindingLeggingsTickEventProcedure;
import net.mcreator.euanshorrificsituations.procedures.SilkBindingHelmetBlindnessEventProcedure;
import net.mcreator.euanshorrificsituations.procedures.SilkBindingBodyTickEventProcedure;
import net.mcreator.euanshorrificsituations.init.EuansHorrificSituationsModTabs;

import java.util.List;

public abstract class SilkBindingItem extends ArmorItem {
	public SilkBindingItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{0, 0, 0, 0}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.break"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.STRING), new ItemStack(Blocks.COBWEB), new ItemStack(Blocks.WHITE_WOOL));
			}

			@Override
			public String getName() {
				return "silk_binding";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends SilkBindingItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(EuansHorrificSituationsModTabs.TAB_UNPLEASANT_EQUIPMENT));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("Prevents you from seeing and taking off armor."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "euans_horrific_situations:textures/models/armor/silkbinds__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			SilkBindingHelmetBlindnessEventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends SilkBindingItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(EuansHorrificSituationsModTabs.TAB_UNPLEASANT_EQUIPMENT));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("Prevents you from attacking"));
			list.add(new TextComponent("mining and taking off armor."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "euans_horrific_situations:textures/models/armor/silkbinds__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			SilkBindingBodyTickEventProcedure.execute(entity);
		}
	}

	public static class Leggings extends SilkBindingItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(EuansHorrificSituationsModTabs.TAB_UNPLEASANT_EQUIPMENT));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("Prevents you from walking."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "euans_horrific_situations:textures/models/armor/silkbinds__layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			SilkBindingLeggingsTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends SilkBindingItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(EuansHorrificSituationsModTabs.TAB_UNPLEASANT_EQUIPMENT));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("Prevents you from walking."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "euans_horrific_situations:textures/models/armor/silkbinds__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			SilkBindingLeggingsTickEventProcedure.execute(entity);
		}
	}
}
