/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.utils;

import com.google.common.base.Preconditions;
import com.xuleyan.provider.service.valve.Valve;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author xuleyan
 * @version OrderUtil.java, v 0.1 2021-08-21 9:58 下午
 */
public class OrderUtil {

    public static <T extends Valve> T[] shuffleOrder(T[] valves) {
        Preconditions.checkState(ArrayUtils.isNotEmpty(valves), "Pipeline.Valves shoud not null");
        List<T> valveList = Arrays.asList(valves);
        valveList.sort(new Comparator<T>() {
            @Override
            public int compare(T v1, T v2) {
                return v1.order() - v2.order();
            }
        });
        return (T[]) valveList.toArray();
    }
}