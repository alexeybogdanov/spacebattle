import java.util.HashMap;
import java.util.Map;

public class IoC {

    static Map<String, Object> context = new HashMap();
    static Map<String, String> internalNameToClass = Map.of(
            "move-command", "Move"
    );



    static <T> T resolve(String key, Object ...params) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Register:
        if ("IoC.Register".equals(key)) {
          if (params.length == 1) {
              String internalName = (String) params[0];
              String className = internalNameToClass.get(internalName);
              return (T) Class.forName(className).newInstance(); }

            if (params.length > 1) {
                String internalName = (String) params[0];
                Movable param = (Movable) params[1];
                internalNameToClass.get(internalName);
                // some how inject it
            }
        }

        // Resolve
        if ("IoC.Resolve".equals(key)) {

            // return bean from context
        }

        throw new RuntimeException("Missing key: " + key);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object resolve = IoC.resolve("IoC.Register", "move-command");
        System.out.println("created class details: " +  resolve.getClass());
    }
}
