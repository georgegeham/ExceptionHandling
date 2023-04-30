package Src;

public class NotVaildAutosarFileException extends Exception {
    public NotVaildAutosarFileException(String m) {
        super("File Not Found");
        System.out.println(m);
    }
}
