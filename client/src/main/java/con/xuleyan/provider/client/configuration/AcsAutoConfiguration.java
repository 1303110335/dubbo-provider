//package con.xuleyan.provider.client.configuration;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.util.StopWatch;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.lang.management.ManagementFactory;
//import java.util.List;
//import java.util.SortedMap;
//
///**
// * @author Eason(bo.chenb)
// * @description
// * @date 2020-04-20
// **/
//@Slf4j
//@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Conditional({AcsAutoConditional.class})
//public class AcsAutoConfiguration {
//
//
//    @Resource
//    private ConfigurableEnvironment environment;
//
//    @Resource
//    private AcsClientProperties clientProperties;
//
//
//    @PostConstruct
//    public void init() {
//
//        SortedMap<String, Object> properties = PropertyUtils.filterProperties(environment);
//        Object appId, clientToken, appSecret, orgCode, excludedPaths, includedPaths, checkAppUrl, loginType, clientLoginUri,
//                clientLogoutUri, requestType, serverUrl, serverLoginUri, serverLogoutUri, serverHosts, clientAppLogoUri,
//                clientIconUri, clientAppTitle, clientIndexUri, indexLogoUri, loginUrl, domain;
//
//        /** 当参数为空时从clientProperties中获取，当properties为空可认定为xml配置方式 */
//        if (properties.isEmpty()) {
//            appId = clientProperties.getAppId();
//            clientToken = clientProperties.getToken();
//            appSecret = clientProperties.getAppSecret();
//            orgCode = clientProperties.getOrgCode();
//            excludedPaths = clientProperties.getExcludedPaths();
//            includedPaths = clientProperties.getIncludedPaths();
//            checkAppUrl = clientProperties.getCheckAppUrl();
//            loginType = clientProperties.getLoginType() == null ? null : clientProperties.getLoginType().name();
//            clientLoginUri = clientProperties.getClientLoginUri();
//            clientLogoutUri = clientProperties.getClientLogoutUri();
//            requestType = clientProperties.getRequestType() == null ? null : clientProperties.getRequestType().name();
//            serverUrl = clientProperties.getServerUrl();
//            serverLoginUri = clientProperties.getServerLoginUri();
//            serverLogoutUri = clientProperties.getServerLogoutUri();
//            serverHosts = clientProperties.getServerHosts();
//            clientAppLogoUri = clientProperties.getAppLogoUri();
//            clientIconUri = clientProperties.getIconUri();
//            clientAppTitle = clientProperties.getAppTitle();
//            clientIndexUri = clientProperties.getIndexUri();
//            indexLogoUri = clientProperties.getIndexLogoUri();
//            loginUrl = clientProperties.getLoginUrl();
//            domain = clientProperties.getDomain();
//        } else {
//            appId = properties.get(AcsClientKey.APPID);
//            clientToken = properties.get(AcsClientKey.CLIENT_TOKEN);
//            appSecret = properties.get(AcsClientKey.APP_SECRET);
//            orgCode = properties.get(AcsClientKey.ORG_CODE);
//            excludedPaths = properties.get(AcsClientKey.EXCLUDED_PATHS);
//            includedPaths = properties.get(AcsClientKey.INCLUDED_PATHS);
//            checkAppUrl = properties.get(AcsClientKey.CHECK_APP);
//            loginType = properties.get(AcsClientKey.LOGIN_TYPE);
//            clientLoginUri = properties.get(AcsClientKey.CLIENT_LOGIN_URI);
//            clientLogoutUri = properties.get(AcsClientKey.CLIENT_LOGOUT_URI);
//            requestType = properties.get(AcsClientKey.REQUEST_TYPE);
//            serverUrl = properties.get(AcsClientKey.SERVER_URL);
//            serverLoginUri = properties.get(AcsClientKey.SERVER_LOGIN_URI);
//            serverLogoutUri = properties.get(AcsClientKey.SERVER_LOGOUT_URI);
//            serverHosts = properties.get(AcsClientKey.SERVER_HOSTS);
//            clientAppLogoUri = properties.get(AcsClientKey.CLIENT_APP_LOGO_URI);
//            clientIconUri = properties.get(AcsClientKey.CLIENT_ICON_URI);
//            clientAppTitle = properties.get(AcsClientKey.CLIENT_APP_TITLE);
//            clientIndexUri = properties.get(AcsClientKey.CLIENT_INDEX_URI);
//            indexLogoUri = properties.get(AcsClientKey.CLIENT_INDEX_LOGO_URI);
//            loginUrl = properties.get(AcsClientKey.LOGIN_URL);
//            domain = properties.get(AcsClientKey.DOMAIN);
//        }
//
//
//        if (appId != null && StringUtils.isNotBlank(appId.toString())) {
//            clientProperties.setAppId(appId.toString().trim());
//        } else {
//            throw new AcsClientException(String.format("ACS初始化配置失败,请配置完整的%s", AcsClientKey.APPID));
//        }
//
//
//        if (clientToken != null && StringUtils.isNotBlank(clientToken.toString())) {
//            String token = clientToken.toString().trim();
//            isLetterOrDigit(AcsClientKey.CLIENT_TOKEN, token);
//            validateLength(AcsClientKey.CLIENT_TOKEN, token, 8);
//            clientProperties.setToken(token);
//        }
//
//        if (clientIndexUri != null && StringUtils.isNotBlank(clientIndexUri.toString())) {
//            String indexUri = clientIndexUri.toString().trim();
//            clientProperties.setIndexUri(StringUtils.startsWith(indexUri, "/") ? indexUri : "/" + indexUri);
//        } /*else {
//            throw new AcsClientException(String.format("ACS初始化配置失败,请配置完整的%s", AcsClientKey.APPID));
//        }*/
//
//        if (appSecret != null && StringUtils.isNotBlank(appSecret.toString())) {
//            clientProperties.setAppSecret(appSecret.toString().trim());
//        } /*else {
//            throw new AcsClientException(String.format("ACS初始化配置失败,请配置完整的%s", AcsClientKey.APP_SECRET));
//        }
//*/
//        if (orgCode != null && StringUtils.isNotBlank(orgCode.toString())) {
//            clientProperties.setOrgCode(orgCode.toString().trim());
//        }
//
//        if (excludedPaths != null && StringUtils.isNotBlank(excludedPaths.toString())) {
//            clientProperties.setExcludedPaths(excludedPaths.toString().trim());
//        }
//
//        if (includedPaths != null && StringUtils.isNotBlank(includedPaths.toString())) {
//            clientProperties.setIncludedPaths(includedPaths.toString().trim());
//        }
//
//        if (checkAppUrl != null && StringUtils.isNotBlank(checkAppUrl.toString())) {
//            clientProperties.setCheckAppUrl(checkAppUrl.toString().trim());
//        }
//
//        if (clientAppLogoUri != null && StringUtils.isNotBlank(clientAppLogoUri.toString())) {
//            clientProperties.setAppLogoUri(clientAppLogoUri.toString().trim());
//        }
//
//        if (indexLogoUri != null && StringUtils.isNotBlank(indexLogoUri.toString())) {
//            clientProperties.setIndexLogoUri(indexLogoUri.toString().trim());
//        }
//
//        if (clientIconUri != null && StringUtils.isNotBlank(clientIconUri.toString())) {
//            clientProperties.setIconUri(clientIconUri.toString().trim());
//        }
//
//        if (clientAppTitle != null && StringUtils.isNotBlank(clientAppTitle.toString())) {
//            clientProperties.setAppTitle(clientAppTitle.toString().trim());
//        }
//
//
//        AcsLoginType acsLoginType = null;
//
//        if (loginType != null && StringUtils.isNotBlank(loginType.toString())) {
//
//            acsLoginType = AcsLoginType.parse(loginType.toString().trim());
//
//            if (acsLoginType == null) {
//                throw new AcsClientException(String.format("ACS初始化配置失败,配置%s参数%s为未知类型请选择[LOCAL、LOCAL_SERVER、SERVER]", AcsClientKey.LOGIN_TYPE, loginType.toString()));
//            }
//            clientProperties.setLoginType(acsLoginType);
//        } else {
//            throw new AcsClientException(String.format("ACS初始化配置失败,请配置完整的%s", AcsClientKey.LOGIN_TYPE));
//        }
//
//        if (clientLoginUri != null && StringUtils.isNotBlank(clientLoginUri.toString())) {
//            clientProperties.setClientLoginUri(clientLoginUri.toString().trim());
//        }
//
//        if (clientLogoutUri != null && StringUtils.isNotBlank(clientLogoutUri.toString())) {
//            clientProperties.setClientLogoutUri(clientLogoutUri.toString().trim());
//        }
//
//
//        /* 跳转到服务端登陆登陆 */
//        if (acsLoginType == AcsLoginType.SERVER) {
//            if (serverUrl != null && StringUtils.isNotBlank(serverUrl.toString())) {
//                String url = serverUrl.toString().trim();
//                /* 将最后的 '/' 去掉 */
//                clientProperties.setServerUrl(url.endsWith("/") ? url.substring(0, url.length() - 1) : url);
//            } else {
//                throw new AcsClientException(String.format("ACS初始化配置失败,当登陆类型为SERVER时必须配置完整的%s", AcsClientKey.SERVER_URL));
//            }
//
//            if (serverLoginUri != null && StringUtils.isNotBlank(serverLoginUri.toString())) {
//                clientProperties.setServerLoginUri(serverLoginUri.toString().trim());
//            } else {
//                clientProperties.setServerLoginUri(AcsClientConstants.DEFAULT_LOGIN_URI);
//            }
//
//            if (serverLogoutUri != null && StringUtils.isNotBlank(serverLogoutUri.toString())) {
//                clientProperties.setServerLogoutUri(serverLogoutUri.toString().trim());
//            } else {
//                clientProperties.setServerLogoutUri(AcsClientConstants.DEFAULT_LOGOUT_URI);
//            }
//        }
//
//        /* 请求类型 */
//        AcsRequestType acsRequestType = null;
//        if (requestType != null && StringUtils.isNotBlank(requestType.toString())) {
//
//            acsRequestType = AcsRequestType.parse(requestType.toString().trim());
//
//            if (acsRequestType == null) {
//                throw new AcsClientException(String.format("ACS初始化配置失败,配置%s参数%s为未知类型请选择[dubbo、http、socket]", AcsClientKey.REQUEST_TYPE, requestType.toString()));
//            }
//            clientProperties.setRequestType(acsRequestType);
//        } else {
//            acsRequestType = clientProperties.getRequestType();
//        }
//        /* local 类型本身拥有权限管理功能，无需连接socket，不需要进行socket配置 */
//
//        if (acsRequestType == AcsRequestType.SOCKET && acsLoginType != AcsLoginType.LOCAL) {
//            if (serverHosts != null && StringUtils.isNotBlank(serverHosts.toString())) {
//                validateAddress(serverHosts.toString().trim());
//                clientProperties.setServerHosts(serverHosts.toString().trim());
//            } else {
//                throw new AcsClientException(String.format("ACS初始化配置失败,当请求类型为SOCKET必须配置完整的%s", AcsClientKey.SERVER_HOSTS));
//            }
//        }
//
//        if(loginUrl != null){
//            clientProperties.setLoginUrl(loginUrl.toString().trim());
//        }
//
//        if(domain != null){
//            clientProperties.setDomain(domain.toString().trim());
//        }
//
//        clientProperties.setServerAddress(AcsIpUtils.getLocalIpAddr());
//        Object serverPort = PropertyUtils.getProperties(environment, "server.port");
//
//        if(serverPort != null ){
//            clientProperties.setServerPort(Integer.parseInt(serverPort.toString()));
//        }
//
//    }
//
//    @Bean
//    public AcsFilter acsFilter() {
//
//        return new AcsFilter();
//    }
//
//
//    @Bean
//    @DependsOn(value = {"acsFilter"})
//    public FilterRegistrationBean filterRegistrationBean() {
//
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//
//        log.info("Start register filter protocol:{}", clientProperties.getRequestType().name());
//
//        FilterRegistrationBean<AcsFilter> registration = new FilterRegistrationBean<>();
//        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        registration.setFilter(acsFilter());
//
//        log.info(getStartedMessage(stopWatch).toString());
//        return registration;
//    }
//
//
//    private void validateLength(String paramName, String value, int length) {
//
//        if (value.length() != length) {
//            throw new AcsClientException(String.format("强制%s为长度为%s,你的配置[%s]", paramName, length, value));
//        }
//
//    }
//
//    private void isLetterOrDigit(String paramName, String value) {
//
//        for (int i = 0; i < value.length(); i++) {
//
//            if (!Character.isLetterOrDigit(value.charAt(i))) {
//                throw new AcsClientException(String.format("强制%s为数字或字母，可为纯数据或字母也可以为组合形式,如[1a2b3c4d],你的配置[%s]", paramName, value));
//            }
//        }
//
//    }
//
//    public static StringBuilder getStartedMessage(StopWatch stopWatch) {
//        StringBuilder message = new StringBuilder();
//        message.append("Started ");
//        message.append("Bian Que Acs");
//        message.append(" in ");
//        message.append(stopWatch.getTotalTimeSeconds());
//        double uptime = (double) ManagementFactory.getRuntimeMXBean().getUptime() / 1000.0D;
//        message.append(" seconds (JVM running for " + uptime + ")");
//        return message;
//    }
//
//    private void validateAddress(String hosts) {
//
//        List<String> values = StringUtil.splitter(hosts, ",");
//
//        for (String value : values) {
//            List<String> addressInfo = StringUtil.splitter(value, ":");
//            if (addressInfo.size() != 2) {
//                throw new AcsClientException(String.format("ACS初始化配置失败,请配置配置正确的%s,如[ip:port,ip:port]", AcsClientKey.SERVER_HOSTS));
//            }
//        }
//    }
//
//}
