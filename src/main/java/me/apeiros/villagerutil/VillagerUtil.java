package me.apeiros.villagerutil;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;

import java.util.concurrent.ThreadLocalRandom;

public class VillagerUtil extends AbstractAddon {

    // Instance
    private static VillagerUtil instance;

    // Number for confirmation of villager reset command
    private static int commandNumber;

    // Whether or not token consumption is enabled
    private static boolean useTokens;

    // Auto update things
    public VillagerUtil() {
        super("ybw0014", "VillagerUtil-CN", "main", "options.auto-update");
    }

    @Override
    public void enable() {
        // Instance
        instance = this;

        // Command number
        commandNumber = ThreadLocalRandom.current().nextInt(0, 1_000_000);

        if (getConfig().getBoolean("options.auto-update") &&
            getDescription().getVersion().startsWith("Build")) {
            new GuizhanBuildsUpdater(this, getFile(), "ybw0014", "VillagerUtil-CN", "main", false).start();
        }

        // Whether or not to consume tokens
        useTokens = this.getConfig().getBoolean("options.use-tokens");

        // Setup
        Setup.setup(this);
    }

    @Override
    public void disable() {
        // Clean up instance
        instance = null;
    }

    public static VillagerUtil i() {
        return instance;
    }

    public static int getCommandNumber() {
        return commandNumber;
    }

    public static boolean useTokens() {
        return useTokens;
    }

}
