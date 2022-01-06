package main;

import checker.Checker;
import common.Constants;
import data.ActionData;
import fileio.InputLoader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.OUTPUT_DIR);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.OUTPUT_DIR);

        Checker checker = new Checker();

        checker.deleteFiles(outputDirectory.listFiles());

        int i = 1;

        for (File ignored : Objects.requireNonNull(directory.listFiles())) {

            String filepath = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            String inputFile = Constants.TESTS_PATH + "test" + i + Constants.FILE_EXTENSION;

            File out = new File(filepath);
            File in = new File(inputFile);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                //creat ++;
                action(in.getAbsolutePath(), filepath);
                //action(in.getAbsolutePath(), out.getAbsolutePath());
            }
            i++;
        }
        //System.out.println("created files " + creat);
        Checker.calculateScore();//////////////
    }

    /**
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1, final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        ActionData input = inputLoader.readData();
        //FileWriter fileWriter = new FileWriter(filePath2);

//        JSONArray annualChild = new JSONArray();
//
//        Output out = new Output();
//        AnnualOutput anOut = new AnnualOutput();
//
//        for(Child ch : input.getInitialData().getChildren()){
//            anOut.getAnnualChilds().add(ch);
//        }
//        Child ch2 = new Child();
//        anOut.getAnnualChilds().add(ch2);
//        out.getOutputList().add(anOut);
//
//        /// PRINT
//
//        for(AnnualOutput an : out.getOutputList()){
//            JSONObject jsonObject = new JSONObject();
//            JSONArray children = new JSONArray();
//            children.add(an.getAnnualChilds());
//            jsonObject.put("children", children);
//            annualChild.add(children);
//        }
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("annualChildren", annualChild);
//
//        fileWriter.write(jsonObject.toJSONString());
//        fileWriter.flush();
//        fileWriter.close();

        // TODO add here the entry point to your implementation

        //printInput(input, filePath1);

        ProcessInput processInput = new ProcessInput();
        //System.out.println("Annual changes " + input.getAnnualChanges());
        processInput.init(input, filePath2);

        //System.out.println();
        //System.out.println();
    }

//    public static void printInput(ActionData inp, String filePath1){
//        System.out.println("File title " + filePath1);
//        System.out.println();
//        System.out.println("Number of years " + inp.getNumberOfYears());
//        System.out.println("Santa Budget " + inp.getSantaBudget());
//        System.out.println();
//        System.out.println("Initial data : ");
//        System.out.println();
//        System.out.println(inp.getInitialData());
//        System.out.println();
//        System.out.println("Annual changes : ");
//        System.out.println();
//        System.out.println(inp.getAnnualChanges());
//    }
}
