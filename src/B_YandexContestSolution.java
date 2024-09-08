import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * B. Последовательно идущие единицы
 * Ограничение времени	1 секунда
 * Ограничение памяти	64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 * <p>
 * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 * <p>
 * Формат ввода
 * Первая строка входного файла содержит одно число n, n ≤ 10000. Каждая из следующих n строк содержит ровно одно число — очередной элемент массива.
 * <p>
 * Формат вывода
 * Выходной файл должен содержать единственное число — длину самой длинной последовательности единиц во входном массиве.
 * <p>
 * Пример
 * Ввод
 * 5
 * 1
 * 0
 * 1
 * 0
 * 1
 * Вывод
 * 1
 */
public class B_YandexContestSolution {
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        final List<String> collect = r.lines().collect(Collectors.toList());
        collect.remove(0);
        int maxCount = 0;
        int currentCount = 0;

        for (String s : collect) {
            if (s.trim().equals("1")) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
        }
        System.out.println(Math.max(currentCount, maxCount));
    }
}
