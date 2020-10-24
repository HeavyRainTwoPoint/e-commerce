package com.bigliang.e_commerce.entity;


/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/20 22:47
 */

public class Lottery {
    /**
     * 该开奖范围从属的抽奖活动
     */
    private String actID;

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    /**
     * 中奖数字范围起点（通常0作为起点）
     */
    private Integer winningStartCode;
    /**
     * 当前概率计算出的中奖数字范围终点
     */
    private Integer winningEndCode;

    /**
     * 中奖的数字范围
     */
    private Integer codeScope;

    public Integer getWinningStartCode() {
        return winningStartCode;
    }

    public void setWinningStartCode(Integer winningStartCode) {
        this.winningStartCode = winningStartCode;
    }

    public Integer getWinningEndCode() {
        return winningEndCode;
    }

    public void setWinningEndCode(Integer winningEndCode) {
        this.winningEndCode = winningEndCode;
    }

    public Integer getCodeScope() {
        return codeScope;
    }

    public void setCodeScope(Integer codeScope) {
        this.codeScope = codeScope;
    }

}
