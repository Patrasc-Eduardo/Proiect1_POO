package main;

import common.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/** Use this if you want to test on a specific input file */
public final class Test {
    /** for coding style */
    private Test() { }

    /**
     * @param args input files
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        File[] inputDir = directory.listFiles();
        //System.out.println("aiciii 0");
        if (inputDir != null) {
            Arrays.sort(inputDir);
            //System.out.println("aiciii 1");
//            Scanner scanner = new Scanner(System.in);
//            String fileName = scanner.next();
            String fileName = "test25.json";
            for (File file : inputDir) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    //System.out.println("aiciii 2");
                    Main.action(file.getAbsolutePath(), Constants.OUT_FILE);
                    break;
                }
            }
        }
    }
}
