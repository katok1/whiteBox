package org.example;

import org.testng.annotations.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    public App app = new App();

    @Test
    public void test1() {
        int x = 0;
        int y = 1;
        double expected = 0.0; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test2(){
        int x = 50;
        int y = 50;
        double expected = 50.0; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test3(){
        int x = 100;
        int y = 100;
        double expected = 100; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test4() {
        int x = -1;
        int y = 50;
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Проверяем, что результат является NaN
        assertTrue(Double.isNaN(actualValue));
    }


    @Test
    public void test5(){
        int x = 101;
        int y = 50;
        double expected = 71.063352; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test6(){
        int x = 50;
        int y = 0;
        double expected = 0.0; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test7(){
        int x = 50;
        int y = 101;
        double expected = 71.063352; // ожидаемое значение
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Сравниваем ожидаемое и фактическое с точностью до 0.01
        assertEquals(expected, actualValue, 0.01);
    }

    @Test
    public void test8(){
        int x = -1;
        int y = 0;
        double actualValue = app.test(x, y); // фактическое, полученное методом

        // Проверяем, что результат является NaN
        assertTrue(Double.isNaN(actualValue));
    }

    // Тест для метода test с положительными числами
    @Test
    public void test_PositiveNumbers() {
        // Должен вернуть квадратный корень из произведения 4 и 9 (т.е. 6.0)
        double result = app.test(4, 9);
        assertEquals(6.0, result, 0.001, "Ожидаемое значение 6.0");
    }

    // Тест для метода test с отрицательным числом (ожидаем NaN)
    @Test
    public void test_NegativeNumbers() {
        // Должен вернуть NaN, так как одно из чисел отрицательное
        double result = app.test(-4, 9);
        assertTrue(Double.isNaN(result), "Ожидаемое значение NaN");
    }

    // Тест для метода getX с корректным вводом
    @Test
    public void testGetX_ValidInput() {
        // Подготавливаем ввод "50\n" (в пределах 1-100)
        String input = "50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int x = app.getX();
        assertEquals(50, x, "Ожидаемое значение x = 50");
    }

    // Тест для метода getX с некорректным вводом (за пределами 1-100)
    @Test
    public void testGetX_InvalidInput() {
        // Подготавливаем ввод "150\n50\n" (150 некорректно, затем корректное 50)
        String input = "150\n50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int x = app.getX();
        assertEquals(50, x, "Ожидаемое значение x = 50 после повторного ввода");
    }

    // Тест для метода getY с корректным вводом
    @Test
    public void testGetY_ValidInput() {
        // Подготавливаем ввод "30\n" (в пределах 0-100)
        String input = "30\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int y = app.getY();
        assertEquals(30, y, "Ожидаемое значение y = 30");
    }

    // Тест для метода getY с некорректным вводом (за пределами 0-100)
    @Test
    public void testGetY_InvalidInput() {
        // Подготавливаем ввод "150\n30\n" (150 некорректно, затем корректное 30)
        String input = "150\n30\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int y = app.getY();
        assertEquals(30, y, "Ожидаемое значение y = 30 после повторного ввода");
    }

    // Тест для метода printRez с проверкой вывода в консоль
    @Test
    public void testPrintRez() {
        // Подготавливаем захват консольного вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Входные значения x и y
        int x = 4;
        int y = 9;

        // Вызываем метод
        app.printRez(x, y);

        // Проверяем, что вывод в консоль соответствует ожиданию
        String expectedOutput = "Результат вычисления равен 6.0";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim(), "Ожидаемый вывод: " + expectedOutput);
    }

    // Интеграционный тест для метода main
    @Test
    public void testMainMethod() {
        // Подготавливаем входные данные для x и y
        String input = "4\n9\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Подготавливаем захват вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Запускаем main как основную точку программы
        App.main(new String[]{});

        // Проверяем, что вывод соответствует ожидаемому результату
        String expectedOutput = "Введите x:\nВведите y:\nРезультат вычисления равен 6.0";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim(), "Ожидаемый вывод программы в main");
    }

}


