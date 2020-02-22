package javaStream;

import java.util.Arrays;

public class StreamTest {
    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }
    public static void main(String[] a){
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);
        stringConverter.convert(2);

    }
}
