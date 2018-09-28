package cn.web.security.mapper;

import cn.web.security.pojo.Networkmetrics;
import cn.web.security.pojo.NetworkmetricsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkmetricsMapper {
    long countByExample(NetworkmetricsExample example);

    int deleteByExample(NetworkmetricsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Networkmetrics record);

    int insertSelective(Networkmetrics record);

    List<Networkmetrics> selectByExample(NetworkmetricsExample example);

    Networkmetrics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Networkmetrics record, @Param("example") NetworkmetricsExample example);

    int updateByExample(@Param("record") Networkmetrics record, @Param("example") NetworkmetricsExample example);

    int updateByPrimaryKeySelective(Networkmetrics record);

    int updateByPrimaryKey(Networkmetrics record);
}