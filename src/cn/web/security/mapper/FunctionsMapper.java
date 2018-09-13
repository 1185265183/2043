package cn.web.security.mapper;

import cn.web.security.pojo.Functions;
import cn.web.security.pojo.FunctionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionsMapper {
    int countByExample(FunctionsExample example);

    int deleteByExample(FunctionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Functions record);

    int insertSelective(Functions record);

    List<Functions> selectByExample(FunctionsExample example);

    Functions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Functions record, @Param("example") FunctionsExample example);

    int updateByExample(@Param("record") Functions record, @Param("example") FunctionsExample example);

    int updateByPrimaryKeySelective(Functions record);

    int updateByPrimaryKey(Functions record);
}