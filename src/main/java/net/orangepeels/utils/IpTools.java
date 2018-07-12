package net.orangepeels.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class IpTools {
    private String countryName;
    private String countryNameZhCN;
    private String subdivisionName;
    private String subdivisionNameZhCN;
    private String cityName;
    private String cityNameZhCN;

    public void resolveIp(String ip) throws IOException, GeoIp2Exception {
        // 得到地区数据库文件
//        ClassPathResource resource = new ClassPathResource("common/GeoLite2-City.mmdb");
//        InputStream database = resource.getInputStream();
        String path = System.getProperty("user.dir");
        File database = new File(path + "/common/GeoLite2-City.mmdb");
        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        InetAddress ipAddress = InetAddress.getByName(ip);
        // 获取查询结果
        CityResponse response = reader.city(ipAddress);
        // 得到国家
        Country country = response.getCountry();
        this.countryName = country.getName();
        this.countryNameZhCN = country.getNames().get("zh-CN");
        // 获得省份
        Subdivision subdivision = response.getMostSpecificSubdivision();
        this.subdivisionName = subdivision.getName();
        this.subdivisionNameZhCN = subdivision.getNames().get("zh-CH");
        // 获得城市
        City city = response.getCity();
        this.cityName = city.getName();
        this.cityNameZhCN = city.getNames().get("zh-CH");
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryNameZhCN() {
        return countryNameZhCN;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityNameZhCN() {
        return cityNameZhCN;
    }

    public String getSubdivisionName() {
        return subdivisionName;
    }

    public String getSubdivisionNameZhCN() {
        return subdivisionNameZhCN;
    }
}
