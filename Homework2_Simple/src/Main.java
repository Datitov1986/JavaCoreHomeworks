/**
 * Основной класс, реализующий несколько методов,
 * согласно заданию
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = {12, 4, 5, 10, 23, 45}; // создаю первый массив
        int[] arr2 = {3, 5, 7, 9, 11}; // создаю второй массив
        int[] arr3 = {0, 5, 0, 1, 2, 3, 4, 0, 0}; // создаю третий массив
        int[] arr4 = {0, 1, 2, 3, 4, 0, 5, 0}; // создаю четвертый массив
        System.out.printf("Разница между максимальным элементом (%d) " +
                        "и минимальным элементом (%d) равна %d\n",
                maxFind(arr), minFind(arr), delta(arr)); //Форматированный вывод разницы между максимальным и минимальным элементами массива
        System.out.printf("Разница между максимальным элементом (%d) " +
                        "и минимальным элементом (%d) равна %d\n",
                maxFind(arr2), minFind(arr2), delta(arr2)); //Форматированный вывод разницы между максимальным и минимальным элементами массива
        isEven(arr);
        isEven(arr2);
        //System.out.println(minFind(arr));
        //System.out.println(maxFind(arr));
        //System.out.println(maxFind(arr2));
        System.out.println(neighbor(arr4));
        System.out.println(neighbor(arr3));

    }

    /**
     * Метод для поиска и подсчета количества четных элементов массива
     *
     * @param arr в качестве аргумента подается массив
     */
    private static void isEven(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("Количество четных элементов массива = " + count);
    }

    /**
     * Метод поиска минимального элемента массива
     *
     * @param arr в качестве аргумента подается массив
     * @return возвращает минимальный элемент массива
     */
    private static int minFind(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Метод поиска максимального элемента массива
     *
     * @param arr в качестве аргумента подается массив
     * @return возвращает максимальный элемент массива
     */
    private static int maxFind(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Метод поиска разницы между максимальным и
     * минимальным элементами массива
     *
     * @param arr в качестве аргумента подается массив
     * @return возвращает разницу между элементами
     */
    private static int delta(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max - min;
    }

    /**
     * Метод возвращающий true в случае, если два соседних элемента нулевые
     * и false, в случае, если таких нет
     * @param arr в качестве аргумента подается массив
     * @return возвращает true или false
     */
    private static boolean neighbor(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }


}