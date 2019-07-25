package cn.bupt.john.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P811_SubdomainVisitCount {

    public static void main(String[] args) {
        P811_SubdomainVisitCount solution = new P811_SubdomainVisitCount();
        List<String> strings = solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
        System.out.println(strings);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> result = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            String temp = split[1];
            result.put(temp, result.getOrDefault(temp, 0) + Integer.valueOf(split[0]));
            while (temp.contains(".")) {
                temp = temp.split("\\.", 2)[1];
                result.put(temp, result.getOrDefault(temp, 0) + Integer.valueOf(split[0]));
            }
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            resultList.add(entry.getValue() + " " + entry.getKey());
        }
        return resultList;
    }
}
