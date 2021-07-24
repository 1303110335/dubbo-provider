package con.xuleyan.provider.client.constant;

/**
 * @author Eason(bo.chenb)
 * @description 登陆类型
 * @date 2020-04-20
 **/
public enum AcsLoginType {
    /**
     * 本地登陆（跳转到本地登陆界面），并从本应用读取权限数据--该情况为单体应用，嵌入登陆界面并集成权限管理等module-ui
     */
    LOCAL,
    /**
     * 本地登陆（跳转到本地登陆界面），权限数据存储于server端
     */
    LOCAL_SERVER,

    /**
     * sever端登陆（跳转到server端同一登陆界面）
     */
    SERVER,
    ;

    public static AcsLoginType parse(String type) {

        for (AcsLoginType loginType : AcsLoginType.values()) {

            if (loginType.name().equalsIgnoreCase(type)) {
                return loginType;
            }
        }
        return null;
    }
}
