package net.momirealms.customcrops.listener;

import net.momirealms.customcrops.utils.JedisUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;

public class JoinAndQuit implements Listener {

    public static HashSet<String> onlinePlayers = new HashSet<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if (JedisUtil.useRedis) JedisUtil.addPlayer(event.getPlayer().getName());
        else onlinePlayers.add(event.getPlayer().getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if (JedisUtil.useRedis) JedisUtil.remPlayer(event.getPlayer().getName());
        else onlinePlayers.remove(event.getPlayer().getName());
    }
}