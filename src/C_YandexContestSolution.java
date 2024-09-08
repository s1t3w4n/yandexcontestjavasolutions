import java.io.*;

public class C_YandexContestSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        final int size = Integer.parseInt(r.readLine());
        Integer printed = null;

        for (int i = 0; i < size; i++) {
            final Integer integer = Integer.valueOf(r.readLine());
            if (!integer.equals(printed)) {
                System.out.println(integer);
                printed = integer;
            }
        }
    }
}
