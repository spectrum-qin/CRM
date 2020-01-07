package com.spectrum.crm.util;

import org.apache.commons.collections.MapUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapUtil {

    public Map getHead(Map map) {

        return new HashMap();
    }

    public static String getStringKeyValues (Map parmMap, String key) {
        Object obj = getKeyValues(parmMap, key, "");
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static String getStringKeyValues (Map parmMap, String key, String flag) {
        Object obj = getKeyValues(parmMap, key, flag);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static Object getKeyValues(Map parnMap, String key, String flag) {
        if (MapUtils.isEmpty(parnMap)) {
            throw new ServiceException("参数异常【parmMap及key】，不可为null！parmMap=" + parnMap + ", key= " + key);
        }
        if (Objects.equals(flag, "Y") || Objects.equals(flag, "y")) {
            if (!parnMap.containsKey(key) || StringUtils.isEmpty(parnMap.get(key)) || Objects.equals("null", parnMap.get(key))) {
                throw new ServiceException("必输项【" + key + "】不可为空！");
            } else {
                return parnMap.get(key);
            }
        } else {
            if (!parnMap.containsKey(key) || Objects.equals("null", String.valueOf(parnMap.get(key)).toLowerCase())) {
                return null;
            } else {
                return parnMap.get(key);
            }
        }
    }
}
