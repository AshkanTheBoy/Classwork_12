package Class_2803.magicBoxBound;

public class BoundDemo {
    public static void main(String[] args) {
        MBBound<Animal> mbBound = new MBBound<>(new Cat());

        MBBound<? extends Bird> mbBound1 = new MBBound<>(new Bird());

        MBBound<? super Pigeon> mbBound2 = new MBBound<>(new WhitePigeon());

    }
}

class MBBound<T extends Animal>{

    private T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public MBBound(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}


