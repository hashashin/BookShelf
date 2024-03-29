package me.MitchT.BookShelf.Shelves;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

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
public class ItemGenerator
{
    
    public static ItemStack generateWrittenBook(String author, String title,
            String lore, String[] pages, int damage)
    {
        ItemStack written_book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta new_written_book = (BookMeta) written_book.getItemMeta();
        
        new_written_book.setAuthor(author);
        new_written_book.setTitle(title);
        new_written_book.setDisplayName(title);
        if(lore != null && !lore.equals(""))
            new_written_book.setLore(Arrays.asList(lore));
        if(pages != null)
        {
            for(int i = 0; i < pages.length; i++)
            {
                new_written_book.addPage(pages[i]);
            }
        }
        else
        {
            new_written_book.addPage("");
        }
        written_book.setItemMeta(new_written_book);
        written_book.setDurability((short) damage);
        return written_book;
    }
    
    public static ItemStack generateBookAndQuill(String author, String title,
            String lore, String[] pages, int damage)
    {
        ItemStack baq = new ItemStack(Material.WRITABLE_BOOK);
        BookMeta newbaq = (BookMeta) baq.getItemMeta();
        
        newbaq.setAuthor(author);
        newbaq.setTitle(title);
        if(lore != null && !lore.equals(""))
            newbaq.setLore(Arrays.asList(lore));
        if(!title.equals("null"))
        {
            newbaq.setDisplayName(title);
        }
        if(pages != null)
        {
            for(int i = 0; i < pages.length; i++)
            {
                newbaq.addPage(pages[i]);
            }
        }
        else
        {
            newbaq.addPage("");
        }
        
        baq.setItemMeta(newbaq);
        baq.setDurability((short) damage);
        return baq;
    }
    
    public static ItemStack generateEnchantedBook(Enchantment enchantment,
            int level)
    {
        ItemStack enchanted_book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta new_enchanted_book = (EnchantmentStorageMeta) enchanted_book
                .getItemMeta();
        
        new_enchanted_book.addStoredEnchant(enchantment, level, false);
        enchanted_book.setItemMeta(new_enchanted_book);
        return enchanted_book;
    }
    
    public static ItemStack generateMap(short durability)
    {
        ItemStack map = new ItemStack(Material.MAP);
        
        map.setDurability(durability);
        return map;
    }
    
}
