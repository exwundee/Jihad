package com.exwundee;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Random;

public class Main extends JavaPlugin implements Listener {

    Random rand = new Random();

    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();
    ArrayList<String> c = new ArrayList<String>();


    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        System.out.println("§aJihad created by x1D enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4get out of here robot");
            return true;
        }
        if (command.getName().equalsIgnoreCase("jihad")) {
            if (a.contains(player.getName())) {
                player.sendMessage("§cYou have to wait before doing that again m8.");
                return true;
            } else {
                ItemStack jihad = new ItemStack(Material.TNT, 64);
                ItemMeta jihadM = jihad.getItemMeta();
                jihadM.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                jihadM.setDisplayName("§4Winst0n");
                jihadM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                jihad.setItemMeta(jihadM);

                ItemStack lighter = new ItemStack(Material.FLINT_AND_STEEL, 1);
                ItemMeta lighterM = lighter.getItemMeta();
                lighterM.addEnchant(Enchantment.DURABILITY, 3, true);
                lighterM.addEnchant(Enchantment.MENDING, 1, true);
                lighterM.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                lighterM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                lighter.setItemMeta(lighterM);

                player.getInventory().addItem(jihad);
                player.getInventory().addItem(lighter);
                player.sendMessage("§abtfo n' co supplies brought to you by John200410");
                player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_DEATH, 2, 1);

                a.add(player.getName());

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        a.remove(player.getName());
                    }
                }, 20L * 20);
            }
        }

        if (command.getName().equalsIgnoreCase("allah")) {
            if (b.contains(player.getName())) {
                player.sendMessage("§cYou have to wait before doing that again m8.");
                return true;
            } else {
                Location loc = player.getLocation();
                try {
                    if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) <= 10) {
                        explode(player, Integer.parseInt(args[0]), true, true);
                    } else {
                        player.sendMessage("§cArgument must be greater than 0, yet not above 10.");
                    }
                } catch (Exception e) {
                    explode(player, 2, true, true);
                }
                b.add(player.getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        b.remove(player.getName());
                    }
                }, 20L * 20);
            }
        }

        if (command.getName().equalsIgnoreCase("osama")) {
            if (c.contains(player.getName())) {
                player.sendMessage("§cYou have to wait before doing that again m8.");
                return true;
            } else {
                Location loc = player.getLocation();
                player.getWorld().spawnEntity(loc, EntityType.CREEPER);
                c.add(player.getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        c.remove(player.getName());
                    }
                }, 20L * 5);
            }
        }

        return false;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {
            int a = rand.nextInt(200);
            if (a == 69) event.getBlock().setType(Material.BEDROCK);

            Location l = event.getPlayer().getLocation();

            if (event.getPlayer().getWorld().getBlockAt((int) l.getX(), (int) l.getY() - 1, (int) l.getZ()).getType() == Material.BEDROCK) {
                event.getBlock().setType(Material.AIR);
                event.getPlayer().getWorld().spawnEntity(l, EntityType.PRIMED_TNT);
            }

        }

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            int a = rand.nextInt(100);
            if (a == 69) explode((Player) event.getEntity(), 1, true, true);
        }
    }


    /*

                            CUSTOM EVENTS

     */

    public void explode(Player player, int power, Boolean fire, Boolean damage) {
        Location l = player.getLocation();
        player.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), power, fire, damage);
    }

}
