package Class_2103;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {
    public static void main(String[] args) {
        IntStream.range(1,10).forEach(System.out::println);

        int[] arr = IntStream.range(1,10).toArray();
        System.out.println(Arrays.toString(arr));

        int sum = IntStream.range(1,10).reduce(0,(a,b)->a+b);
        System.out.println(sum);

        Random random = new Random();
        int[] count = IntStream.generate(()-> random.nextInt(100))
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(count));

        String str = Arrays.stream(count)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(str);

        String str2 = Arrays.stream(count)
                .filter(i->i%2==0)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(str2);

        IntStream.range(1,1001)
                .filter(i->i%3==0&&i%5==0&&i%11==0)
                .forEach(System.out::print);
        System.out.println();

        int n = 10;
        IntStream.range(1,n+1)
                .map(i->i*i)
                .forEach(System.out::print);
        System.out.println();

        IntStream.range(1,n+1)
                .map(i->(int)Math.pow(2,i))
                .forEach(System.out::print);
        System.out.println();

        IntStream.iterate(2,i->i*2)
                .limit(n)
                .forEach(System.out::print);
        System.out.println();

        Stream.iterate(new int[]{1,1},x->new int[]{++x[0],x[1]=sum(Integer.toString(x[0]).chars().toArray())})
                .filter(x->x[1]==20)
                .limit(1)
                .forEach(x-> System.out.println(x[0]));
    }

    private static int sum(int[] array) {
        int result = 0;
        for (int a: array){
            result+= a - '0';
        }
        return result;
    }
}
