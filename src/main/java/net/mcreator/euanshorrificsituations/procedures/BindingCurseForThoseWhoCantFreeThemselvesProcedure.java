package net.mcreator.euanshorrificsituations.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.euanshorrificsituations.init.EuansHorrificSituationsModItems;

import java.util.Map;

public class BindingCurseForThoseWhoCantFreeThemselvesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.getItem() == EuansHorrificSituationsModItems.SILK_BINDING_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == EuansHorrificSituationsModItems.SILK_BINDING_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == EuansHorrificSituationsModItems.SILK_BINDING_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
						.getItem() == EuansHorrificSituationsModItems.SILK_BINDING_HELMET.get()) {
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))
					.enchant(Enchantments.BINDING_CURSE, 10);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))
					.enchant(Enchantments.BINDING_CURSE, 10);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY))
					.enchant(Enchantments.BINDING_CURSE, 10);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))
					.enchant(Enchantments.BINDING_CURSE, 10);
		} else {
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
				if (_enchantments.containsKey(Enchantments.BINDING_CURSE)) {
					_enchantments.remove(Enchantments.BINDING_CURSE);
					EnchantmentHelper.setEnchantments(_enchantments,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
				}
			}
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
				if (_enchantments.containsKey(Enchantments.BINDING_CURSE)) {
					_enchantments.remove(Enchantments.BINDING_CURSE);
					EnchantmentHelper.setEnchantments(_enchantments,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
				}
			}
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
				if (_enchantments.containsKey(Enchantments.BINDING_CURSE)) {
					_enchantments.remove(Enchantments.BINDING_CURSE);
					EnchantmentHelper.setEnchantments(_enchantments,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
				}
			}
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
				if (_enchantments.containsKey(Enchantments.BINDING_CURSE)) {
					_enchantments.remove(Enchantments.BINDING_CURSE);
					EnchantmentHelper.setEnchantments(_enchantments,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
				}
			}
		}
	}
}
