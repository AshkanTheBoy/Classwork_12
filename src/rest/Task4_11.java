package rest;

public class Task4_11 {
    public static void main(String[] args) {
        int[] arr = {5, 13, 19, 7, 19, 13, 5};

//        System.out.println(isPrime(13));
//        System.out.println(allIsPrime(arr));
        //       System.out.println(isSymmetric(arr));
        System.out.println(allIsPrime(arr) && isSymmetric(arr));
    }

    static boolean isPrime(int n) {
        // boolean flag = true; //Предполагаем, что число n - простое
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

//    static boolean allIsPrime(int[] arr) {
//        for (int n : arr)
//            if (!isPrime(n)) return false;
//        return true;// for each
//    }
    static boolean allIsPrime(int[] arr) {
        for (int i=0;i<arr.length;i++)
            if (!isPrime(arr[i])) return false;
        return true;// for each
    }


    static boolean isSymmetric(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++)
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        return true;
    }
}

