public class Main {
    public static void main(String[] args) {
        AnnotatedClass annotatedClass = new AnnotatedClass();

        System.out.println("=== Invoking annotated methods ===");
        MethodInvoker.invokeAnnotatedMethods(annotatedClass);

        System.out.println("\n=== Direct public method calls ===");
        // Публичные методы можно вызывать напрямую
        annotatedClass.publicMethod1("Hello");
        annotatedClass.publicMethod2(5, 3);
    }
}