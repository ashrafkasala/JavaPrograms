package conversions;



import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;

public class StringArrayToFile {
    public static void main(String[] args) throws IOException {

        String[] array = new String[3];
        array[0] = "100A";
        array[1] = "200B";
        array[2] = "300C";

        // Create our BufferedWriter.
        BufferedWriter writer = new BufferedWriter(new FileWriter(
                "e:\\StringArrayToFile"));

        // Loop over the elements in the string array and write each line.
        for (String line : array) {
            writer.write(line);
           // writer.newLine();
        }
        writer.close();
    }
}