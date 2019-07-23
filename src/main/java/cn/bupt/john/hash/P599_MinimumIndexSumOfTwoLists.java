package cn.bupt.john.hash;

import java.util.*;


public class P599_MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        P599_MinimumIndexSumOfTwoLists solution = new P599_MinimumIndexSumOfTwoLists();
        System.out.println(Arrays.toString(solution.findRestaurant(new String[]{"n","vamh","KFB"},
                new String[]{"kxhzx","vamh","KFB"})));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int result = list1.length + list2.length;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (i > result) {
                break;
            }
            if (map.containsKey(list2[i])) {
                int min = map.get(list2[i]) + i;

                if (min < result) {
                    result = min;
                    results.clear();
                    results.add(list2[i]);
                }
                else if (min == result) {
                    results.add(list2[i]);
                }

            }
        }
        String[] strings = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            strings[i] = results.get(i);
        }
        return strings;
    }

}
