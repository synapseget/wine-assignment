import java.io.*;
import java.util.*;

public class SampleTest {
    public HashMap outHashMap = new HashMap<String, String>();

    public static void main(String a[]) throws Exception {
        new SampleTest().solveProblem();
    }

    private void solveProblem() {
        FileWriter fileWriter = null ;
        try {

            File inputFile = new File ( "/home/sudhir/WineProblem/wine/src/pw1.txt" ) ;

            if (!inputFile.exists()) {
                inputFile = new File ("/home/sudhir/WineProblem/wine/src/wine.txt") ;
            }

            File outputFile = new File ( "/home/sudhir/WineProblem/wine/src/winesol.csv" ) ;

            FileReader fileReader = new FileReader( inputFile );
            fileWriter = new FileWriter( outputFile);
            HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
            BufferedReader brin = new BufferedReader(fileReader);
            String line;
            while ((line = brin.readLine()) != null) {
                HashSet<String> hset = new HashSet<String>();
                String[] splittedString1 = line.split("\\s");
                int x = 0;
                String mapVal = splittedString1[x];
                String mapKey = splittedString1[x + 1];
                if (map.get(mapKey) != null)
                    map.get(mapKey).add(mapVal);
                else
                {
                    HashSet<String> hset2 = new HashSet<String>();
                    hset2.add(mapVal);
                    map.put(mapKey, hset2);
                }
            }
            System.out.println(map);
            Random random = new Random();
            List<String> keys = new ArrayList<String>(map.keySet());
            for (int lenOfMap = 0; lenOfMap < map.size(); lenOfMap++) {
                String randomKey = keys.get(random.nextInt(keys.size()));
                HashSet valueset = map.get(randomKey);
                int i = 1;
                List<String> stringSet = new ArrayList<String>(valueset);

                for (String setElement : stringSet) {

                    int item = (int) (Math.random() * valueset.size() + 1);
                    if (i == item) {
                        wineSolution(randomKey, setElement);
                    }
                    i++;
                }
            }
            fileWriter.write("\n Count of Sold Wines: " + outHashMap.size() + "\n");
            Set mapSet = (Set) outHashMap.entrySet();
            Iterator mapIterator = mapSet.iterator();
            while (mapIterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) mapIterator.next();
                String keyValue = (String) mapEntry.getKey();
                String value = (String) mapEntry.getValue();
                System.out.println("\n the output file content \n" + keyValue + " " + " " + value);
                fileWriter.write(keyValue + " \t " + value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void wineSolution(String tempKey, String tempVal) throws Exception {
        HashSet<String> temSet1 = new HashSet<String>();
        HashSet<String> temSet2 = new HashSet<String>();
        HashSet<String> temSet3 = new HashSet<String>();
        if (!temSet1.contains(tempVal)) {
            temSet1.add(tempVal);
            outHashMap.put(tempKey, tempVal);
            return;
        }
        if (!temSet2.contains(tempVal)) {
            temSet2.add(tempVal);
            outHashMap.put(tempKey, tempVal);
            return;
        }
        if (!temSet3.contains(tempVal)) {
            temSet3.add(tempVal);
            outHashMap.put(tempKey, tempVal);
            return;
        }
        return;
    }

}


