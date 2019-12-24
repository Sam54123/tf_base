package org.scaffoldeditor.tf.weapons;

import org.bukkit.Effect;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;

public class TestWeapon extends RaycastWeapon {

    public TestWeapon(ItemStack item) {
        super(item);
    }

    
    
    @Override
    public boolean canFire() {
        return true;
    }



    @Override
    protected double getMaxFireDistance() {
        return 50;
    }

    @Override
    protected double getRandomSpread() {
        return 2;
    }

    @Override
    protected void onHitEntity(Entity entity, Player player, RayTraceResult rayTraceResult) {
        entity.getWorld().playEffect(rayTraceResult.getHitPosition().toLocation(entity.getWorld()), Effect.SMOKE, 31);
        entity.getWorld().createExplosion(entity.getLocation(), 4F);
    }



    @Override
    protected void onHitBlock(Block block, Player player, RayTraceResult rayTraceResult) {
        block.getWorld().playEffect(rayTraceResult.getHitPosition().toLocation(block.getWorld()), Effect.SMOKE, 31);
    }

}
