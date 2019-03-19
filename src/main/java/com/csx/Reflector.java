package com.csx;

import com.csx.invoker.Invoker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-03-19
 */
public class Reflector {
    /**
     * 对应的类
     */
    private final Class<?> type;

    /**
     * 可读属性数组
     */
    private final String[] readablePropertyNames;

    /**
     * 可写属性数组
     */
    private final String[] writablePropertyNames;

    /**
     * 属性对应的 setting 方法的映射。
     *
     * key 为属性名称
     * value 为 Invoker 对象
     */
    private final Map<String, Invoker> setMethods = new HashMap<String, Invoker>();

    /**
     * 属性对应的 getting 方法的映射
     *
     * key 为属性名称
     * value 为 Invoker 对象
     */
    private final Map<String, Invoker> getMethods = new HashMap<String, Invoker>();

    /**
     * 属性对应的 setting 方法的方法参数类型的映射
     *
     * key 为属性名称
     * value 为方法参数类型
     */
    private final Map<String, Class<?>> setTypes = new HashMap<String, Class<?>>();

    /**
     * 属性对应的 getting 方法的返回值类型的映射
     *
     * key 为属性名称
     * value 为返回值的类型
     */
    private final Map<String, Class<?>> getTypes = new HashMap<String, Class<?>>();

    /**
     * 默认构造方法
     */
    private Constructor<?> defaultConstructor;

    /**
     * 不区分大小写的属性集合
     */
    private Map<String, String> caseInsensitivePropertyMap = new HashMap<String, String>();

    public Reflector(Class<?> clazz) {
        // 设置对应的类
        type = clazz;
        // 添加默认的构造方法
        addDefaultConstructor(clazz);
        readablePropertyNames = null;
        writablePropertyNames = null;



    }

    /**
     * 添加默认的构造方法
     * @param clazz
     */
    private void addDefaultConstructor(Class<?> clazz) {
        Constructor<?>[] consts = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : consts) {
            // 判断构造方法是否为0，为0即为默认构造方法
            if (constructor.getParameterTypes().length == 0) {
                this.defaultConstructor = constructor;
            }
        }
    }

    private void addGetMethods(Class<?> cls) {
        Map<String, List<Method>> conflictingGetters = new HashMap<>();
        Method[] methods = null;
    }

    private Method[] getClassMethods(Class<?> cls) {
        // 每个方法签名与该方法的映射
        Map<String, Method> uniqueMethods = new HashMap<>();
        // 循环类，类的父类，类的父类的父类，直到父类为object
        Class<?> currentClass = cls;
        while (currentClass != null && currentClass != Object.class) {

        }
        return null;
    }

    private void addUniqueMethods(Map<String, Method> uniqueMethods, Method[] methods) {
        for (Method currentMethod : methods) {
            if (!currentMethod.isBridge()) {

            }
        }
    }

    /**
     * 获得签名方法
     * @param method
     * @return
     */
    private String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        // 返回类型
        Class<?> returnType = method.getReturnType();
        if (returnType != null) {
            sb.append(returnType.getName()).append('#');
        }
        // 方法名
        sb.append(method.getName());
        // 方法参数
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            if (i == 0) {
                sb.append(':');
            } else {
                sb.append(',');
            }
        }
        return "";
    }


}
