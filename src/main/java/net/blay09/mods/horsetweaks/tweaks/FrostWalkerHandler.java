package net.blay09.mods.horsetweaks.tweaks;

import net.blay09.mods.horsetweaks.HorseUpgrade;
import net.blay09.mods.horsetweaks.HorseUpgradeHelper;
import net.minecraft.enchantment.EnchantmentFrostWalker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FrostWalkerHandler {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Entity entity = event.player.getRidingEntity();
        if (event.phase == TickEvent.Phase.END && entity instanceof AbstractHorse && HorseUpgradeHelper.hasUpgrade((AbstractHorse) entity, HorseUpgrade.FROST_WALKER)) {
            EnchantmentFrostWalker.freezeNearby((AbstractHorse) entity, entity.world, entity.getPosition(), 1);

            if (entity.ticksExisted % 20 == 0 && entity.world.getBlockState(entity.getPosition().down()).getBlock() == Blocks.FROSTED_ICE) {
                HorseUpgradeHelper.damageSaddle((AbstractHorse) entity);
            }
        }
    }

}
