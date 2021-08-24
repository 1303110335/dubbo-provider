/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

/**
 *
 * @author xuleyan
 * @version PipelineState.java, v 0.1 2021-08-21 9:04 下午
 */
public interface PipelineState {

    /**
     * 检查pipeline将是否被中断
     * @return
     */
    boolean isBroken();

    /**
     * 检查pipeline将是否已执行完成
     * @return
     */
    boolean isFinished();

    /**
     * 阻断
     * @return
     */
    void doBreak();

    /**
     * 是否向上阻断
     * @return
     */
    void doBreak(boolean breakParent);

    /**
     * 取得当前pipeline执行的状态。
     * <p>
     * 假如取不到，则向上查找，直到找到或者到达顶层。
     * </p>
     */
    Object getAttribute(String key);

    /**
     * 设置当前pipeline的状态。
     * <p>
     *  设置当前pipeline执行的状态，会覆盖上层同名的状态值，然而却不会影响上一层执行的状态。
     *  当执行返回到上一层时，所以有的改变都被丢弃。
     * </p>
     *
     *
     * @param key
     * @param value
     * @param parent 是否放到父节点属性表中
     */
    void setAttribute(String key, Object value, boolean parent);

}