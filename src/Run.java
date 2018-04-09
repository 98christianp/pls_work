import org.antlr.v4.runtime.*;
import java.util.*;

public class Run {

    public static void main(String args[]) throws Exception {

        System.out.println("Insert command (one line only):");
        String input = System.console().readLine();

        // build the parser for the content of the input
        CharStream inputStream = CharStreams.fromString(input);
        GCLLexer lex = new GCLLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        GCLParser parser = new GCLParser(tokens);

        System.out.println(); //print a new line for  aesthetics
        lex.removeErrorListeners(); // remove default error message so we can add our own functionality
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
        Visitor visitor = new Visitor();
        // print the result of parsing the input
        try {

            System.out.println(visitor.visit(parser.start()));

        }
        catch (Exception e){
            System.out.println("Invalid grammar");
        }
    }
}