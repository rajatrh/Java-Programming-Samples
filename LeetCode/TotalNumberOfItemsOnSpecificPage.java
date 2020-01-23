import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemPerPage
     *  5. INTEGER pageNumber
     */

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        
        // Create comparator to compare lists in the items
        Comparator<List<String>> listComparator;

        // If sortParameter is 0 then its a "String"
        if(sortParameter == 0){
            if(sortOrder == 0){// Ascending
                listComparator = (List<String> i1, List<String> i2) -> i1.get(sortParameter).compareTo(i2.get(sortParameter));
            }else{// Descending
                listComparator = (List<String> i1, List<String> i2) -> i2.get(sortParameter).compareTo(i1.get(sortParameter));
            }
        } else {
            if(sortOrder == 0){// Ascending
                listComparator = (List<String> i1, List<String> i2) -> Integer.parseInt(i1.get(sortParameter))-Integer.parseInt(i2.get(sortParameter));
            }else{// Descending
                listComparator = (List<String> i1, List<String> i2)-> Integer.parseInt(i2.get(sortParameter))-Integer.parseInt(i1.get(sortParameter));
            }
        }
        // Sort the items according to the list comparator and items O(nlogn), n = size of items
        Collections.sort(items, listComparator);

        int itemStart = itemPerPage*pageNumber;
        List<String> result = new ArrayList<>();

        // Create result.
        for(int i = itemStart; i< itemStart+itemPerPage && i< items.size(); i++){
            result.add(items.get(i).get(0));
        }

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> items = new ArrayList<>();

        IntStream.range(0, itemsRows).forEach(i -> {
            try {
                items.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());

        int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());

        int itemPerPage = Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemPerPage, pageNumber);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
