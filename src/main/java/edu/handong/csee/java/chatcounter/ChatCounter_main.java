package edu.handong.csee.java.chatcounter;

import java.util.HashMap;
import java.util.ArrayList;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
/**
 The main class of Count the KaKao Chat contents HW4
 @author LeeSangHyun
 **/
public class ChatCounter_main {	

	String path;
	boolean verboses;
	boolean help;
	String Thread;

	public static void main(String[] args) {

		ChatCounter_main Controller = new ChatCounter_main();
		Controller.run(args);

		ArrayList<String> messages = new ArrayList<String>();
		ArrayList<Lists> list = new ArrayList<Lists>();
		HashMap<String,Integer> nameAndMessage = new HashMap<String,Integer>();
		
		FileWriter writer = new FileWriter();
		MessageParser parser = new MessageParser();
		PMCounter filter = new PMCounter();

		list = parser.MParser(messages);
		nameAndMessage = filter.countMessage(list);
		writer.getFile(nameAndMessage);

	}

	private void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}

			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + path + "\" as the value of the option p");

			// TODO show the number of files in the path

			if(verboses) {

				// TODO list all files in the path

				System.out.println("The program is terminated. (This message is shown because you turned on -v option!");
			}
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			Thread = cmd.getOptionValue("c");
			path = cmd.getOptionValue("p");
			verboses = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("p").longOpt("path")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}


}
