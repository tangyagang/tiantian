package com.cssl.tiantian.tools;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PojoTransformationMap {

    /**
     * 实体对象转成Map
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> objectMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.get(obj) == null || field.get(obj).equals("") ||
                        field.getName().equalsIgnoreCase("serialVersionUID")){
                    continue;
                }
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
