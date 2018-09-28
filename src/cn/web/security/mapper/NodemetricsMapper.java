package cn.web.security.mapper;

import cn.web.security.pojo.Nodemetrics;
import cn.web.security.pojo.NodemetricsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NodemetricsMapper {
    long countByExample(NodemetricsExample example);

    int deleteByExample(NodemetricsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nodemetrics record);

    int insertSelective(Nodemetrics record);

    List<Nodemetrics> selectByExample(NodemetricsExample example);

    Nodemetrics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nodemetrics record, @Param("example") NodemetricsExample example);

    int updateByExample(@Param("record") Nodemetrics record, @Param("example") NodemetricsExample example);

    int updateByPrimaryKeySelective(Nodemetrics record);

    int updateByPrimaryKey(Nodemetrics record);
}