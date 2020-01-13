package cgproxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class TestCglib {
      
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/home/tic/java-workspace/javabase/target/classes");
        BookFacadeCglib cglib=new BookFacadeCglib();  
        BookFacade bookCglib=(BookFacade)cglib.getInstance(new BookFacade());
        bookCglib.addBook();
        bookCglib.hello();
    }  
} 