package model;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyString {
    public static String correctString(byte[] bytes){
        String data= new String(bytes);
        char[] arr=data.toCharArray();
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
        return cStream.filter(d -> {
            int v= d;
            return (v<58 && v>47) || (v>64 && v< 91) ||(v>96 && v< 123);
        }).map(c -> c.toString()).reduce((v1, v2)-> v1+v2).get();
    }
    public static String correctString(char[] arr){
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
        return cStream.filter(d -> {
            int v= d;
            return (v<58 && v>47) || (v>64 && v< 91) ||(v>96 && v< 123);
        }).map(c -> c.toString()).reduce((v1, v2)-> v1+v2).get();
    }
}
