package com.exwundee;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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

        getConfig().addDefault("delay", 120);
        getConfig().addDefault("world", "world");
        getConfig().options().copyDefaults(true);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                int d = rand.nextInt(8);
                try {
                    ItemStack[] is = {new ItemStack(Material.END_CRYSTAL, 1), new ItemStack(Material.DIAMOND_SWORD, 1),
                            new ItemStack(Material.DIAMOND_PICKAXE, 1), new ItemStack(Material.BEDROCK, 1),
                            new ItemStack(Material.TNT, 1), new ItemStack(Material.OBSIDIAN, 1),
                            new ItemStack(Material.BEACON, 1),
                            new ItemStack(Material.TOTEM, 1), new ItemStack(Material.ENDER_PORTAL_FRAME, 1),
                            new ItemStack(Material.EYE_OF_ENDER, 1)};

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        ItemStack ni = is[d];
                        ItemMeta im = ni.getItemMeta();
                        if (ni.getType() == Material.DIAMOND_SWORD) {
                            im.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
                            im.addEnchant(Enchantment.KNOCKBACK, 10, true);
                            im.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
                            im.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
                            im.addEnchant(Enchantment.DURABILITY, 32767, true);
                            im.addEnchant(Enchantment.MENDING, 1, true);
                            im.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                            ni.setItemMeta(im);
                        }
                        if (ni.getType() == Material.DIAMOND_PICKAXE) {
                            im.addEnchant(Enchantment.DIG_SPEED, 32767, true);
                            im.addEnchant(Enchantment.SILK_TOUCH, 10, true);
                            im.addEnchant(Enchantment.DURABILITY, 32767, true);
                            im.addEnchant(Enchantment.MENDING, 1, true);
                            im.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                            ni.setItemMeta(im);
                        }
                        p.getInventory().addItem(is[d]);
                    }
                    int e = rand.nextInt(8);
                    ItemStack ni = is[e];
                    ItemMeta im = ni.getItemMeta();
                    if (ni.getType() == Material.DIAMOND_SWORD) {
                        im.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
                        im.addEnchant(Enchantment.KNOCKBACK, 10, true);
                        im.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
                        im.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
                        im.addEnchant(Enchantment.DURABILITY, 32767, true);
                        im.addEnchant(Enchantment.MENDING, 1, true);
                        im.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                        ni.setItemMeta(im);
                    }
                    if (ni.getType() == Material.DIAMOND_PICKAXE) {
                        im.addEnchant(Enchantment.DIG_SPEED, 32767, true);
                        im.addEnchant(Enchantment.SILK_TOUCH, 10, true);
                        im.addEnchant(Enchantment.DURABILITY, 32767, true);
                        im.addEnchant(Enchantment.MENDING, 1, true);
                        im.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
                        ni.setItemMeta(im);
                    }
                    int a = rand.nextInt(200);
                    if (a > 69) {
                        a = a - (a*2);
                    }
                    Bukkit.getWorld(getConfig().getString("world")).dropItemNaturally(new Location(Bukkit.getWorld(getConfig().getString("world")), a + 722,
                            Bukkit.getWorld(getConfig().getString("world")).getHighestBlockYAt(a + 722, a +1124) + 1, a + 1124), is[e]);
                } catch (Exception e) {

                }
            }
        }, 1L, 120*20);

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
    public void onChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage().replaceAll("(?i)fuck", "flubbernugget")
                .replaceAll("(?i)shit", "shart")
                .replaceAll("(?i)nigger", "John200410")
                .replaceAll("(?i)ass", "#*@()!")
                .replaceAll("(?i)hell", "4b4t")
                .replaceAll("(?i)bitch", "lAsAgnA")
                .replaceAll("(?i)cunt", "kitty kat")
                .replaceAll("(?i)damn", "DANIEL")
                .replaceAll("(?i)nigga", "John2OO41O")
                .replaceAll("(?i)prick", "x1D")
                .replaceAll("(?i)twat", "britfag")
                .replaceAll("(?i)hitler", "jew")
                .replaceAll("(?i)hause", "h00semustard")
                .replaceAll("(?i)2b2t", "bad server")
                .replaceAll("(?i)rusherhack", "§c§lrusherhack§r")
                .replaceAll("(?i)minecraft", " ")
                .replaceAll("(?i)no u", "yes me")
                .replaceAll("(?i)6b9t", "ABSOLUTE GARBAGE")
                .replaceAll("(?i)discord", "b&")
                .replaceAll("(?i)future", "shit")
                .replaceAll("(?i)x1D", "§6§l§oKING§r")
                .replaceAll("(?i)tristan", "john's baby")
                .replaceAll("(?i)popbob", "fat cunt")
                .replaceFirst("(?i)fit", "fucking pedophile named Peter Larsen who lives at 581 Elk Cir Marco Island, FL 34145. he scams little kids for money");

        event.setMessage(msg + " §2>>> §c§lbuy rusherhack");



    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {
            int a = rand.nextInt(200);
            if (a == 69) event.getBlock().setType(Material.BEDROCK);

            Location l = event.getBlock().getLocation();

            if (event.getPlayer().getWorld().getBlockAt((int) l.getX(), (int) l.getY() - 1, (int) l.getZ()).getType() == Material.BEDROCK ||
                    event.getPlayer().getWorld().getBlockAt((int) l.getX(), (int) l.getY() - 1, (int) l.getZ()).getType() == Material.OBSIDIAN) {
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
