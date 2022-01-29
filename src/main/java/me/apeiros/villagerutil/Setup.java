package me.apeiros.villagerutil;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import me.apeiros.villagerutil.commands.ResetVillagerCommand;
import me.apeiros.villagerutil.items.TransportCharm;
import me.apeiros.villagerutil.items.wands.CureWand;
import me.apeiros.villagerutil.items.wands.NitwitWand;
import me.apeiros.villagerutil.items.wands.TradeWand;
import me.apeiros.villagerutil.items.wands.TransportWand;
import me.apeiros.villagerutil.util.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class Setup {

    // Skull texture for Villager Transport Charm
    public static final String VILLAGER = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNhOGVmMjQ1OGEyYjEwMjYwYjg3NTY1NThmNzY3OWJjYjdlZjY5MWQ0MWY1MzRlZmVhMmJhNzUxMDczMTVjYyJ9fX0=";

    // Item constants
    public static final SlimefunItemStack ESSENCE = new SlimefunItemStack(
        "VU_ESSENCE",
        Material.GLOWSTONE_DUST,
        "&d村民精华",
        "&7稀有且神秘的粉尘",
        "&7是合成村民令牌的重要部分",
        "",
        "&e合成材料"
    );

    public static final SlimefunItemStack TOKEN = new SlimefunItemStack(
        "VU_TOKEN",
        Material.EMERALD,
        "&b村民令牌",
        "&7使用各种村民工具",
        "&7都需要消耗该令牌",
        "",
        "&a消耗品"
    );

    public static final SlimefunItemStack TRANSPORT_CHARM = new SlimefunItemStack(
        "VU_TRANSPORT_CHARM",
        VILLAGER,
        "&a&l村民信标",
        "&7一个魔法信标，可以将连接的村民",
        "&7传动到当前位置",
        "&e右键点击&7进行传送",
        "",
        "&7未连接村民",
        "",
        "&b工具"
    );

    public static final SlimefunItemStack TRANSPORT_WAND = new SlimefunItemStack(
        "VU_TRANSPORT_WAND",
        Material.BLAZE_ROD,
        "&c村民传送棒",
        "&e右键点击&7一名村民",
        "&7获取一个与该村民连接的村民信标",
        "",
        "&b工具"
    );

    public static final SlimefunItemStack TRADE_WAND = new SlimefunItemStack(
        "VU_TRADE_WAND",
        Material.BLAZE_ROD,
        "&6村民交易棒",
        "&e右键点击&7一名村民",
        "&7更换村民的交易",
        "",
        "&b工具"
    );

    public static final SlimefunItemStack CURE_WAND = new SlimefunItemStack(
        "VU_CURE_WAND",
        Material.BLAZE_ROD,
        "&a村民治愈棒",
        "&e右键点击&7一名僵尸村民",
        "&7使其恢复成为村民",
        "",
        "&b工具"
    );

    public static final SlimefunItemStack NITWIT_WAND = new SlimefunItemStack(
        "VU_NITWIT_WAND",
        Material.BLAZE_ROD,
        "&5村民去盲棒",
        "&e右键点击&7一名傻子村民",
        "&7使其成为正常村民",
        "",
        "&b工具"
    );

    // Setup methods
    public static void setup(VillagerUtil p) {
        // Setup category and researches
        ItemGroup ig = new ItemGroup(Utils.key("villager_util"), new CustomItemStack(Material.EMERALD_BLOCK, "&a村民工具"));
        ig.register(p);

        // Setup /resetvillager command
        new ResetVillagerCommand(p);

        // Setup items
        new SlimefunItem(ig, ESSENCE, RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.GLASS_PANE), SlimefunItems.ENDER_LUMP_2,
            new ItemStack(Material.EMERALD), SlimefunItems.VILLAGER_RUNE, SlimefunItems.FILLED_FLASK_OF_KNOWLEDGE,
            SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.GLASS_PANE), SlimefunItems.MAGIC_LUMP_2
        }, new SlimefunItemStack(ESSENCE, 16)).register(p);

        new SlimefunItem(ig, TOKEN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            ESSENCE, SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.EMERALD),
            null, null, null,
            null, null, null
        }, new SlimefunItemStack(TOKEN, 2)).register(p);

        // Setup Villager Charm
        new TransportCharm(ig).register(p);

        // Setup wands
        new CureWand(ig).register(p);
        new NitwitWand(ig).register(p);
        new TradeWand(ig).register(p);
        new TransportWand(ig).register(p);
    }
}
