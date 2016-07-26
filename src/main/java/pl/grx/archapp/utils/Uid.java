package pl.grx.archapp.utils;

public class Uid {
    private static int current = 0;
    public static String getNext() {
        return String.valueOf(current++);
    }
}
