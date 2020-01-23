import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.*;

class Test {
      public static void main(String args[]) {
          System.out.println(findMaxCommonality("abbcad"));
      }

    public static int findMaxCommonality(String str) {
        int[] count = new int[26];
        for(char ch : str.toCharArray()) {
            count[ch-'a']++;
        }
        int res = 0;
        int cur = 0;
        for(int i=0; i<str.length(); ++i) {
            if(count[str.charAt(i)-'a'] > 1) {
                ++cur;
                count[str.charAt(i)-'a'] -= 2;
            } else if (count[str.charAt(i)-'a'] == 0) {
                --cur;
            } else {
                --count[str.charAt(i)-'a'];
            }
            res = Math.max(cur, res);
        }
        return res;
    }

    public static int findMaxCommonality2(String str) {
        int res = 0;
        HashMap<Character,List<Integer>> charMap = new HashMap();
        List<Integer> indexArray = new ArrayList();
        for(int i=0; i< str.length(); i++)
        {
            indexArray = charMap.getOrDefault(str.charAt(i), new ArrayList());
            indexArray.add(i);
            charMap.put(str.charAt(i), indexArray);
        }
        indexArray = new ArrayList();
        Iterator itr = charMap.entrySet().iterator();
        while (itr.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        if(pair.getValue().length() > 1){
            for(int i; i<pair.getValue().length(); i++)
                indexArray.add(i);
        }
        
        it.remove(); // 
    }

    Collections.sort(indexArray);

        return res;
    }
  }