import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyObjectCollectionTest {

    private MyObjectCollection objectCollection = new MyObjectCollection();
    private final MyObjectCollection testComparison = new MyObjectCollection();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 5; i++) {
            objectCollection.add(Integer.toString(i));
        }
    }

    @AfterEach
    void successfulOutput() {
        objectCollection = new MyObjectCollection();
    }


    @Test
    void add() {

        /* 1. добавляется ли объект в конец списка
           2. увеличивается ли count на единицу */

        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testObject));
        Assertions.assertEquals(6, objectCollection.size()); // count увеличился на единицу
        Assertions.assertEquals(testObject, objectCollection.get(5)); // элемент 6 в конце списка

    }

    @Test
    void addNegative() {

        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add("7"));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertNotEquals(testObject, objectCollection.get(5));

    }

    @Test
    void addByIndex() {
        /* проверить добавляется ли элемент по индексу, изменяется ли индекс и добавляется ли элемент в массив */

        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(5, testObject));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertEquals(testObject, objectCollection.get(5));

    }

    @Test
    void addByIndexNegative() {

        String testObject = "6";
        int testIndex = 8;

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertFalse(objectCollection.add(testIndex, testObject));
    }

    @Test
    void delete() {

        /* 1. существует ли элемент в списке (пройтись по списку и найти элемент)
           2. проверить уменьшается ли count на единицу при удалении */

        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testObject));
        Assertions.assertEquals(6, objectCollection.size());

        Assertions.assertTrue(objectCollection.delete(testObject));
        Assertions.assertEquals(5, objectCollection.size());
    }

    @Test
    void deleteNegative() {

        String testObject = "7";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add("6"));
        Assertions.assertEquals(6, objectCollection.size());

        try {
            Assertions.assertTrue(objectCollection.delete(testObject));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        Assertions.assertNotEquals(5, objectCollection.size());
    }

    @Test
    void deleteByIndex() {

        /* 1. существует ли элемент в списке
           2. проверить уменьшается ли count на единицу */
        int testIndex = 5;
        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testObject));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertEquals(testObject, objectCollection.get(testIndex));

        Assertions.assertTrue(objectCollection.delete(testIndex));
        Assertions.assertEquals(5, objectCollection.size());

    }

    @Test
    void deleteByIndexNegative() {

        int testIndex = 6;
        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testObject));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertTrue(objectCollection.contain(testObject));

        Assertions.assertTrue(objectCollection.delete(testIndex));
        Assertions.assertEquals(5, objectCollection.size());

    }

    @Test
    void get() {

        /* проверить существует ли элемент */
        int testIndex = 5;
        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testIndex,testObject));
        Assertions.assertEquals(6, objectCollection.size());

        Assertions.assertEquals(testObject, objectCollection.get(testIndex));

    }

    @Test
    void getNegative() {

        int testIndex = 5;
        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testIndex,testObject));
        Assertions.assertEquals(6, objectCollection.size());

        Assertions.assertNotEquals(testObject, objectCollection.get(6));

    }

    @Test
    void contain() {

        /* проверить существует ли элемент в списке */

        String testObject = "6";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add(testObject));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertTrue(objectCollection.contain(testObject));
    }

    @Test
    void containNegative() {

        String testObject = "7";

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.add("6"));
        Assertions.assertEquals(6, objectCollection.size());
        Assertions.assertFalse(objectCollection.contain(testObject));

    }

    @Test
    void testEquals() {

        Assertions.assertEquals(0, testComparison.size());
        for (int i = 1; i <= 5; i++) testComparison.add(Integer.toString(i));
        Assertions.assertEquals(5, testComparison.size());

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.equals(testComparison));

    }

    @Test
    void testEqualsNegative() {

        Assertions.assertEquals(0, testComparison.size());
        for (int i = 0; i < 6; i++) Assertions.assertTrue(testComparison.add(Integer.toString(i)));
        Assertions.assertEquals(6, testComparison.size());

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertFalse(objectCollection.equals(testComparison));

    }

    @Test
    void clear() {

        /* проверить приравнивается ли count к нулю */

        Assertions.assertEquals(5, objectCollection.size());
        Assertions.assertTrue(objectCollection.clear());
        Assertions.assertEquals(0, objectCollection.size());

    }

    @Test
    void size() {

        /* проверить совпадает ли размер списка при добавлении элементов */

        Assertions.assertEquals(5, objectCollection.size());
    }
}