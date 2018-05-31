package net.orangepeels.dao;


import net.orangepeels.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM users WHERE id=#{id}")
    public User selectUserById(@Param("id") Integer id);
}
