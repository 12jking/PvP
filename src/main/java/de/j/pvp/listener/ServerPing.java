package de.j.pvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {

    @EventHandler
    public void onServerPing(ServerListPingEvent event){
            event.setMotd("§2P§av§2P §l§6by LuckyProgrammer");
    }
}
