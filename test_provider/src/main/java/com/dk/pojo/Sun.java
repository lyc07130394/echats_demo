package com.dk.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @program: httpClient_demo
 * @description:
 * @author: 李元超
 * @create: 2021-01-05 22:44
 */
public class Sun  implements Serializable {
    private String data;
    private String status;
    private String desc;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}