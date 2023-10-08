import org.ignitescript.compiler.types.natives.IgnInteger;

public class Main {

    public static void main(String[] args) {
        IgnInteger i = new IgnInteger(10);
        System.out.println(i.getHash());
    }
}