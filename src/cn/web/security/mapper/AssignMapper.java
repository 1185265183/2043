package cn.web.security.mapper;

import cn.web.security.pojo.Assign;
import cn.web.security.pojo.AssignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssignMapper {
    int countByExample(AssignExample example);

    int deleteByExample(AssignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Assign record);

    int insertSelective(Assign record);

    List<Assign> selectByExample(AssignExample example);

    Assign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Assign record, @Param("example") AssignExample example);

    int updateByExample(@Param("record") Assign record, @Param("example") AssignExample example);

    int updateByPrimaryKeySelective(Assign record);

    int updateByPrimaryKey(Assign record);
}