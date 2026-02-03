package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

// Service class with expensive computation
class MathService {

    @CacheResult
    public int slowSquare(int number) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;
    }
}

// Cache handler using reflection
class CacheExecutor {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object executeWithCache(
            Object target,
            String methodName,
            Class<?>[] paramTypes,
            Object[] args) throws Exception {

        Method method = target.getClass().getMethod(methodName, paramTypes);

        if (!method.isAnnotationPresent(CacheResult.class)) {
            return method.invoke(target, args);
        }

        String cacheKey = methodName + "_" + args[0];

        if (cache.containsKey(cacheKey)) {
            System.out.println("Returning cached result for input: " + args[0]);
            return cache.get(cacheKey);
        }

        System.out.println("Computing result for input: " + args[0]);
        Object result = method.invoke(target, args);
        cache.put(cacheKey, result);

        return result;
    }
}

// Test class
public class CacheResultAnnotationDemo {

    public static void main(String[] args) throws Exception {

        MathService service = new MathService();

        System.out.println(CacheExecutor.executeWithCache(
                service,
                "slowSquare",
                new Class[]{int.class},
                new Object[]{5}
        ));

        System.out.println(CacheExecutor.executeWithCache(
                service,
                "slowSquare",
                new Class[]{int.class},
                new Object[]{5}
        ));

        System.out.println(CacheExecutor.executeWithCache(
                service,
                "slowSquare",
                new Class[]{int.class},
                new Object[]{10}
        ));
    }
}
