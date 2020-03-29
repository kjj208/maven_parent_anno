package cn.cj.dao;
import cn.cj.domain.Account;
import java.util.List;

import com.sun.tools.javac.jvm.Items;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * (Account)表数据库访问层
 *
 * @author kjj208
 * @since 2020-03-27 23:06:50 */
@Repository
public interface AccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from account where id=#{id}")
    @Results(id="myResultMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "money",property = "money")
    })
     Account findById(Integer id);

}