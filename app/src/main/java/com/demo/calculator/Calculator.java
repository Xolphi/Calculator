/*
 * Calculator Demo
 */
package com.demo.calculator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Rudimentary Calculator App used to demonstrate committing to
 * Git repositories and creating merge requests
 * 
 * @author Juan Hernandez
 *
 */
public class Calculator {

    public static String HELP_S_HAND = "h";
    public static String HELP_L_HAND = "help";

    public static String SUM_S_HAND = "s";
    public static String SUM_L_HAND = "sum";

    public static String DIFF_S_HAND = "d";
    public static String DIFF_L_HAND = "diff";

    private final Options options = new Options();
    private final HelpFormatter formatter = new HelpFormatter();
    private final CommandLineParser parser = new DefaultParser();

    /**
     * Sole Constructor
     */
    public Calculator() {
        createOptions();
    }

    /**
     * Creates the command line argument options for the program
     */
    public void createOptions() {
        Option help  = Option.builder(HELP_S_HAND).longOpt(HELP_L_HAND)
                             .argName(HELP_L_HAND).desc("Print this message.").build();

        Option sum  = Option.builder(SUM_S_HAND).longOpt(SUM_L_HAND).argName("Num1 Num2")
                            .numberOfArgs(2).valueSeparator(' ').desc("Adds 2 numbers together").build();

        Option diff  = Option.builder(DIFF_S_HAND).longOpt(DIFF_L_HAND).argName("Num1 Num2")
                .numberOfArgs(2).valueSeparator(' ').desc("Subtracts 2 numbers together").build();

        options.addOption(help);
        options.addOption(diff);
        options.addOption(sum);
    }

    /**
     * Parses the arguments from the command line and reacts accordingly
     * 
     * @param args Commandline arguments
     */
    public void performCalculation(String[] args) {
        try{
            CommandLine line = parser.parse( options, args );

            if( line.hasOption(HELP_S_HAND) ) {
                formatter.printHelp("Calculator", options, true);
            }
            else if( line.hasOption(SUM_S_HAND) ) {
                int x = Integer.valueOf(line.getOptionValues(SUM_S_HAND)[0]);
                int y = Integer.valueOf(line.getOptionValues(SUM_S_HAND)[1]);

                System.out.println("The sum of " + x + " and " + y + " is " + sum(x,y) );
            }
        }
        catch( ParseException exp ) {
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
        }
    }

    /**
     * @param x integer
     * @param y integer
     * 
     * @return the sum of x and y
     */
    public int sum(int x, int y) {
        return x + y;
    }

    public int diff(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.performCalculation(args);
        System.exit(0);
    }

}
