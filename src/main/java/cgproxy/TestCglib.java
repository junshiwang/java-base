package cgproxy;

public class TestCglib {
      
    public static void main(String[] args) {  
        BookFacadeCglib cglib=new BookFacadeCglib();  
        BookFacade bookCglib=(BookFacade)cglib.getInstance(new BookFacade());
        bookCglib.addBook();
        bookCglib.hello();
    }  
} 