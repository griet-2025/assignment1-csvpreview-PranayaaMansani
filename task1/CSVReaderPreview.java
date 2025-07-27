package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String path = "dataset/dataset.csv";
        String line = "";
        String deli = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
           
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Empty CSV file.");
                return;
            }
            System.out.println("=== Data Preview ===\n");
            String[] col = headerLine.split(deli);
            System.out.println("Columns : ");
            for (String c : col) 
            {
                System.out.print(c + "\t");
            }
            System.out.println("\nTotal columns: " + col.length);
            System.out.println("\nFirst 5 Records:\n");

            int cnt = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(deli);
                System.out.println(String.join(" ", data));
                cnt++;
                if (cnt==5)
                break;
            }
            while (br.readLine() != null) {
                cnt+=1;
            }

            System.out.println("\nTotal Records (excluding header): " + cnt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}