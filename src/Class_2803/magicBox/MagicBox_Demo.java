package Class_2803.magicBox;

public class MagicBox_Demo {
    public static void main(String[] args) {
        MagicBox magicBox = new MagicBox();
        //magicBox.setObject(1);
        //magicBox.setObject(LocalDate.now());
        //magicBox.setObject(new ArrayList<>(Arrays.asList("123","345")));
//        magicBox.setObject(new MagicBox());
//        System.out.println(magicBox.getObject());
//
//        Object object = magicBox.getObject();
//
//        Class clazz = object.getClass();
//        System.out.println(object.getClass());
//        System.out.println(clazz);

        MagicBoxGeneric<Number> magicBoxGeneric = new MagicBoxGeneric<>();
        magicBoxGeneric.setObject(1);
        System.out.println(magicBoxGeneric.getObject());

        MagicBoxGeneric<MagicBoxGeneric<Integer>> magicBoxGeneric2 = new MagicBoxGeneric<>();
        magicBoxGeneric2.setObject(new MagicBoxGeneric<>());
        magicBoxGeneric2.getObject().setObject(1);
        System.out.println(magicBoxGeneric2.getObject().getObject());

    }
}

class MagicBox{
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MagicBox{" +
                "object=" + object +
                '}';
    }
}

class MagicBoxGeneric<T>{
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
