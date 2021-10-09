package CS141;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;

public class SIMPLESEM{

    static String studentName = "YOUR NAME";
    static String studentID = "YOUR 8-DIGIT ID";
    static String uciNetID = "YOUR UCI-NET ID";
    private static int nextChar; //contains the character(or -1==EOF)
    private static final int EOF = -1; //int value for End of File
    private int number;

    private static LineNumberReader in;
    public static FileOutputStream outFile;
    private static PrintStream fileData;

    public static void main(String[] args)
    {
        SIMPLESEM s = new SIMPLESEM(args[0]);
        s.parseProgram();
    }

    private void printRule(String rule){
        fileData.println(rule);
    }


    public SIMPLESEM(String sourceFile) {
        try {
            SIMPLESEM.in = new LineNumberReader(new FileReader(sourceFile));
            SIMPLESEM.in.setLineNumber(1);
            nextChar = SIMPLESEM.in.read();
            outFile = new FileOutputStream(sourceFile + ".out");
            fileData = new PrintStream(outFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("init: Errors accessing source file "
                    + sourceFile);
            System.exit(-2);
        }
    }

    public void parseProgram() {
        printRule("Program");
        parseStatement();
        while (nextChar != EOF){
            parseStatement();
        }
    }

    private void parseStatement() {
        printRule("Statement");
        // TODO Auto-generated method stub

    }
}