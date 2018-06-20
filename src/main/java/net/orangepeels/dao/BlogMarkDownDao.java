package net.orangepeels.dao;

import net.orangepeels.model.BlogMarkDown;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMarkDownDao {
    @Insert("INSERT INTO blog_markdown (id, up_date, file_name, content, flag, md5_code) VALUES (NULL,now(),#{file_name},#{content},1,#{md5_code})")
    public int insert(
            @Param("file_name") String fileName,
            @Param("content") String content,
            @Param("md5_code") String md5Code
    );

    @Select("SELECT * FROM blog_markdown WHERE id = #{id}")
    public BlogMarkDown select(@Param("id") String id);

    @Select("SELECT * FROM blog_markdown WHERE 1=1")
    public List<BlogMarkDown> selectAll();
}
