package cn.donting.web.os.desktop;

import cn.hutool.core.util.ClassUtil;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TsApiCreat {
    public static void main(String[] args) {

        Set<Class<?>> classes = ClassUtil.scanPackage(WebOsDesktopApplication.class.getPackage().getName());
        for (Class<?> aClass : classes) {
            RestController restController = aClass.getAnnotation(RestController.class);
            if (restController != null) {
                RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
                String[] baseUrl = new String[]{};
                if (requestMapping != null) {
                    baseUrl = requestMapping.path();
                }
                Method[] declaredMethods = aClass.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (method.getAnnotation(GetMapping.class) != null) {
                        GetMapping annotation = method.getAnnotation(GetMapping.class);
                        String[] path = annotation.path();
                        apiMethod(aClass, method, baseUrl, baseUrl);
                    } else if (method.getAnnotation(PostMapping.class) != null) {

                    }
                    if (method.getAnnotation(DeleteMapping.class) != null) {

                    }
                }
            }
        }
    }

    public static void apiMethod(Class aClass, Method method, String[] baseUrls, String[] urls) {
        List<String> url = new ArrayList<>();
        for (String baseUrl : baseUrls) {
            for (String s : urls) {
                url.add(baseUrl + s);
            }
        }
        Type genericReturnType = method.getGenericReturnType();
        List<Class> parClass=new ArrayList<>();
        getType(genericReturnType,parClass);

    }


    public static void getType(Type type,List<Class> parClass) {
        if (type instanceof ParameterizedType) {
            // 如果要使用ParameterizedType中的方法，必须先强制向下转型
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType());
            parClass.add((Class) parameterizedType.getRawType());
            // 获取返回值类型中的泛型类型，因为可能有多个泛型类型，所以返回一个数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length>1) {
                throw new RuntimeException("不支持两个以上的泛型");
            }
            getType(actualTypeArguments[0],parClass);

        }
        if(type instanceof Class){
            System.out.println(type);
            parClass.add((Class) type);
        }
    }
}
