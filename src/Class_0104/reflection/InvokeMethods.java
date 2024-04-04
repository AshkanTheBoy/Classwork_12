package Class_0104.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethods {
    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new SecurityManager());

            Method sum = Calc.class.getMethod("sum",int.class,double.class);
            Calc calc = new Calc();
            double res = (double)sum.invoke(calc,1,2);
            System.out.println(res);

            Method mult = Calc.class.getMethod("mult",float.class,long.class);
            double res2 = (double)mult.invoke(null,2.5f,3);
            System.out.println(res2);

            Method and = Calc.class.getDeclaredMethod("and",boolean.class,boolean.class);
            and.setAccessible(true);
            boolean res3 = (boolean)and.invoke(calc,true,true);
            System.out.println(res3);

            Method max = Calc.class.getDeclaredMethod("max",int.class,int.class);
            max.setAccessible(true);
            int res4 = (int)max.invoke(max,5,9);
            System.out.println(res4);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

//Класс, в котором содержатся методы с различным доступом и аргументами
class Calc{

    public double sum(int a, double b) {
        return a + b;
    }

    public static double mult(float a, long b) {
        return a * b;
    }

    private boolean and(boolean a, boolean b) {
        return a && b;
    }

    protected int max(int a, int b) {
        return a > b ? a : b;
    }
}
