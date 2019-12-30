package com.eve.controller;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.eve.entity.Dish;

public class DemoDataListener extends AnalysisEventListener<Dish> {
    private List<Dish> list = new LinkedList<Dish>();

    /**
     * 这个每一条数据解析都会来调用
     */
    public void invoke(Dish dish, AnalysisContext analysisContext) {
        System.out.println("读取到一条数据 " + JSON.toJSONString(dish));
        list.add(dish);
    }

    /**
     * 所有数据读取完了调用
     * @param analysisContext
     */
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完毕 所有数据  " + JSON.toJSONString(list));
    }

		
}