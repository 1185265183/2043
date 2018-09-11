package cn.web.security.mapper;

import cn.web.security.pojo.Classment;
import cn.web.security.pojo.ClassmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassmentMapper {
    int countByExample(ClassmentExample example);

    int deleteByExample(ClassmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classment record);

    int insertSelective(Classment record);

    List<Classment> selectByExample(ClassmentExample example);

    Classment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classment record, @Param("example") ClassmentExample example);

    int updateByExample(@Param("record") Classment record, @Param("example") ClassmentExample example);

    int updateByPrimaryKeySelective(Classment record);

    int updateByPrimaryKey(Classment record);
}