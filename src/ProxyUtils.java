import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyUtils implements InvocationHandler {
    private final Object original;
    private final Map<Integer, Integer> cache;

    public static Object makeCached(Object obj){
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new ProxyUtils(obj));
    }

    private ProxyUtils(Object original){
        this.original = original;
        this.cache = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int arg = (int)args[0];
        Integer result = cache.get(arg);
        if(result == null){
            result = (Integer) method.invoke(original, arg);
            cache.put(arg, result);
        }else {
            System.out.println("Value " + result + " is taken from cache");

        }

        return result;
    }
}
