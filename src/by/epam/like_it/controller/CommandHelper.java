package by.epam.like_it.controller;



import by.epam.like_it.command.Command;
import by.epam.like_it.command.impl.ChangeLanguage;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();

	private Map<CommandName, Command> commands = new HashMap<>();

	private CommandHelper() {
		commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
	}

	public Command getCommand(String name) {
		name = name.replace('-', '_');
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}

	public static CommandHelper getInstance() {
		return instance;
	}

}
