package cn.web.security.mapper;

import cn.web.security.pojo.Rules;
import cn.web.security.pojo.RulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RulesMapper {
    int countByExample(RulesExample example);

    int deleteByExample(RulesExample example);

    int deleteByPrimaryKey(String rkey);

    int insert(Rules record);

    int insertSelective(Rules record);

    List<Rules> selectByExample(RulesExample example);

    Rules selectByPrimaryKey(String rkey);

    int updateByExampleSelective(@Param("record") Rules record, @Param("example") RulesExample example);

    int updateByExample(@Param("record") Rules record, @Param("example") RulesExample example);

    int updateByPrimaryKeySelective(Rules record);

    int updateByPrimaryKey(Rules record);
}