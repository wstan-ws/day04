import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.stream.Stream;

public class CountWordsWithStream {
    public static void main(String[] args) throws Exception {
        // Open the file
        
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        // Use streams to find number of words in the text file
        
        /* 
        // Optional type because it may return no result -> empty file
        Optional<Integer> opt = br.lines()
            // Clean the line
            .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
            // Remove empty line
            .filter(line -> line.length() > 0)
            // line -> words -> count
            .map(line -> line.split(" ").length)
            .reduce((acc, x) -> acc + x)
            ;
        
        if (opt.isPresent()) {
            int total = opt.get();
            System.out.printf("Number of words in %s is %d%n", args[0], total);
        } else {
            System.out.println("No result");
        }
            

        */

        // MY ANSWER - (does not work)
        // List<String> listOfWords = new LinkedList<>();
        // while ((line = br.readLine()) != null) {
        //     listOfWords.add(br.readLine());
        // }
        //     System.out.println(listOfWords);
            //  int wordCount = listOfWords.stream()
            //                  .filter() // filter away blank spaces
            //                  .map() // map into array of words
            //                  .map() // map into array.length
            //                  .reduce() // reduce to sum of all array.length
            //                  ; 
        // System.out.printf("Word count: %d", wordCount);
        
        long count = br.lines()
            // Clean the line
            .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
            // Remove empty line
            .filter(line -> line.length() > 0)
            // line -> words
            .map(line -> line.split(" "))
            .flatMap(words -> Stream.of(words))
            .count()
            ;

        System.out.printf("Count: %d", count);
    }
}