import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {
    public static void main(String[] args) throws Exception {
        // Open the file
        
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        // Use loop to find number of words in the text file
        
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            // Clean the line
            // ^\\ = not any; [] = or
            line = line.trim().replaceAll("[^\\sa-zA-Z0-9]", "");
            // Check if line is empty
            if (line.length() <= 0)
                continue;
            // Split the line into words delimited by space
            String[] words = line.split(" ");
            // Count the number of words and add to the total
            count += words.length;
        }

        br.close();

        System.out.printf("Number of words in %s is %d%n", args[0], count);

        // MY ANSWER - (works)
        
        // int counter = 0;
        // while ((line = br.readLine()) != null) {
        //     String[] wordArray = line.split(" ");
        //     for (int i = 0; i < wordArray.length; i++) {
        //         if (wordArray[i].isEmpty()) {
        //             continue;
        //         }
        //         counter++;
        //     }
        // }
        // System.out.printf("Word count: %d", counter);
    }
}