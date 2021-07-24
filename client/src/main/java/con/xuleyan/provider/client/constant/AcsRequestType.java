package con.xuleyan.provider.client.constant;

/**
 * @author Eason(bo.chenb)
 * @description 请求类型
 * @date 2020-04-20
 **/
public enum AcsRequestType {

    /**
     * dubbo 方式
     */
    DUBBO,
    /**
     * http方式
     */
    HTTP,
    /**
     * socket方式
     */
    SOCKET,
    ;

    public static AcsRequestType parse(String type) {

        for (AcsRequestType requestType : AcsRequestType.values()) {

            if (requestType.name().equalsIgnoreCase(type)) {
                return requestType;
            }

        }

        return null;
    }

}
