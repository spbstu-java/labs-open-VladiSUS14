public class AnnotatedClass {

    // Публичные методы
    public void publicMethod1(String text) {
        System.out.println("Public method 1 called with: " + text);
    }

    public int publicMethod2(int a, int b) {
        int result = a + b;
        System.out.println("Public method 2: " + a + " + " + b + " = " + result);
        return result;
    }

    // Защищенные методы
    @RepeatableMethod(3)
    protected void protectedMethod1(String name, int age) {
        System.out.println("Protected method 1: " + name + ", age: " + age);
    }

    @RepeatableMethod(2)
    protected double protectedMethod2(double x, double y) {
        double result = x * y;
        System.out.println("Protected method 2: " + x + " * " + y + " = " + result);
        return result;
    }

    // Приватные методы
    @RepeatableMethod(4)
    private void privateMethod1() {
        System.out.println("Private method 1 called (no parameters)");
    }

    @RepeatableMethod(1)
    private String privateMethod2(String a, String b, String c) {
        String result = a + " " + b + " " + c;
        System.out.println("Private method 2: " + result);
        return result;
    }

    // Еще один приватный метод без аннотации
    private void privateMethod3() {
        System.out.println("This method won't be called");
    }
}