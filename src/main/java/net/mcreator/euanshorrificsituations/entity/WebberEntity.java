
package net.mcreator.euanshorrificsituations.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.euanshorrificsituations.procedures.WebberTryStealthProcedure;
import net.mcreator.euanshorrificsituations.procedures.WebberPlayerCollidesWithThisEntityProcedure;
import net.mcreator.euanshorrificsituations.init.EuansHorrificSituationsModEntities;

@Mod.EventBusSubscriber
public class WebberEntity extends Monster {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.MONSTER)
				.add(new MobSpawnSettings.SpawnerData(EuansHorrificSituationsModEntities.WEBBER.get(), 20, 1, 4));
	}

	public WebberEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EuansHorrificSituationsModEntities.WEBBER.get(), world);
	}

	public WebberEntity(EntityType<WebberEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
		this.goalSelector.addGoal(5, new RestrictSunGoal(this));
		this.goalSelector.addGoal(6, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = WebberEntity.this.getX();
				double y = WebberEntity.this.getY();
				double z = WebberEntity.this.getZ();
				Entity entity = WebberEntity.this;
				Level world = WebberEntity.this.level;
				return super.canUse() && WebberTryStealthProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = WebberEntity.this.getX();
				double y = WebberEntity.this.getY();
				double z = WebberEntity.this.getZ();
				Entity entity = WebberEntity.this;
				Level world = WebberEntity.this.level;
				return super.canContinueToUse() && WebberTryStealthProcedure.execute(world, x, y, z);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.STRING));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		WebberPlayerCollidesWithThisEntityProcedure.execute(source.getEntity());
		return super.hurt(source, amount);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		WebberPlayerCollidesWithThisEntityProcedure.execute(sourceentity);
	}

	public static void init() {
		SpawnPlacements.register(EuansHorrificSituationsModEntities.WEBBER.get(), SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
		DungeonHooks.addDungeonMob(EuansHorrificSituationsModEntities.WEBBER.get(), 180);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 2);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);
		return builder;
	}
}
