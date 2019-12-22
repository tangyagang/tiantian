package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

/**
 * 评价统计表
 */
public class ProScoreNumsVo implements Serializable {

    private static final long serialVersionUID = 7844632548050465220L;
    private int weekNum;
    private int monthNum;
    private int yearNum;
    private int halfYearNum;
    private int totalNum;

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getYearNum() {
        return yearNum;
    }

    public void setYearNum(int yearNum) {
        this.yearNum = yearNum;
    }

    public int getHalfYearNum() {
        return halfYearNum;
    }

    public void setHalfYearNum(int halfYearNum) {
        this.halfYearNum = halfYearNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public ProScoreNumsVo() {
    }

    public ProScoreNumsVo(int weekNum, int monthNum, int yearNum, int halfYearNum, int totalNum) {
        this.weekNum = weekNum;
        this.monthNum = monthNum;
        this.yearNum = yearNum;
        this.halfYearNum = halfYearNum;
        this.totalNum = totalNum;
    }

    public ProScoreNumsVo(int weekNum, int monthNum, int yearNum, int halfYearNum) {
        this.weekNum = weekNum;
        this.monthNum = monthNum;
        this.yearNum = yearNum;
        this.halfYearNum = halfYearNum;
    }
}
