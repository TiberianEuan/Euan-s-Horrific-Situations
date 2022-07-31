package net.mcreator.euanshorrificsituations.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.euanshorrificsituations.init.EuansHorrificSituationsModItems;

public class WebberPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem()) {
			{
				Entity _entity = sourceentity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_BOOTS.get()));
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem()) {
			{
				Entity _entity = sourceentity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_LEGGINGS.get()));
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem()) {
			{
				Entity _entity = sourceentity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_CHESTPLATE.get()));
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem()) {
			{
				Entity _entity = sourceentity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EuansHorrificSituationsModItems.SILK_BINDING_HELMET.get()));
				}
			}
		}
	}
}
