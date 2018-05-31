package net.orangepeels.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTools {
    private final String RESOURCE = "/mybatis-config.xml";

    public void test (){
        try {
            InputStream stream = Resources.getResourceAsStream(RESOURCE);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
