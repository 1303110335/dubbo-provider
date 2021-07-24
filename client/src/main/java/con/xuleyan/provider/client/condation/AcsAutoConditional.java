//package con.xuleyan.provider.client.condation;
//
//import com.alijk.bqhealth.acs.common.constant.AcsClientKey;
//import com.alijk.bqhealth.acs.common.util.PropertyUtils;
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//
//import java.util.SortedMap;
//
///**
// * @author Eason(bo.chenb)
// * @description
// *      作为开关条件，由于@ConditionalOnProperty不能组合使用，为了保证在acs关闭情况下其他相关类不用被管理
// * @date 2020-04-22
// **/
//public class AcsAutoConditional implements Condition {
//
//    @Override
//    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        SortedMap<String, Object> properties = PropertyUtils.filterProperties((ConfigurableEnvironment) conditionContext.getEnvironment());
//        Object value = properties.get(AcsClientKey.ENABLE);
//
//        if(value != null){
//            return !"false".equals(value.toString());
//        }
//
//        /**
//         * 默认true  非springboot 默认启动
//         */
//        return true;
//
//    }
//
//}
