package com.xingyun.smartsite.common.property;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * get value from properties file
 * 获取配置文件里的值，方式为CommonProperty.getProperty(配置文件里字段的文件名);
 **/
public class CommonProperties extends PropertyPlaceholderConfigurer {
    private static Map<String, String> properties = new HashMap<String, String>();
    private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

    @Override
    public void setSystemPropertiesMode (int systemPropertiesMode) {
        super.setSystemPropertiesMode (systemPropertiesMode);
        springSystemPropertiesMode = systemPropertiesMode;
    }

    @Override
    protected void processProperties (ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties (beanFactory, props);

        for (Object key: props.keySet ()) {
            String keyStr = key.toString ();
            String valueStr = resolvePlaceholder (keyStr, props, springSystemPropertiesMode);
            properties.put (keyStr, valueStr);
        }
    }

    /**
     * Return a property loaded by the place holder.
     * @param name the property name.
     * @return the property value.
     */
    public static String getProperty(final String name) {
        return properties.get(name);
    }

    public static String getProperty(final String name, String ... replaceparam) {
        String returnmsg = properties.get(name);
        for(int i=0; i < replaceparam.length; i++){
            String replacestr = "{" + i + "}";
            returnmsg = StringUtils.replace(returnmsg, replacestr, replaceparam[i]);
        }

        return returnmsg;
    }

    public static List<String> getKeys(String keysubstring){
        List<String> keylist = new ArrayList();
        Set<String> keyset = properties.keySet();
        for(String item : keyset){
            if(item.indexOf(keysubstring) > -1){
                keylist.add(item);
            }
        }
        return keylist;

    }
}
