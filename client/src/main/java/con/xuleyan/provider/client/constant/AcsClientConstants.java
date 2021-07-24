package con.xuleyan.provider.client.constant;

/**
 * @author Eason(bo.chenb)
 * @description
 * @date 2020-04-21
 **/
public class AcsClientConstants {


    private static final String ACS_CONTROLLER_PREFIX = "/acs";
    /**
     * 登入操作url
     */
    public static final String LOGIN_URI = ACS_CONTROLLER_PREFIX + "/dologin";
    /**
     * 跳转登陆url-当未登陆时会将登陆页url返回给前端, server 端的uri也为这个
     */
    public static final String DEFAULT_LOGIN_URI = "/login";

    /**
     * 跳转登出url-当未登陆时会将登陆页url返回给前端, server 端的uri也为这个
     */
    public static final String DEFAULT_LOGOUT_URI = "/logout";
    /**
     * 默认首页uri
     */
    public static final String DEFAULT_INDEX_URI = "/homepage";

    /**
     * 登出操作url
     */
    public static final String LOGOUT_URI = ACS_CONTROLLER_PREFIX + "/dologout";

    /**
     * 获取权限信息
     */
    public static final String PERMISSION_INFO_URI = ACS_CONTROLLER_PREFIX + "/permission/info";
    /**
     * 修改密码
     */
    public static final String CHANGE_PASSWORD = ACS_CONTROLLER_PREFIX + "/change/pwd";

    /**
     * 获取用户基本信息
     */
    public static final String USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/info";

    /**
     * 获取用户详细信息
     */
    public static final String DETAILED_USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/detailed/info";

    /**
     * 新增用户
     */
    public static final String ADD_USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/add";

    /**
     * 批量新增用户
     */
    public static final String ADD_BATCH_USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/batch/add";

    /**
     * 修改密码
     */
    public static final String UPDATE_PASSWORD_URI = ACS_CONTROLLER_PREFIX + "/user/pwd/update";
    /**
     * 应用是否开放给当前机构
     */
    public static final String CHECK_APP_OPEN_ORG = ACS_CONTROLLER_PREFIX + "/check/app/openorg";

    /**
     * 修改用户基本信息
     */
    public static final String UPDATE_USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/update";

    /**
     * 删除用户-禁用用户
     */
    public static final String DELETE_USER_INFO_URI = ACS_CONTROLLER_PREFIX + "/user/delete";

    /**
     * 登陆页配置信息
     */
    public static final String LOGIN_SETTING_URI = ACS_CONTROLLER_PREFIX + "/login/setting";

    public static final String CHECK_APP_PERMISSION = ACS_CONTROLLER_PREFIX + "check/apppermission";

    /**
     * 应用首页配置信息
     */
    public static final String INDEX_SETTING_URI = ACS_CONTROLLER_PREFIX + "/app/index/setting";
    /**
     * 获取加密信息
     */
    public static final String LOGIN_ENCRYPT_KEY = ACS_CONTROLLER_PREFIX + "/encrypt";
    /**
     * 续签token有效周期
     */
    public static final String RENEWAL_TOKEN = ACS_CONTROLLER_PREFIX + "/renewal/token";

    /**
     * 校验token
     */
    public static final String CHECK_TOKEN = ACS_CONTROLLER_PREFIX + "/check/token";

    /**
     * 获取机构列表
     */
    public static final String ORG_LIST = ACS_CONTROLLER_PREFIX + "/org/list";
    /**
     * 首页应用列表
     */
    public static final String APP_LIST = ACS_CONTROLLER_PREFIX + "/app/list";


    /**
     * 默认socket传输token
     */
    public static final String DEFAULT_SOCKET_TOKEN = "1a2b3c4d";


    public static final String HTML_CONTENT_TYPRE= "text/html; charset=utf-8";

    public static final String JSON_CONTENT_TYPRE= "application/json;charset=UTF-8";
}
