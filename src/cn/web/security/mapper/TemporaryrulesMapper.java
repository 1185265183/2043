package cn.web.security.mapper;

import cn.web.security.pojo.Temporaryrules;
import cn.web.security.pojo.TemporaryrulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemporaryrulesMapper {
    int countByExample(TemporaryrulesExample example);

    int deleteByExample(TemporaryrulesExample example);

    int deleteByPrimaryKey(String rkey);

    int insert(Temporaryrules record);

    int insertSelective(Temporaryrules record);

    List<Temporaryrules> selectByExample(TemporaryrulesExample example);

    Temporaryrules selectByPrimaryKey(String rkey);

    int updateByExampleSelective(@Param("record") Temporaryrules record, @Param("example") TemporaryrulesExample example);

    int updateByExample(@Param("record") Temporaryrules record, @Param("example") TemporaryrulesExample example);

    int updateByPrimaryKeySelective(Temporaryrules record);

    int updateByPrimaryKey(Temporaryrules record);
}