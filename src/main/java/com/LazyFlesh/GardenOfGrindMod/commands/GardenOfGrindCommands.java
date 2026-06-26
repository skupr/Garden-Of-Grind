package com.LazyFlesh.GardenOfGrindMod.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import com.LazyFlesh.GardenOfGrindMod.ChallengeMode.ModeLoader;
import com.LazyFlesh.GardenOfGrindMod.GeneralConfig;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

public class GardenOfGrindCommands extends CommandBase {

    @Override
    public String getCommandName() {
        return "gog";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("GardenOfGrind", "gardenofgrind", "GoG");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/gog <mode|dragonfight> [args...]";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 1) {
            printHelpFull(sender);
            return;
        }
        String subCommand = args[0].toLowerCase();
        if (!sender.canCommandSenderUseCommand(getRequiredPermissionLevel(), getCommandName())) return;

        switch (subCommand) {
            case "mode": {
                if (args.length == 1) {
                    sender.addChatMessage(new ChatComponentText(ModeLoader.getMode()));
                    return;
                } else if (args.length > 1) {
                    String arg1 = args[1].toLowerCase();
                    switch (arg1) {
                        case "gardenofgrind", "0" -> {
                            GeneralConfig.challengeMode = 0;
                        }
                        case "gardenofgrindless", "2" -> {
                            GeneralConfig.challengeMode = 2;
                        }
                        case "skyblock", "1" -> {
                            GeneralConfig.challengeMode = 1;
                        }
                        case "questlessgardenofgrind", "3" -> {
                            GeneralConfig.challengeMode = 3;
                        }
                        default -> {
                            sender.addChatMessage(
                                new ChatComponentText("/gog mode <0~3> - Set Garden Of Grind mode to <mode>"));
                            return;
                        }
                    }
                    ConfigurationManager.save(GeneralConfig.class);
                    sender.addChatMessage(new ChatComponentText("Requires server restart to take effect."));
                }
            }
            case "dragontime": {
                if (args.length == 1) {
                    sender.addChatMessage(new ChatComponentText(GeneralConfig.chaosDragonTime ? "True" : "False"));
                    return;
                } else if (args.length > 1) {
                    String arg1 = args[1].toLowerCase();
                    switch (arg1) {
                        case ("true") -> {
                            GeneralConfig.chaosDragonTime = true;

                        }
                        case ("false") -> {
                            GeneralConfig.chaosDragonTime = false;
                        }
                        default -> {
                            sender.addChatMessage(
                                new ChatComponentText(
                                    "/gog dragontime <true/false> - Turns modded chunk population off/on so chaos island can spawn. Requires server restart."));
                            return;
                        }
                    }
                    ConfigurationManager.save(GeneralConfig.class);
                    sender.addChatMessage(new ChatComponentText("Requires server restart to take effect."));

                }
            }
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        List<String> completions = new ArrayList<>();
        String currentArg = args.length == 0 ? "" : args[args.length - 1].trim();

        if (args.length == 1) {
            Stream.of("mode", "dragontime")
                .filter(s -> s.startsWith(currentArg))
                .forEach(completions::add);
        } else if (args.length == 2) {
            String subCommand = args[0].toLowerCase();
            if ("mode".equals(subCommand)) {
                Stream.of("GardenOfGrind", "GardenOfGrindless", "Skyblock", "QuestlessGardenOfGrind", "help")
                    .filter(s -> s.startsWith(currentArg))
                    .forEach(completions::add);
            } else if ("dragontime".equals(subCommand)) {
                Stream.of("true", "false", "help")
                    .filter(s -> s.startsWith(currentArg))
                    .forEach(completions::add);
            }
        }

        return completions;
    }

    private void printHelpFull(ICommandSender sender) {
        sender.addChatMessage(new ChatComponentText("Usage: /gog <subcommand> [args...]"));
        sender.addChatMessage(new ChatComponentText(" Subcommands:"));
        sender.addChatMessage(
            new ChatComponentText(
                "  mode <mode> - Set Garden Of Grind mode to <mode, 0~3> (requires permission level 2)"));
        sender.addChatMessage(
            new ChatComponentText(
                "  dragontime <true/false> - Turns modded chunk population off/on. Requires server restart. (requires permission level 2)"));
    }
}
