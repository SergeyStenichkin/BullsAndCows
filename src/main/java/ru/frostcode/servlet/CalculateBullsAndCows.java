package ru.frostcode.servlet;

import java.util.Random;

class CalculateBullsAndCows {

     public static String randomNumber(){
        return String.valueOf(new Random().nextInt(9999));
    }
    private static int countBetween(char what, String where, int from, int to){
        int count = 0;
        for (int i = from; i < to; ++i){
            if (where.charAt(i) == what) count++;
        }
        return count;
    }

    public static Pair<Integer, Integer> calcBullsCows(String hiddenNumber, String inputString){
        Integer nBulls = 0;
        Integer nCows = 0;

        StringBuilder hidNum_builder = new StringBuilder(hiddenNumber);
        StringBuilder inpStr_builder = new StringBuilder(inputString);

        for(int i = 0; i < hiddenNumber.length(); ++i){
            if (hiddenNumber.charAt(i) == inputString.charAt(i)){
                nBulls++;
                hidNum_builder.setCharAt(i, ' ');
                inpStr_builder.setCharAt(i, ' ');
            }
        }

        hiddenNumber = hidNum_builder.toString();
        inputString = inpStr_builder.toString();

        for (int i = 0; i < hiddenNumber.length(); ++i){
            if (hiddenNumber.charAt(i) == ' ')
                continue;

            int countLeft = countBetween(hiddenNumber.charAt(i), hiddenNumber, 0, i);
            int countInComputerNumber = countBetween(hiddenNumber.charAt(i), inputString, 0, inputString.length());

            if (countInComputerNumber != 0 && countLeft < countInComputerNumber)
                nCows++;
        }

        return new Pair<Integer, Integer>(nBulls, nCows);
    }
}
