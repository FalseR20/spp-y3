public class Sum {
    public static int accum(int... values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    public static long modaccum(long... values) {
        long result = 0;
        for (long value : values) {
            result += value;
        }
        return result;
    }
}
