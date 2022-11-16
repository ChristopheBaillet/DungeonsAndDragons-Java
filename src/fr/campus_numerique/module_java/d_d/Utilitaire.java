package fr.campus_numerique.module_java.d_d;

import java.util.Random;

public class Utilitaire {
    private static final Random random = new Random();
    public static String randomBetweenTwoStrings(String a, String b){
        switch (random.nextInt(2)){
            case 0 -> {
                return a;
            }
            case 1 -> {
                return b;
            }
        }
        return a;
    }
    public static int getIndexOf(String[] strings, String item) {
        for (int i = 0; i < strings.length; i++) {
            if (item.equals(strings[i])) return i;
        }
        return -1;
    }

    public static String getRandomStringFromArray(String[] array){
        return array[random.nextInt(array.length)];
    }

}
