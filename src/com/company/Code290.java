package com.company;


/**
 * @program:
 * @description: ✔[290]单词规律
 * @author:
 * @create:
 **/
public class Code290 {

//    String pattern = "abba";
//    String s = "dog cat cat fish";
//    System.out.println(wordPattern(pattern,s));

    public static boolean wordPattern(String pattern, String s) {

        //pattern
        String[] a = pattern.split("");
        //str
        String[] b = s.split(" ");
        int a_length = a.length;
        if (a_length != b.length) {
            return false;
        }
        for (int i = 0; i < a_length - 1; i++) {
            for (int j = i + 1; j < a_length; j++) {
                if (a[i].equals(a[j])) {
                    if (!(b[i].equals(b[j]))) {
                        return false;
                    }
                } else {
                    if (b[i].equals(b[j])) {
                        return false;
                    }
                }
            }

        }
        return true;

    }
}

//
//    //pattern
//    String[] a = pattern.split("");
//    //str
//    String[] b = s.split(" ");
//    int a_length = a.length;
//    HashMap<String, String> hashMap_a = new HashMap<>(a_length);
//    HashMap<String, String> hashMap_b = new HashMap<>(a_length);
//        if (a_length != b.length) {
//                return false;
//                }
//                for (int i = 0; i < a_length; i++) {
//        System.out.println("b[i]"+b[i]+",hashMap.get(a[i])"+hashMap_a.get(a[i]));
//        if (!hashMap_a.containsKey(a[i])) {
//        if (hashMap_b.containsKey(b[i])){return false;}
//        hashMap_a.put(a[i], b[i]);
//        hashMap_b.put(b[i], a[i]);
//        } else if (!b[i].equals(hashMap_a.get(a[i]))) {
//
//        return false;
//        }
//        }
//        return true;
