package pl.fyv.mc.challengebroadcaster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ChallengeBroadcaster extends JavaPlugin implements Listener {

    private static final String NAME = "ChallengeBroadcaster";

    @Override
    public void onEnable() {
        getLogger().info(NAME + ": onEnable is called");
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public  void onDisable() {
        getLogger().info(NAME+  ": onDisable is called");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("challengebroadcaster")) {
            sender.sendMessage("(c) fyv 2019");
            return true;
        }

        return false;
    }


}
