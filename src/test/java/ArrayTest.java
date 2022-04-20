import src.main.HomeWorkLesson3.HomeWorkLesson3;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

class ArrayTest {
    private HomeWorkLesson3 hm;
    int [] array6 = {2, 2, 2, 1, 2, 2, 10, 1};

    int [] arrayForTest = {2, 2, 10, 1, 2, 2, 2, 1};
    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
        hm = new HomeWorkLesson3 ();
    }

    @AfterEach
    void shutdown() {
        System.out.println("тест завершается");
    }

    @BeforeAll
    static void mainStart() {
        System.out.println("MAIN START");
    }

    @AfterAll
    static void mainEnd() {
        System.out.println("MAIN END");
    }

    @DisplayName("Проверка равенства частей массива")
    @Test
    void testAdd1() {
        Assertions.assertTrue (hm.returnIsSumOfLeftAndRightEqual(array6));
    }

    @DisplayName("Проверка свига массива")
    @Test
    void testSliceIndexes() {
        Assertions.assertEquals (Arrays.toString (arrayForTest), Arrays.toString (hm.sliceIndexes (array6, 4)));
    }
}
