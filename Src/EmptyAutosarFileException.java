package Src;

public class EmptyAutosarFileException extends Exception {
    public EmptyAutosarFileException(String m) {
        super("File is Empty");
        System.out.println(m);
    }
}
