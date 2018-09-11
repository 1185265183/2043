package cn.web.security.mapper;

import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.CallfunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CallfunctionMapper {
    int countByExample(CallfunctionExample example);

    int deleteByExample(CallfunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Callfunction record);

    int insertSelective(Callfunction record);

    List<Callfunction> selectByExample(CallfunctionExample example);

    Callfunction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Callfunction record, @Param("example") CallfunctionExample example);

    int updateByExample(@Param("record") Callfunction record, @Param("example") CallfunctionExample example);

    int updateByPrimaryKeySelective(Callfunction record);

    int updateByPrimaryKey(Callfunction record);
}