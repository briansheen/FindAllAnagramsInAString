package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "bababbba";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> anagramsList = new ArrayList<>();
        Map<String, Integer> charsInP = new HashMap<>();
        for(int i = 0; i < p.length(); ++i){
            if(charsInP.get(String.valueOf(p.charAt(i)))==null){
                charsInP.put(String.valueOf(p.charAt(i)),1);
            } else {
                charsInP.put(String.valueOf(p.charAt(i)),charsInP.get(String.valueOf(p.charAt(i)))+1);
            }
        }
        Map<String, Integer> charsInS = new HashMap<>();
        if(s.length()<p.length()){
            return anagramsList;
        }
        String sub = s.substring(0,p.length());
        for(int j = 0; j < sub.length(); ++j){
            if(charsInS.get(String.valueOf(sub.charAt(j)))==null){
                charsInS.put(String.valueOf(sub.charAt(j)),1);
            } else {
                charsInS.put(String.valueOf(sub.charAt(j)),charsInS.get(String.valueOf(sub.charAt(j)))+1);
            }
        }
        for(int i = 0; i <= s.length()-p.length(); ++i){
            if(i>=1) {
                if(charsInS.get(String.valueOf(s.charAt(i-1)))==1){
                    charsInS.remove(String.valueOf(s.charAt(i-1)));
                } else {
                    charsInS.put(String.valueOf(s.charAt(i-1)),charsInS.get(String.valueOf(s.charAt(i-1)))-1);
                }
                if(charsInS.get(String.valueOf(s.charAt(i+p.length()-1)))==null){
                    charsInS.put(String.valueOf(s.charAt(i+p.length()-1)),1);
                } else {
                    System.out.println(charsInS);
                    charsInS.put(String.valueOf(s.charAt(i+p.length()-1)),charsInS.get(String.valueOf(s.charAt(i+p.length()-1)))+1);

                }
            }
            if(charsInS.equals(charsInP)){
                anagramsList.add(i);
            }
        }
        return anagramsList;
    }
}
