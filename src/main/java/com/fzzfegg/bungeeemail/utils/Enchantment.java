package com.fzzfegg.bungeeemail.utils;

import com.fzzfegg.bungeeemail.BungeeEmail;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public class Enchantment extends org.bukkit.enchantments.Enchantment{

    static BungeeEmail plugin = BungeeEmail.instance;

    public Enchantment(NamespacedKey key) {
        super(key);
    }

    public static void register() {
        try {
            NamespacedKey namespacedKey = new NamespacedKey(plugin,"bcemail");
            Enchantment myen = new Enchantment(namespacedKey);
            Field field = org.bukkit.enchantments.Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null,true);
            org.bukkit.enchantments.Enchantment.registerEnchantment(myen);
        }catch (NoSuchFieldException | IllegalAccessException ignored){}
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(org.bukkit.enchantments.Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }

}
