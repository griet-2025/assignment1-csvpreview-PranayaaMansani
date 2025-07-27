package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // TO DO: Write your code below 
        String filePath = "dataset/dataset.csv";
        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Empty CSV file.");
                return;
            }
            System.out.println("=== Data Preview ===\n");
            String[] columns = headerLine.split(delimiter);
            System.out.println("Columns:");
            for (String column : columns) {
                System.out.print(column + " ");
            }
            System.out.println("\nTotal columns: " + columns.length);
            System.out.println("\nFirst 5 Records:\n");

            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                System.out.println(String.join(" ", data));
                count++;
                if (count == 5) break;
            }

            
            while (br.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}