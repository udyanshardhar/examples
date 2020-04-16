package com.us.solutions;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubString {
    public List<String> findAllSubString(String input) {
        List<String> res = new ArrayList<>();
        for(int i =0; i < input.length(); i++) {
            for(int j = i+1; j <= input.length(); j ++){

                System.out.println(input.substring(i , j));
                res.add(input.substring(i , j));
            }
        }
        return res;
    }
}
