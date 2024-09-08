import java.io.*;

/**
 * C. Удаление дубликатов
 * Compiler	Time limit	Memory limit	Input	Output
 * All compilers	1 секунда	10Mb	stdin or input.txt	stdout or output.txt
 * Node.js 14.15.5	1 секунда	20Mb
 * Oracle Java 7	1 секунда	40Mb
 * Kotlin 1.4.30 (JRE 11)	1.5 секунд	40Mb
 * Oracle Java 8	1 секунда	40Mb
 * Scala 2.13.4	1 секунда	20Mb
 * OpenJDK Java 15	1 секунда	40Mb
 * Kotlin 1.1.50 (JRE 1.8.0)	1 секунда	40Mb
 * Kotlin 1.3.50 (JRE 1.8.0)	1 секунда	30Mb
 * Kotlin 1.5.32 (JRE 11)	1.5 секунд	40Mb
 * Node JS 8.16	1 секунда	20Mb
 * Legend
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.
 * <p>
 * Желательно получить решение, которое не считывает входной файл целиком в память, т.е., использует лишь константный объем памяти в процессе работы.
 * <p>
 * Input format
 * Первая строка входного файла содержит единственное число n, n ≤ 1000000.
 * <p>
 * На следующих n строк расположены числа — элементы массива, по одному на строку. Числа отсортированы по неубыванию.
 * <p>
 * Output format
 * Выходной файл должен содержать следующие в порядке возрастания уникальные элементы входного массива.
 * <p>
 * Sample 1
 * Input
 * 5
 * 2
 * 4
 * 8
 * 8
 * 8
 * Output
 * 2
 * 4
 * 8
 * Sample 2
 * Input
 * 5
 * 2
 * 2
 * 2
 * 8
 * 8
 * Output
 * 2
 * 8
 */
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
