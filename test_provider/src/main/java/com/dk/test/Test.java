package com.dk.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dk.pojo.*;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: httpClient_demo
 * @description:
 * @author: 李元超
 * @create: 2021-01-05 20:37
 */
public class Test {
    public static void main(String[] args) {
//                doget();
       // doPost();
//        User user=new User();
//        user.setName("张三");
//        doget2(user);
       // doPost2();
        doget2();
    }
    //doget无参数
    public static  void doget()
    {
        //1.创建HttpClient对象，相当于打开了浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //2.创建http请求，get post
        //创建doget请求，相当于浏览器输入地址
        HttpGet httpGet=new HttpGet("http://127.0.0.1:10001/getTest");
        //3.执行请求，得到响应对象
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpGet);
            //4.判断响应状态吗是不是200，获取响应数据实体对象，200表示响应成功，一般用于get post请求
            if(response.getStatusLine().getStatusCode()==200)
            {
                //5.获取响应数据
                HttpEntity entity=response.getEntity();
                String content= EntityUtils.toString(entity,"utf-8");
                System.out.println("响应结果为->>>>>>   "+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //6.关闭响应对象
            if(response!=null)
            {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭httpCilent
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //doPost无参数
    public static  void doPost()
    {
        //1.创建HttpClient对象，相当于打开了浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //2.创建http请求，get post
        //创建doget请求，相当于浏览器输入地址
        HttpPost httpPost=new HttpPost("http://wthrcdn.etouch.cn/weather_mini?citykey="+101070101);
        //3.执行请求，得到响应对象
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpPost);
            //4.判断响应状态吗是不是200，获取响应数据实体对象，200表示响应成功，一般用于get post请求
            if(response.getStatusLine().getStatusCode()==200)
            {
                //5.获取响应数据
                HttpEntity entity=response.getEntity();
                String content= EntityUtils.toString(entity,"utf-8");
                System.out.println("响应结果为->>>>>>   "+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //6.关闭响应对象
            if(response!=null)
            {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭httpCilent
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //get请求有参数
    public static void doget2()
    {
        //1.创建HttpClient对象
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //创建url对象，传递参数
        URI uri=null;
       // String str= JSONObject.toJSONString("北京");
        try {
            uri=new URIBuilder("https://lab.isaaclin.cn/nCoV/api/area").setParameter("latest","1").setParameter("province","北京市").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //2.创建http请求get，post
        HttpGet httpGet=new HttpGet(uri);
        //3.执行请求，得到响应对象
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpGet);
            //4.判断响应状态码是不是200，获取响应数实体类对象，200表示响应成功，一般用于getpost请求
            if(response.getStatusLine().getStatusCode()==200)
            {
                //5获取响应数据
                HttpEntity entity=response.getEntity();
                String content=EntityUtils.toString(entity,"utf-8");
                System.out.println(content);
                JSONObject jsonObject=JSONObject.parseObject(content);
                List<JSONObject> datas =(List<JSONObject>)jsonObject.get("results");
                List<JSONObject> cities=null;
                List<Covid> covidList=new ArrayList<>();
                for (JSONObject data : datas) {
                    cities = (List<JSONObject>)data.get("cities");
                }
                for (JSONObject city : cities) {
                    Covid covids=JSONObject.parseObject(city.toJSONString(),Covid.class);
                    covidList.add(covids);
                                       System.out.println("地区："+covids.getCityName());
                    System.out.println("现存确诊："+covids.getCurrentConfirmedCount());
                   // System.out.println("相比昨天的现存确诊："+covids.getConfirmedIncr());
                    System.out.println("累计确诊："+covids.getCuredCount());
                   // System.out.println("相比昨天的累计确诊："+covids.getConfirmedCount());
                   // System.out.println("境外输入："+covids.getConfirmedCount());
                   // System.out.println("相比昨天的境外输入："+covids.getConfirmedCount());
                    System.out.println("累计死亡："+covids.getDeadCount());
                    //System.out.println("相比昨天的累计死亡："+covids.getConfirmedCount());
                    //System.out.println("现存无症状："+covids.getConfirmedCount());
                    //System.out.println("相比昨天的现存无症状："+covids.getConfirmedCount());
                    System.out.println("累计治愈："+covids.getCuredCount());
                    //System.out.println("相比昨天的累计治愈："+covids.getConfirmedCount());


                }

//                for (JSONObject data : datas) {
//                    Covid covids =JSONObject.parseObject(data.toJSONString(),Covid.class);
//                    System.out.println("地区："+covids.getCityName());
//                    System.out.println("现存确诊："+covids.getCurrentConfirmedCount());
//                   // System.out.println("相比昨天的现存确诊："+covids.getConfirmedIncr());
//                    System.out.println("累计确诊："+covids.getCuredCount());
//                   // System.out.println("相比昨天的累计确诊："+covids.getConfirmedCount());
//                   // System.out.println("境外输入："+covids.getConfirmedCount());
//                   // System.out.println("相比昨天的境外输入："+covids.getConfirmedCount());
//                    System.out.println("累计死亡："+covids.getDeadCount());
//                    //System.out.println("相比昨天的累计死亡："+covids.getConfirmedCount());
//                    //System.out.println("现存无症状："+covids.getConfirmedCount());
//                    //System.out.println("相比昨天的现存无症状："+covids.getConfirmedCount());
//                    System.out.println("累计治愈："+covids.getCuredCount());
//                    //System.out.println("相比昨天的累计治愈："+covids.getConfirmedCount());
//
//
//                }


               // String s = JSONObject.toJSONString(currentConfirmedCount);
                //String s = currentConfirmedCount.toString();
                //Covid covid = JSONObject.parseObject(s, Covid.class);
                //System.out.println(currentConfirmedCount.getConfirmedCount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //6.关闭对象
            if (response!=null)
            {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭httpCilent
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //post请求有参数
    public static void doPost2()
    {
        //1.创建HttpClient对象
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //创建url对象，传递参数
        URI uri=null;
        String s="北京";
        String str= JSONObject.toJSONString(s);
        try {
            uri=new URIBuilder("http://wthrcdn.etouch.cn/weather_mini").setParameter("city",str).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //2.创建http请求get，post
        HttpPost httpPost=new HttpPost(uri);
        //3.执行请求，得到响应对象
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpPost);
            //4.判断响应状态码是不是200，获取响应数实体类对象，200表示响应成功，一般用于getpost请求
            if(response.getStatusLine().getStatusCode()==200)
            {
                //5获取响应数据
                HttpEntity entity=response.getEntity();
                String content=EntityUtils.toString(entity,"utf-8");
//                User user1=JSONObject.parseObject(content,User.class);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //6.关闭对象
            if (response!=null)
            {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭httpCilent
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}