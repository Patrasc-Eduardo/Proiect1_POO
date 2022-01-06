package fileio;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The class writes the output in files
 * <p>
 * DO NOT MODIFY
 */
public final class Writer {

    public Writer(final String path) throws IOException {
        /**
         * The file where the data will be written
         */
        FileWriter file = new FileWriter(path);
    }

    /**
     * Transforms the output in a JSONObject
     *
     * @return An JSON Object
     * @throws IOException in case of exceptions to reading / writing
     */
//    public JSONObject writeFile(final Output output) throws IOException {
//        JSONObject object = new JSONObject();
//         // Print it with specified indentation
//        return object;
//    }

    /**
     * writes to the file and close it
     *
     * @param array of JSON
     */
//    public void closeJSON(final JSONArray array) {
//        try {
//            file.write(array.toJSONString());
//            file.flush();
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
