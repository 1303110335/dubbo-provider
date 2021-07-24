package con.xuleyan.provider.client.configuration;

import con.xuleyan.provider.client.constant.AcsClientConstants;
import con.xuleyan.provider.client.constant.AcsLoginType;
import con.xuleyan.provider.client.constant.AcsRequestType;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eason(bo.chenb)
 * @description
 * @date 2020-04-22
 **/
@Configuration
public class AcsClientProperties {

    /**
     * 是否启用单点登录配置
     */
    private Boolean enable;
    /**
     * 当前应用系统Id
     */
    private String appId;
    /**
     * 当前client所使用的token,必须为8为字符或数字组成
     */
    private String token;
    /**
     * 当前应用系统appSecret
     */
    private String appSecret;
    /**
     * 当前应用系统所属机构
     */
    private String orgCode;
    /**
     * 排除拦截路径,多个路径请使用英文逗号隔开
     */
    private String excludedPaths;
    /**
     * 需要拦截路径,多个路径请使用英文逗号隔开!默认为/**
     */
    private String includedPaths;
    /**
     * 应用检查url,http类型
     */
    private String checkAppUrl;
    /**
     * client服务登录uri,当登陆类型为[loginType、LOCAL_SERVER]必填
     */
    private String clientLoginUri;
    /**
     * client服务登出uri,当登陆类型为[loginType、LOCAL_SERVER]必填
     */
    private String clientLogoutUri;
    /**
     * 客户端登陆类型
     * LOCAL(本地登陆、权限数据由本应用管理)
     * LOCAL_SERVER(本地登陆、权限数据由acs服务端管理)
     * SERVER(跳转到acs服务统一登陆界面)
     */
    private AcsLoginType loginType;
    /**
     * acs协议请求类型(client端与server端的通讯协议)[dubbo、http、socket]
     */
    private AcsRequestType requestType;
    /**
     * 默认访问acs服务地址,方式为server时必填，如果不为空,则一直默认都访问这个地址,如[http://ip:port]
     */
    private String serverUrl;
    /**
     * 完整登陆页地址，为空时可根据 serverUrl+loginUri作为跳转地址
     */
    public String loginUrl;
    /**
     * 单点登录服务登录uri
     */
    private String serverLoginUri;
    /**
     * 单点登录服务登出uri
     */
    private String serverLogoutUri;
    /**
     * 当requestType为socket时必填，多个连接用','隔开如[192.168.1.12:8888,192.168.1.11:8888]
     */
    private String serverHosts;
    /**
     * 应用logo uri, 用于登陆页展示
     */
    private String appLogoUri;
    /**
     * 应用title 用于登陆页展示
     */
    private String appTitle;
    /**
     * 应用的icon uri 展示
     */
    private String iconUri;
    /**
     * 首页访问地址
     */
    private String indexUri;
    /**
     * 应用首页logo
     */
    private String indexLogoUri;
    /**
     * 当前应用启动端口，由程序自动获取,不需要配置
     */
    private Integer serverPort;

    /**
     * 当前应用所在服务器ip地址，由程序自动获取,不需要配置
     */
    private String serverAddress;
    /**
     * cooike 域名设置
     */
    private String domain;



    public AcsClientProperties() {
        this.enable = true;
        this.token = AcsClientConstants.DEFAULT_SOCKET_TOKEN;
        this.includedPaths = "/**";
        this.clientLoginUri = AcsClientConstants.DEFAULT_LOGIN_URI;
        this.clientLogoutUri = AcsClientConstants.DEFAULT_LOGOUT_URI;
        this.requestType = AcsRequestType.SOCKET;
    }


    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getExcludedPaths() {
        return excludedPaths;
    }

    public void setExcludedPaths(String excludedPaths) {
        this.excludedPaths = excludedPaths;
    }

    public String getIncludedPaths() {
        return includedPaths;
    }

    public void setIncludedPaths(String includedPaths) {
        this.includedPaths = includedPaths;
    }

    public String getCheckAppUrl() {
        return checkAppUrl;
    }

    public void setCheckAppUrl(String checkAppUrl) {
        this.checkAppUrl = checkAppUrl;
    }

    public String getClientLoginUri() {
        return clientLoginUri;
    }

    public void setClientLoginUri(String clientLoginUri) {
        this.clientLoginUri = clientLoginUri;
    }

    public String getClientLogoutUri() {
        return clientLogoutUri;
    }

    public void setClientLogoutUri(String clientLogoutUri) {
        this.clientLogoutUri = clientLogoutUri;
    }

    public AcsLoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(AcsLoginType loginType) {
        this.loginType = loginType;
    }

    public AcsRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(AcsRequestType requestType) {
        this.requestType = requestType;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerLoginUri() {
        return serverLoginUri;
    }

    public void setServerLoginUri(String serverLoginUri) {
        this.serverLoginUri = serverLoginUri;
    }

    public String getServerLogoutUri() {
        return serverLogoutUri;
    }

    public void setServerLogoutUri(String serverLogoutUri) {
        this.serverLogoutUri = serverLogoutUri;
    }

    public String getServerHosts() {
        return serverHosts;
    }

    public void setServerHosts(String serverHosts) {
        this.serverHosts = serverHosts;
    }

    public String getAppLogoUri() {
        return appLogoUri;
    }

    public void setAppLogoUri(String appLogoUri) {
        this.appLogoUri = appLogoUri;
    }

    public String getIndexLogoUri() {
        return indexLogoUri;
    }

    public void setIndexLogoUri(String indexLogoUri) {
        this.indexLogoUri = indexLogoUri;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

    public String getIndexUri() {
        return indexUri;
    }

    public void setIndexUri(String indexUri) {
        this.indexUri = indexUri;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "AcsClientProperties{" +
                "enable=" + enable +
                ", appId='" + appId + '\'' +
                ", token='" + token + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", excludedPaths='" + excludedPaths + '\'' +
                ", includedPaths='" + includedPaths + '\'' +
                ", checkAppUrl='" + checkAppUrl + '\'' +
                ", clientLoginUri='" + clientLoginUri + '\'' +
                ", clientLogoutUri='" + clientLogoutUri + '\'' +
                ", loginType=" + loginType +
                ", requestType=" + requestType +
                ", serverUrl='" + serverUrl + '\'' +
                ", loginUrl='" + loginUrl + '\'' +
                ", serverLoginUri='" + serverLoginUri + '\'' +
                ", serverLogoutUri='" + serverLogoutUri + '\'' +
                ", serverHosts='" + serverHosts + '\'' +
                ", appLogoUri='" + appLogoUri + '\'' +
                ", appTitle='" + appTitle + '\'' +
                ", iconUri='" + iconUri + '\'' +
                ", indexUri='" + indexUri + '\'' +
                ", indexLogoUri='" + indexLogoUri + '\'' +
                ", serverPort=" + serverPort +
                ", serverAddress='" + serverAddress + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
