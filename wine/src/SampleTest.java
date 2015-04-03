import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SampleTest {
    public HashMap outHashMap = new HashMap<String, String>();
    FileWriter fw = null;

    public static void main(String a[]) throws Exception {
        new SampleTest().solveProblem();

    }

    private void solveProblem() {
        try {
            FileReader fr = new FileReader("/home/sudhir/WineProblem/wine/src/wine.txt");
            fw = new FileWriter("/home/sudhir/WineProblem/wine/src/winesol.csv");//declaring file object
            HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
            SampleTest b = new SampleTest();
            BufferedReader brin = new BufferedReader(fr);
            String line;
            while ((line = brin.readLine()) != null) {
                HashSet<String> hset = new HashSet<String>();
                String[] splittedString1 = line.split("\\s");
                int lineIndex = 0;
                String mapVal = splittedString1[lineIndex];
                String mapKey = splittedString1[lineIndex + 1];
                hset.add(mapVal);
                HashSet<String> hset1 = new HashSet<String>();
                hset1 = b.compare(mapKey);
                map.put(mapKey, hset1);

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
                        System.out.println(randomKey + " :  " + setElement + " ");
                        wineSolution(randomKey, setElement);
                    }
                    i++;
                }
            }
            HashMap outHashMapToFile = new HashMap<String, String>();
            outHashMapToFile = b.outHashMap;                                    //writing to the output hashmap
            System.out.println("no of wines sold =" + outHashMap.size());
            fw.write("\n Count of Sold Wines: ," + outHashMap.size() + "\n");   //writing to file
            System.out.println("The OutHash map:" + outHashMap);
            Set mapSet = (Set) outHashMap.entrySet();
            Iterator mapIterator = mapSet.iterator();
            while (mapIterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) mapIterator.next();
                String keyValue = (String) mapEntry.getKey();
                String value = (String) mapEntry.getValue();
                System.out.println("\n the output file content \n" + keyValue + " " + " " + value);
                fw.write(keyValue + " \t " + value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static HashSet<String> compare(String mapKey) throws Exception {
        FileReader fr1 = new FileReader("/home/sudhir/trunk/dev/GET/src/wine.txt");  //declaring file object
        HashSet<String> hset = new HashSet<String>();
        BufferedReader brin2 = new BufferedReader(fr1);
        String line2;
        while ((line2 = brin2.readLine()) != null) {
            String[] splittedString2 = line2.split("\\s");
            int lineIndex = 0;
            String mapVal1 = splittedString2[lineIndex];
            String mapKey1 = splittedString2[lineIndex + 1];
            if (mapKey.equals(mapKey1))
                hset.add(mapVal1);

        }
        return hset;
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
            temSet2.add(tempKey);
            outHashMap.put(tempKey, tempVal);
            return;
        }
        if (!temSet3.contains(tempVal)) {
            temSet3.add(tempVal);
            temSet3.add(tempKey);
            outHashMap.put(tempKey, tempVal);
            return;
        }

        return;
    }


}


