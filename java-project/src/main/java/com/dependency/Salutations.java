package main.java.com.dependency;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;


public class Salutations {
    
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();


        String user = textIO.newStringInputReader()
            .withDefaultValue("admin")
            .read("Username");
        


        String password = textIO.newStringInputReader()
            .withMinLength(6)
            .withInputMasking(true)
            .read("Password");
        System.out.println("Hello, " + user + "! Your password is: " + password);
    }
}
