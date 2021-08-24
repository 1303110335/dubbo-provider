/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.enums;

/**
 *
 * @author xuleyan
 * @version YesNoMark.java, v 0.1 2021-08-21 9:31 下午
 */
public enum YesNoMark {
    Y("y", 1),
    N("n", -1),
    ;

    private int index;
    private String code;

    YesNoMark(String code, int index){
        this.index = index;
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public String getCode() {
        return code;
    }

    public com.alijk.bqcommon.base.enums.YesNoMark parseByCode(String code){
        for(com.alijk.bqcommon.base.enums.YesNoMark yesNoMark : com.alijk.bqcommon.base.enums.YesNoMark.values()) {
            if(yesNoMark.getCode().equalsIgnoreCase(code)) {
                return yesNoMark;
            }
        }
        return null;
    }

    public com.alijk.bqcommon.base.enums.YesNoMark parseByIndex(int index){
        for(com.alijk.bqcommon.base.enums.YesNoMark yesNoMark : com.alijk.bqcommon.base.enums.YesNoMark.values()) {
            if(yesNoMark.getIndex() == index) {
                return yesNoMark;
            }
        }
        return null;
    }
}