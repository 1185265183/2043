package cn.web.security.mapper;

import cn.web.security.pojo.Var;
import cn.web.security.pojo.VarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VarMapper {
    int countByExample(VarExample example);

    int deleteByExample(VarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Var record);

    int insertSelective(Var record);

    List<Var> selectByExample(VarExample example);

    Var selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Var record, @Param("example") VarExample example);

    int updateByExample(@Param("record") Var record, @Param("example") VarExample example);

    int updateByPrimaryKeySelective(Var record);

    int updateByPrimaryKey(Var record);
}