package com.uzhizhe.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Desc Collection util
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-13
 */
public final class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * is blank
     *
     * @param collection collection
     * @return true: null, size==0
     */
    public static boolean isBlank(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean notBlank(Collection collection) {
        return !isBlank(collection);
    }

    public static boolean isBlank(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean notBlank(Map map) {
        return !isBlank(map);
    }


}
