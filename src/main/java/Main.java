import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, world.");
        Optional<String> property = Optional.ofNullable(System.getProperty("java.version"));
        System.out.println(property.orElse("not jdk8"));
    }
}
