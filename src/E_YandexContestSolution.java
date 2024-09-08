import java.io.*;

/**
 * E. Анаграммы
 * Ограничение времени	1 секунда
 * Ограничение памяти	20Mb
 * Ввод	стандартный ввод или input.txt
 * Вывод	стандартный вывод или output.txt
 * Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами, т. е. отличаются ли они только порядком следования символов.
 * <p>
 * Формат ввода
 * Входной файл содержит две строки строчных латинских символов, каждая не длиннее 100 000 символов. Строки разделяются символом перевода строки.
 * <p>
 * Формат вывода
 * Выходной файл должен содержать единицу, если строки являются анаграммами, и ноль в противном случае.
 * <p>
 * Пример 1
 * Ввод
 * qiu
 * iuq
 * Вывод
 * 1
 * Пример 2
 * Ввод
 * zprl
 * zprc
 * Вывод
 * 0
 */
public class E_YandexContestSolution {
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
        final String s1 = readLine();
        final String s2 = readLine();
        if (s1.length() != s2.length()) {
            writeLine("0");
            return;
        }
        final int reduce1 = s1.chars().reduce(0, (i, c) -> i ^= (1 << (c - 'a')));
        final int reduce2 = s2.chars().reduce(0, (i, c) -> i ^= (1 << (c - 'a')));
        writeLine(reduce1 == reduce2 ? "1" : "0");
    }
}
