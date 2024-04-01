package rest;

public class Array26 {
    public static void main(String[] args) {
//        Дан целочисленный массив размера N. Проверить, чередуются ли в
//
//        нем четные и нечетные числа. Если чередуются, то вывести 0, если нет,
//
//                то вывести порядковый номер первого элемента,
//                нарушающего закономерность

        int[] arr = {3, 4, 1, 6, 6, 8, 15, 22};
        boolean current;
        boolean prev =arr[0] % 2 == 0 ? true : false;
        int index =0;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i] % 2 == 0 ? true : false;
            if (prev == current) {
                index = i;
                break;
        }
            prev = current;
        }
        System.out.println(index);

        }
    }
