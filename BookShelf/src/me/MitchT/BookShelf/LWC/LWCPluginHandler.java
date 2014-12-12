/**
 * @author Mitch Talmadge
 *         Date Created:
 *         Jul 25, 2013
 */

package me.MitchT.BookShelf.LWC;

import java.lang.reflect.Field;

import com.griefcraft.lwc.LWCPlugin;

/**
 * 
 * BookShelf - A Bukkit & Spigot mod allowing the placement of items
 * into BookShelves. <br>
 * Copyright (C) 2012-2014 Mitch Talmadge (mitcht@aptitekk.com)<br>
 * <br>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.<br>
 * <br>
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * <br>
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 * 
 * @author Mitch Talmadge (mitcht@aptitekk.com)
 */
public class LWCPluginHandler
{
    public LWCPluginHandler(LWCPlugin plugin)
    {
        try
        {
            Field lwc = plugin.getClass().getDeclaredField("lwc");
            LWCHandler LWCHandler = new LWCHandler(plugin);
            lwc.setAccessible(true);
            lwc.set(plugin, LWCHandler);
            LWCHandler.load();
        }
        catch(SecurityException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
    
}