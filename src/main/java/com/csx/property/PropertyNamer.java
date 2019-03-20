package com.csx.property;

import com.csx.ReflectionException;

import java.util.Locale;

/**
 * @author csx
 * @Package com.csx.property
 * @Description: TODO
 * @date 2019/3/20 0020
 */
public final class PropertyNamer {

    private static final String GET = "get";
    private static final String SET = "set";
    private static final String IS = "is";
    private PropertyNamer() {

    }

    public static String methodToProperty(String name) {
        if (name.startsWith(IS)) {
            name = name.substring(2);
        } else if (name.startsWith(GET) || name.startsWith(SET)) {
            name = name.substring(3);
        } else {
            throw new ReflectionException("Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }

        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
        }
        return name;
    }

    public static boolean isProperty(String name) {
        return name.startsWith(GET) || name.startsWith(SET) || name.startsWith(IS);
    }

    public static boolean isSetter(String name) {
        return name.startsWith(SET);
    }

    public static boolean isGetter(String name) {
        return name.startsWith(GET) || name.startsWith(IS);
    }
}
