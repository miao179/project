package com.mjw.miao.mapper;

import com.mjw.miao.dao.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface VideoMapper{
    /**
     * 根据视频id查找视频对象
     * @param viedoId
     * @return
     */
    Video selectById(@Param("video_id") int viedoId);

    /**
     * 查询全部视频列表
     * @return
     */
    @Select("select * from video;")
    List<Video> selectList();

    /**
     * 查询全部视频列表 == 通过注解
     * @return
     */
    List<Video> selectListByXML();

    /**
     * 根据评分和标题模糊查询
     * @param point
     * @param title
     * @return
     */
//    List<Video> selectByPointAndTitleLike(@Param("point") double point,
//                                          @Param("title") String title);
    //使用默认(param1,param2,param3,...)
    List<Video> selectByPointAndTitleLike(double point,
                                          String title);

    /**
     * 新增一条视频
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int addBatch(List<Video> list);

    /**
     * 更新视频
     * @param video
     * @return
     */
    int updateVideo(Video video);
    /**
     * 选择更新视频
     * @param video
     * @return
     */
    int updateVideoSelective(Video video);
    /**
     * 根据创建时间和价格进行条件删除
     */
    int deleteByCreateTimeAndPrice(Map<String ,Object> map);
}
