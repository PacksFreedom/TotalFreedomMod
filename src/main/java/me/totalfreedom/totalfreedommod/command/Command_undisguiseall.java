package me.totalfreedom.totalfreedommod.command;

import me.libraryaddict.disguise.DisallowedDisguises;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Undisguise all players on the server", usage = "/<command>", aliases = "uall")
public class Command_undisguiseall extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final PluginManager pm = server.getPluginManager();
        
        Plugin LibsDisguises = null;
        
        if (server.getPluginManager().getPlugin("LibsDisguises") != null)
        {
            LibsDisguises = pm.getPlugin("LibsDisguises");
        }
        else
        {
            msg("LibsDisguises is not enabled on this this server");
            // return?
        }
        
        FUtil.adminAction(sender.getName(), "Undisguising all non-admins", true);
        
        plugin.ldb.undisguiseAll(false);

        return true;
    }
}
