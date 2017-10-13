import com.sun.org.apache.bcel.internal.generic.ArrayType;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 13.10.2017.
 */
public class BeanUnits {
    public static void assign (Object to, Object from) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<Method> methodsTo = new ArrayList<>();
        List<Method> methodsFrom = new ArrayList<>();
        Class<?> tClass = to.getClass();
        Class<?> fClass = from.getClass();


        for (Method methodF : fClass.getMethods()) {
            if (methodF.getName().contains("get") || methodF.getName().contains("is") & methodF.getParameterCount()==0) {
                for (Method methodT : tClass.getMethods()) {
                    if(methodT.getName().contains("set") & methodT.getReturnType()==void.class & methodT.getParameterCount()==1 ) {
                        if(methodF.getReturnType()==methodT.getParameterTypes()[0] || methodF.getReturnType().isAssignableFrom(methodT.getParameterTypes()[0])){
                            methodT.invoke(to,methodF.invoke(from));
                        }
                    }

                }
            }
        }


    }

}
