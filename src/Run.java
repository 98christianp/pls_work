import org.antlr.v4.runtime.*;
import java.util.*;

public class Run {
    private Scanner scannerInput = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        System.out.println("Insert command (end with: _p (Test grammar), _g (Generate Graph), _i (Interpretation):");

        String input = "";
        String lineInput = null;
        Scanner scanner = new Scanner( System.in );
        String command = "";
        boolean first_line = true;

        while( scanner.hasNextLine() )
        {
            lineInput = new String( scanner.nextLine() );
            if(lineInput.equals("_q")){
                break;
            }
            else if(lineInput.equals("_p") || lineInput.equals("_g") || lineInput.equals("_i")){
                command = lineInput;
                break;
            }
            else if(first_line){
                input = input.concat(lineInput);
            }
            else{
                input = input.concat("\n"+lineInput);
            }
            first_line = false;
        }
        scanner.close();

        System.out.println( input );


        // build the parser for the content of the input
        CharStream inputStream = CharStreams.fromString(input);
        GCLLexer lex = new GCLLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        GCLParser parser = new GCLParser(tokens);

        System.out.println(); //print a new line for  aesthetics
        lex.removeErrorListeners(); // remove default error message so we can add our own functionality
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
        Graph graph = new Graph();
        // print the result of parsing the input
        try {
            //parser.start();
            //visitor.visit();
            switch (command){
                case "_p":  System.out.println("OK");
                    break;

                case "_g":
                    break;

                case "_i":  System.out.println("Not yet implemented");
                    break;
            }

        }
        catch (Exception e){
            switch (command){
                case "_p":
                    System.out.println("KO");
                    break;

                default: System.out.println("Invalid grammar");
                    break;
            }

        }
        switch (command){

            case "_g":
                graph.visit(parser.start());
                System.out.println(graph);
                break;

            case "_i":  System.out.println("Not yet implemented");
                break;
        }





    }
}