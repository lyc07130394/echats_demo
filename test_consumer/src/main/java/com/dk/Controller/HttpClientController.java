package com.dk.Controller;

import com.alibaba.fastjson.JSONObject;
import com.dk.pojo.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: httpClient_demo
 * @description:
 * @author: 李元超
 * @create: 2021-01-05 20:35
 */
@Controller
public class HttpClientController {
    @RequestMapping("index")
    public String index()
    {
        return "index";
    }
    @RequestMapping("getTest")
    @ResponseBody
    public Users getTest(String user)
    {
        Users users = JSONObject.parseObject(user, Users.class);
        Users user1=new Users();
        user1.setName(users.getName());
        return user1;
    }
    @RequestMapping("getData")
    @ResponseBody
    public Map<String,Object> getData()
    {
        //星期
        List<String> listDay=null;
        //温度
        List<Integer> listHigh=null;
        //1.创建HttpClient对象
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建url对象，传递参数
        URI uri=null;
        // String str= JSONObject.toJSONString("北京");
        try {
            uri=new URIBuilder("http://wthrcdn.etouch.cn/weather_mini").setParameter("city","北京").build();
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
                Sun sun=JSONObject.parseObject(content,Sun.class);
                Data data = JSONObject.parseObject(sun.getData(), Data.class);
                List<Forecast> forecasts = JSONObject.parseArray(data.getForecast(), Forecast.class);
                listDay=new ArrayList<>();
                listHigh=new ArrayList<>();
                for (Forecast forecast: forecasts) {
                    listDay.add(forecast.getDate());
                }
                for (Forecast forecast: forecasts) {
                    String[] substring = forecast.getHigh().split(" ");
                    for (String s : substring) {
                        if(!s.equals("高温")) {
                            listHigh.add(Integer.parseInt(s.substring(0, s.length() -1)));
                        }
                    }
                }
                System.out.println(listDay.toString());
                System.out.println(listHigh.toString());
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
           Map<String,Object> map=new HashMap<>();
//        String [] eategories={"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"};
        String [] eategories=new String[listDay.size()];
        for(int i = 0 ;i < listDay.size() ; i++){
            eategories[i]= listDay.get(i);
        }
        //        int [] data={5,20,36,10,10,20};
        int [] data = new int[listHigh.size()];
        for(int i = 0 ;i < listHigh.size() ; i++){
            data[i] = listHigh.get(i);
        }
        map.put("eategories",eategories);
        map.put("data",data);
         return map;
    }
    @RequestMapping("getCovid")
    @ResponseBody
    public Map<String,Object> getCovid()
    {
        List<Covid> covidList=new ArrayList<>();
        //1.创建HttpClient对象
        CloseableHttpClient httpClient= HttpClients.createDefault();
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
                for (JSONObject data : datas) {
                    cities = (List<JSONObject>)data.get("cities");
                }
                for (JSONObject city : cities) {
                    Covid covids=JSONObject.parseObject(city.toJSONString(),Covid.class);
                    covidList.add(covids);
                }

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
        Map<String,Object> map=new HashMap<>();
//        String [] eategories={"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"};

        //        int [] data={5,20,36,10,10,20};
        String [] cityName=new String[covidList.size()];
        //累计确诊
        int [] confirmedCount=new int[covidList.size()];
        //当前确诊
        int [] currentConfirmedCount=new int[covidList.size()];
        //累计治愈
        int [] curedCount=new int[covidList.size()];
        for (int i = 0; i < covidList.size(); i++) {
            cityName[i]=covidList.get(i).getCityName();
        }
        for (int i = 0; i < covidList.size(); i++) {
            confirmedCount[i]=Integer.parseInt(covidList.get(i).getConfirmedCount());
        }
        for (int i = 0; i < covidList.size(); i++) {
            currentConfirmedCount[i]=Integer.parseInt(covidList.get(i).getCurrentConfirmedCount());
        }
        for (int i = 0; i < covidList.size(); i++) {
            curedCount[i]=Integer.parseInt(covidList.get(i).getCuredCount());
        }
        map.put("cityName",cityName);
        map.put("confirmedCount",confirmedCount);
        map.put("curedCount",curedCount);
        map.put("currentConfirmedCount",currentConfirmedCount);
        return map;
    }
    @RequestMapping("covid")
    public String covid()
    {
        return "covid";
    }

}