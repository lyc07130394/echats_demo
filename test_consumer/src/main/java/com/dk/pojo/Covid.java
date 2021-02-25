package com.dk.pojo;

import java.io.Serializable;

/**
 * @program: httpClient_demo
 * @description:
 * @author: 李元超
 * @create: 2021-01-07 10:09
 */
public class Covid implements Serializable {
    private String cityName;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private String locationId;
    private String deadCount;
    private String cityEnglishName;
    private String suspectedCount;

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getCityEnglishName() {
        return cityEnglishName;
    }

    public void setCityEnglishName(String cityEnglishName) {
        this.cityEnglishName = cityEnglishName;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
//  private String  currentConfirmedCount;//现存确诊
//
//  private String  currentConfirmedIncr;//相比昨天的现存确诊
//
//  private String  confirmedCount;//累计确诊
//
//  private String  confirmedIncr;//相比昨天的累计确诊
//
//  private String  suspectedCount;//境外输入
//
//  private String  suspectedIncr;//相比昨天的境外输入
//
//  private String  deadCount;//累计死亡
//
//  private String  deadIncr;//相比昨天的累计死亡
//
//  private String  seriousCount;//现存无症状
//
//  private String  seriousIncr;//相比昨天的现存无症状
//
//  private String  curedCount;//累计治愈
//
//  private String  curedIncr;//相比昨天的累计治愈
//
//    public String getCurrentConfirmedCount() {
//        return currentConfirmedCount;
//    }
//
//    public void setCurrentConfirmedCount(String currentConfirmedCount) {
//        this.currentConfirmedCount = currentConfirmedCount;
//    }
//
//    public String getCurrentConfirmedIncr() {
//        return currentConfirmedIncr;
//    }
//
//    public void setCurrentConfirmedIncr(String currentConfirmedIncr) {
//        this.currentConfirmedIncr = currentConfirmedIncr;
//    }
//
//    public String getConfirmedCount() {
//        return confirmedCount;
//    }
//
//    public void setConfirmedCount(String confirmedCount) {
//        this.confirmedCount = confirmedCount;
//    }
//
//    public String getConfirmedIncr() {
//        return confirmedIncr;
//    }
//
//    public void setConfirmedIncr(String confirmedIncr) {
//        this.confirmedIncr = confirmedIncr;
//    }
//
//    public String getSuspectedCount() {
//        return suspectedCount;
//    }
//
//    public void setSuspectedCount(String suspectedCount) {
//        this.suspectedCount = suspectedCount;
//    }
//
//    public String getSuspectedIncr() {
//        return suspectedIncr;
//    }
//
//    public void setSuspectedIncr(String suspectedIncr) {
//        this.suspectedIncr = suspectedIncr;
//    }
//
//    public String getDeadCount() {
//        return deadCount;
//    }
//
//    public void setDeadCount(String deadCount) {
//        this.deadCount = deadCount;
//    }
//
//    public String getDeadIncr() {
//        return deadIncr;
//    }
//
//    public void setDeadIncr(String deadIncr) {
//        this.deadIncr = deadIncr;
//    }
//
//    public String getSeriousCount() {
//        return seriousCount;
//    }
//
//    public void setSeriousCount(String seriousCount) {
//        this.seriousCount = seriousCount;
//    }
//
//    public String getSeriousIncr() {
//        return seriousIncr;
//    }
//
//    public void setSeriousIncr(String seriousIncr) {
//        this.seriousIncr = seriousIncr;
//    }
//
//    public String getCuredCount() {
//        return curedCount;
//    }
//
//    public void setCuredCount(String curedCount) {
//        this.curedCount = curedCount;
//    }
//
//    public String getCuredIncr() {
//        return curedIncr;
//    }
//
//    public void setCuredIncr(String curedIncr) {
//        this.curedIncr = curedIncr;
//    }
}