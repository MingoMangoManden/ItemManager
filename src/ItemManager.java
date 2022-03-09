import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class ItemManager {
    public static ItemStack createItem(@NotNull String name, @NotNull Material type,
                                 @NotNull ChatColor color, @NotNull List<String> lore,
                                 @NotNull HashMap<Enchantment, @NotNull Integer> enchants) {
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();

        String displayName = "";
        if (color != null) {
            displayName += color;
        }
        displayName += name;
        meta.setDisplayName(displayName);
        meta.setLore(lore);

        for (Enchantment ench : enchants.keySet()) {
            meta.addEnchant(ench, enchants.get(ench), true); // im just so cool and smart
        }

        item.setItemMeta(meta);
        return item;
    }
}
