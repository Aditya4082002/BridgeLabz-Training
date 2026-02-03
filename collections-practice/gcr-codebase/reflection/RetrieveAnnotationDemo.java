package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Class annotated with @Author
@Author(name = "Author Name")
class Book {
    public void display() {
        System.out.println("Book class");
    }
}

// Reflection demo
public class RetrieveAnnotationDemo {

    public static void main(String[] args) {

        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}

