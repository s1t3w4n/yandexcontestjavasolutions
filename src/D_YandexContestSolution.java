import java.io.*;

/**
 * D. Генерация скобочных последовательностей
 * Ограничение времени	1 секунда
 * Ограничение памяти	20Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n, упорядоченные лексикографически (см. <a href="https://ru.wikipedia.org/wiki/">...</a>Лексикографический_порядок).
 * <p>
 * В задаче используются только круглые скобки.
 * <p>
 * Желательно получить решение, которое работает за время, пропорциональное общему количеству правильных скобочных последовательностей в ответе, и при этом использует объём памяти, пропорциональный n.
 * <p>
 * Формат ввода
 * Единственная строка входного файла содержит целое число n, 0 ≤ n ≤ 11
 * <p>
 * Формат вывода
 * Выходной файл содержит сгенерированные правильные скобочные последовательности, упорядоченные лексикографически.
 * <p>
 * Пример 1
 * Ввод
 * 2
 * Вывод
 * (())
 * ()()
 * <p>
 * Пример 2
 * Ввод
 * 3
 * Вывод
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
public class D_YandexContestSolution {
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

    private static int readLine() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static void writeLine(char[] IntToFile) throws IOException {
        bufferedWriter.write(IntToFile);
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {
        int n = readLine();
        generate(n, 0, 0, new char[2 * n], 0);
    }

    private static void generate(int n, int open, int close, char[] current, int pos) throws IOException {
        if (pos == 2 * n) {
            writeLine(current);
            return;
        }

        if (open < n) {
            current[pos] = '(';
            generate(n, open + 1, close, current, pos + 1);
        }

        if (close < open) {
            current[pos] = ')';
            generate(n, open, close + 1, current, pos + 1);
        }
    }
}
