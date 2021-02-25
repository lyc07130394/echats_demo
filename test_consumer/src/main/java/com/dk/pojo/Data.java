package com.dk.pojo;

/**
 * @program: httpClient_demo
 * @description:
 * @author: 李元超
 * @create: 2021-01-06 11:02
 */
public class Data {
    private String yesterday;
    private String city;
    private String forecast;

    public String getYesterday() {
        return yesterday;
    }

    public void setYesterday(String yesterday) {
        this.yesterday = yesterday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}