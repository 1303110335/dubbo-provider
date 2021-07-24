//package con.xuleyan.provider.client.util;
//
//import com.alijk.bqhealth.acs.common.constant.AcsClientKey;
//import org.springframework.core.env.ConfigurableEnvironment;
//
//import java.util.Collections;
//import java.util.Map;
//import java.util.SortedMap;
//import java.util.TreeMap;
//
///**
// * @author Eason(bo.chenb)
// * @description
// * @date 2020-04-22
// **/
//public class PropertyUtils {
//
//    /**
//     * 过滤非 bianque.acs.* 配置
//     *
//     * @param environment
//     * @return
//     */
//    public static SortedMap<String, Object> filterProperties(ConfigurableEnvironment environment) {
//        SortedMap<String, Object> acsProperties = new TreeMap<>();
//
//        Map<String, Object> properties = EnvironmentUtils.extractProperties(environment);
//
//        for (Map.Entry<String, Object> entry : properties.entrySet()) {
//            String propertyName = entry.getKey();
//
//            if (propertyName.startsWith(AcsClientKey.PREFIX + ".")
//                    && entry.getValue() != null) {
//                acsProperties.put(propertyName, entry.getValue().toString());
//            }
//        }
//        return Collections.unmodifiableSortedMap(acsProperties);
//    }
//
//
//    /**
//     * 过滤指定配置
//     *
//     * @param environment
//     * @return
//     */
//    public static Object getProperties(ConfigurableEnvironment environment, String pattern) {
//
//        Map<String, Object> properties = EnvironmentUtils.extractProperties(environment);
//
//        return properties.get(pattern);
//    }
//}
