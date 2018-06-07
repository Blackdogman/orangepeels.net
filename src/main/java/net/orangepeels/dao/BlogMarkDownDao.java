package net.orangepeels.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMarkDownDao {
    @Insert("INSERT INTO blog_markdown (id, up_date, file_name, content, flag) VALUES (NULL,now(),#{file_name},#{content},1)")
    public int insert(
            @Param("file_name") String fileName,
            @Param("content") String content
    );
}
