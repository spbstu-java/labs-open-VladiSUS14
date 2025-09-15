import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class MethodInvoker {

    public static void invokeAnnotatedMethods(Object target) {
        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RepeatableMethod.class)) {
                RepeatableMethod annotation = method.getAnnotation(RepeatableMethod.class);
                int repeatCount = annotation.value();

                // Делаем метод доступным, если он приватный или защищенный
                method.setAccessible(true);

                System.out.println("\nCalling method: " + method.getName() +
                        ", repeat count: " + repeatCount);

                // Вызываем метод указанное количество раз
                for (int i = 0; i < repeatCount; i++) {
                    try {
                        System.out.print("Call " + (i + 1) + ": ");

                        // Создаем параметры по умолчанию на основе типов параметров метода
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        Object[] parameters = createDefaultParameters(parameterTypes);

                        // Вызываем метод
                        Object result = method.invoke(target, parameters);

                        if (result != null) {
                            System.out.println("Returned: " + result);
                        }

                    } catch (IllegalAccessException e) {
                        System.err.println("Error calling method " + method.getName() + ": " +
                                e.getMessage());
                    }
                    catch (IllegalArgumentException e) {
                        System.err.println("Error calling method " + method.getName() + ": " +
                                e.getMessage());
                    }
                    catch (InvocationTargetException e) {
                        System.err.println("Error calling method " + method.getName() + ": " +
                                e.getMessage());
                    }
                }
            }
        }
    }

    private static Object[] createDefaultParameters(Class<?>[] parameterTypes) {
        Object[] parameters = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = getDefaultValue(parameterTypes[i]);
        }

        return parameters;
    }

    private static Object getDefaultValue(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return 0;
        } else if (type == double.class || type == Double.class) {
            return 0.0;
        } else if (type == boolean.class || type == Boolean.class) {
            return false;
        } else if (type == char.class || type == Character.class) {
            return ' ';
        } else if (type == String.class) {
            return "default";
        } else if (type == long.class || type == Long.class) {
            return 0L;
        } else if (type == float.class || type == Float.class) {
            return 0.0f;
        } else {
            // Для неизвестных типов возвращаем null
            return null;
        }
    }
}