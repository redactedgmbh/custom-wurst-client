/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.commands;

import net.wurstclient.altmanager.Alt;
import net.wurstclient.altmanager.AltManager;
import net.wurstclient.command.CmdException;
import net.wurstclient.command.CmdSyntaxError;
import net.wurstclient.command.Command;
import net.wurstclient.util.ChatUtils;

public final class ListAltsCmd extends Command
{
	public ListAltsCmd()
	{
		super("listalts", "Lists all players in your alt list.", ".listalts");
	}
	
	@Override
	public void call(String[] args) throws CmdException
	{
		if(args.length != 0)
			throw new CmdSyntaxError();
		
		AltManager altManager = WURST.getAltManager();
		if(altManager.getList().isEmpty())
		{
			ChatUtils.message("Your alt list is empty.");
			return;
		}
		
		ChatUtils.message("Alts in your list:");
		for(Alt alt : altManager.getList())
		{
			String accountType;
			if(alt.isCracked())
			{
				accountType = "Cracked";
			}else if(alt.isCheckedPremium())
			{
				accountType = "Microsoft (Checked)";
			}else if(alt.isUncheckedPremium())
			{
				accountType = "Microsoft (Unchecked)";
			}else
			{
				accountType = "Unknown";
			}
			
			ChatUtils.message(alt.getName() + " (" + accountType + ")");
		}
	}
}
