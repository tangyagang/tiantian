package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

public class ScoreSearch implements Serializable {

    private static final long serialVersionUID = 2526295521113465287L;
    private String startScore;//开始的分数
    private String endScore;//结束的分数
    private int isDetails;//是否有内容

    public String getStartScore() {
        return startScore;
    }

    public void setStartScore(String startScore) {
        this.startScore = startScore;
    }

    public String getEndScore() {
        return endScore;
    }

    public void setEndScore(String endScore) {
        this.endScore = endScore;
    }

    public int getIsDetails() {
        return isDetails;
    }

    public void setIsDetails(int isDetails) {
        this.isDetails = isDetails;
    }
}
