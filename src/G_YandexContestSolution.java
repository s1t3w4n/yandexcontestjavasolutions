import java.io.*;
import java.util.*;

/**
 * G. Интересное путешествие
 * Ограничение времени	1 секунда
 * Ограничение памяти	64Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Не секрет, что некоторые программисты очень любят путешествовать. Хорошо всем известный программист Петя тоже очень любит путешествовать, посещать музеи и осматривать достопримечательности других городов.
 * Для перемещений между из города в город он предпочитает использовать машину. При этом он заправляется только на станциях в городах, но не на станциях по пути. Поэтому он очень аккуратно выбирает маршруты, чтобы машина не заглохла в дороге. А ещё Петя очень важный член команды, поэтому он не может себе позволить путешествовать слишком долго. Он решил написать программу, которая поможет ему с выбором очередного путешествия. Но так как сейчас у него слишком много других задач, он попросил вас помочь ему.
 * Расстояние между двумя городами считается как сумма модулей разности по каждой из координат. Дороги есть между всеми парами городов.
 * <p>
 * Формат ввода
 * В первой строке входных данных записано количество городов
 * n * ( 2 * ≤ * n * ≤ * 1 * 0 * 0 * 0* ). В следующих * n * строках даны два целых числа: координаты каждого города, не превосходящие по модулю миллиарда. Все города пронумерованы числами от 1 до * n
 * в порядке записи во входных данных.
 * В следующей строке записано целое положительное число
 * k
 * , не превосходящее двух миллиардов, — максимальное расстояние между городами, которое Петя может преодолеть без дозаправки машины.
 * В последней строке записаны два различных числа — номер города, откуда едет Петя, и номер города, куда он едет.
 * <p>
 * Формат вывода
 * Если существуют пути, удовлетворяющие описанным выше условиям, то выведите минимальное количество дорог, которое нужно проехать, чтобы попасть из начальной точки маршрута в конечную. Если пути не существует, выведите -1.
 * Пример 1
 * Ввод
 * 7
 * 0 0
 * 0 2
 * 2 2
 * 0 -2
 * 2 -2
 * 2 -1
 * 2 1
 * 2
 * 1 3
 * Вывод
 * 2
 * Пример 2
 * Ввод
 * 4
 * 0 0
 * 1 0
 * 0 1
 * 1 1
 * 2
 * 1 4
 * Вывод
 * 1
 * Пример 3
 * Ввод
 * 4
 * 0 0
 * 2 0
 * 0 2
 * 2 2
 * 1
 * 1 4
 * Вывод
 * -1
 */
public class G_YandexContestSolution {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    private static void writeLine(String write) throws IOException {
        bufferedWriter.write(write);
    }

    private static void run() throws IOException {
        int c = Integer.parseInt(readLine()); //  количество городов
        int[][] cities = new int[c][2]; // координаты городов
        for (int i = 0; i < c; i++) {
            final String[] split = readLine().split(" ");
            cities[i] = new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        }
        int k = Integer.parseInt(readLine());
        final String[] split = readLine().split(" ");
        int start = Integer.parseInt(split[0]) - 1; // город, откуда едет Петя (нумерация с 0)
        int end = Integer.parseInt(split[1]) - 1;   // город, куда едет Петя (нумерация с 0)

        int n = cities.length; // количество городов

        // Построение графа
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Заполнение графа, добавляем ребра между городами, расстояние между которыми <= k
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (manhattanDistance(cities[i], cities[j]) <= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // Поиск кратчайшего пути
        int result = bfs(graph, start, end, n);

        // Вывод результата
        writeLine(Integer.toString(result));
    }

    // Функция для вычисления расстояния Манхэттена
    static long manhattanDistance(int[] city1, int[] city2) {
        return (long) Math.abs(city1[0] - city2[0]) + (long) Math.abs(city1[1] - city2[1]);
    }

    // BFS для поиска кратчайшего пути
    static int bfs(List<List<Integer>> graph, int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return distances[current];
            }

            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // если город еще не посещен
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return -1; // если пути нет
    }
}
