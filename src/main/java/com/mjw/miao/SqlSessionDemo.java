package com.mjw.miao;

import com.mjw.miao.dao.Video;
import com.mjw.miao.mapper.VideoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {

        String resouce = "config/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resouce);

        // 构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取Session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
//            Video video = videoMapper.selectById(44);
            // 通过注解
//            List<Video> videoList = videoMapper.selectList();
            // 通过XML
//            List<Video> videoList = videoMapper.selectListByXML();
//            List<Video> videoList = videoMapper.selectByPointAndTitleLike(8.7, "HTML");
//            System.out.println(" selectById " + video.toString());
//            System.out.println(" selectList " + videoList);
//            List<Video> list = new ArrayList<>();
//            Video video1 = new Video();
//            video1.setId(48);
//            video1.setTitle("Java从入门到精通222");
//            video1.setSummary("知识就是力量111");
//            video1.setCoverImg("aa.ttt");
//            video1.setPrice(2000);
//            video1.setCreateTime(new Date());
//            video1.setPoint(8.8);
//            Video video2 = new Video();
//            video2.setTitle("Java从入门到精通2");
//            video2.setSummary("知识就是力量2");
//            video2.setCoverImg("aa.ttt");
//            video2.setPrice(2000);
//            video2.setCreateTime(new Date());
//            video2.setPoint(8.8);
//            list.add(video1);
//            list.add(video2);

            Date createTime = new Date();   
            System.out.println(createTime);
            int price = 2000;
            Map<String,Object> map = new HashMap<>();
            map.put("createTime",createTime);
            map.put("price",price);
            videoMapper.deleteByCreateTimeAndPrice(map);
        }

    }
}
