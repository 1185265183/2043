package cn.web.security.mapper;

import cn.web.security.pojo.VarInfoView;
import cn.web.security.pojo.VarInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarInfoViewMapper {
    long countByExample(VarInfoViewExample example);

    int deleteByExample(VarInfoViewExample example);

    int insert(VarInfoView record);

    int insertSelective(VarInfoView record);

    List<VarInfoView> selectByExample(VarInfoViewExample example);

    int updateByExampleSelective(@Param("record") VarInfoView record, @Param("example") VarInfoViewExample example);

    int updateByExample(@Param("record") VarInfoView record, @Param("example") VarInfoViewExample example);
}