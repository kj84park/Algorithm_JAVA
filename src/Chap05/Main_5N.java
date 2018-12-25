package Chap05;

import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Main_5N {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String mainString = scanner.next();
        String pattern = scanner.next();

        List<Integer> matchedIndexs = getMachedIndexes(mainString,pattern);

        for (int i : matchedIndexs){
            System.out.println(i);
        }

    }

    private static List<Integer> getMachedIndexes(String mainString, String pattern) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i+pattern.length()-1 < mainString.length(); i++){

            boolean matched = true;
            for (int j = 0 ; j < pattern.length() ; j++){
                if(mainString.charAt(i+j) != pattern.charAt(j)){
                    matched = false;
                    break;
                }
            }
            if(matched){
                list.add(i);
            }
        }
        return list;
    }
}
