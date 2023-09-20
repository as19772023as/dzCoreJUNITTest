package ru.strebkov;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Разные тесты:")
class MainTest {

    private static Main main;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Start Test !  Начало теста\n");
        main = new Main();
    }

    @AfterEach
    void tearDown() {
        System.out.println("END Test !  Конец теста\n");
    }


    @DisplayName("Проверка рекурсии  на true")
    @Test
    void canTest() {
        // готовим данные
        final var sum = 17;

        // ожидаемый результат
        final boolean expected = true;

        //актуальный результат
        final boolean actual = main.can(sum);
        assertEquals(expected, actual);
        System.out.println(expected + "==" + actual);
    }


    @DisplayName("Проверка рекурсии  на false")
    @Test
    void canTestFalse() {
        // готовим данные
        final var sum = 2;

        // ожидаемый результат
        final boolean expected = false;

        //актуальный результат
        final boolean actual = main.can(sum);
        assertEquals(expected, actual);
        System.out.println(expected + "==" + actual);
    }


    @DisplayName("Проверка на массивах")
    @Test
    void findToSumInArray() {
        final int[] array = {5, 1, 3, 2, 7};
        final var sum = 10;

        final int[] expected = {3, 7};

        final int[] actual = main.findToSum(array, sum);
        assertArrayEquals(expected, actual);
    }


    @DisplayName("Проверка на - 0")
    @Test
    void findToSumInArray0() {
        final int[] array = {};
        final var sum = 0;

        final int[] expected = {};

        final int[] actual = main.findToSum(array, sum);
        assertArrayEquals(expected, actual);
    }


    @DisplayName("Проверка на не совпадение")
    @Test
    void findToSumInArrayFalse() {
        final int[] array = {5, 1, 3, 2, 7};
        final var sum = 20;

        final int[] expected = {};

        final int[] actual = main.findToSum(array, sum);
        assertArrayEquals(expected, actual);
    }


    @DisplayName("Проверка на массивах с Hamcrest")
    @Test
    void findToSumInArrayHamcrest() {
        final int[] array = {5, 1, 3, 2, 7};
        final var sum = 10;

        final int[] actual = main.findToSum(array, sum);

        assertThat(actual, is(new Integer[]{3, 7}));
    }


    @DisplayName("Проверка с Hamcrest")
    @Test
    public void given2Strings_whenEqual_thenCorrect() {
        String a = "Petya";
        String b = "petya";
        assertThat(a, equalToIgnoringCase(b));
    }


    @DisplayName("Проверка с Hamcrest")
    @Test
    public void givenArray_whenCheck_thenSize3() {
        Integer[] array = new Integer[]{5, 2, 4};
        assertThat(array, arrayWithSize(3));
    }
}