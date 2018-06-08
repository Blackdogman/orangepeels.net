package net.orangepeels.dao;

import net.orangepeels.model.BlogMarkDown;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogMarkDownDao {
    @Insert("INSERT INTO blog_markdown (id, up_date, file_name, content, flag) VALUES (NULL,now(),#{file_name},#{content},1)")
    public int insert(
            @Param("file_name") String fileName,
            @Param("content") String content
    );

    @Select("SELECT * FROM blog_markdown WHERE id = #{id}")
    public BlogMarkDown select(@Param("id") int id);
}
