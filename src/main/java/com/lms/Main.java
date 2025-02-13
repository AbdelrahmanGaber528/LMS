package com.lms;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while(t>0){

            t--;
        }
    }
}

class Solution {
    public boolean isPalindrome(String s) {
       StringBuilder tmp = new StringBuilder(s.toLowerCase());

       for(int i = 0;i<s.length();i++){
           if(Character.isAlphabetic(s.charAt(i)))
              tmp.append(s.charAt(i));
       }
       String res = tmp.toString().toLowerCase();

       int i = 0 , j = res.length()-1;
       while(i<j){
           if(res.charAt(i) != res.charAt(j))
               return false;
       }
        return true;
    }
}

