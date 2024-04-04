package Class_0104.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book("NULLIFICATOR","N.Null",123,15);
        BookProcessor bookProcessor = new BookProcessor(book);
        //bookProcessor.checkFieldsNonNull();
        bookProcessor.print();
        //bookProcessor.checkForPositive();
    }
}

@BookAnnotation("short")
class Book{

    @NonNull
    public String title;
    @NonNull
    public String author;
    public int year;
    @IntPositive
    public int pages;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public void printShort(){
        System.out.println("Title: "+title+", author:"+author);
    }

    public void printLong(){
        System.out.println("Title: "+title+", author: "+author+ ", year: "+year);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface BookAnnotation{
    public String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NonNull{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface IntPositive{}



class BookProcessor{
    private Book book;

    public BookProcessor(Book book) {
        this.book = book;
    }

    public void print(){
        Class clazz = Book.class;
        Annotation bookAnnotation = clazz.getAnnotation(BookAnnotation.class);
        //System.out.println(bookAnnotation);
        if (checkForPositive()&checkFieldsNonNull()){
            if (bookAnnotation instanceof BookAnnotation){
                if (((BookAnnotation) bookAnnotation).value().equals("short")){
                    book.printShort();
                } else {
                    book.printLong();
                }
            }
        }
        //Annotation[] annotations = clazz.getAnnotations();
    }

    public boolean checkFieldsNonNull(){
        boolean result = true;
        Field[] fields = book.getClass().getDeclaredFields();
        for (Field field: fields){
            Annotation annotation = field.getAnnotation(NonNull.class);
            try {
                if (annotation!=null&&field.get(book)==null){
                    System.err.println("Field "+field.getName()+" cannot be null");
                    result = false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public boolean checkForPositive(){
        boolean result = true;
        Field[] fields = book.getClass().getDeclaredFields();
        for (Field field: fields){
            Annotation annotation = field.getAnnotation(IntPositive.class);
            try {
                if (annotation!=null&&((int)field.get(book))<0){
                    System.err.println("Field "+field.getName()+" cannot be negative");
                    result = false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}