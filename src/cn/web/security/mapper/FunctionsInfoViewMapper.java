package cn.web.security.mapper;

import cn.web.security.pojo.FunctionsInfoView;
import cn.web.security.pojo.FunctionsInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionsInfoViewMapper {
    long countByExample(FunctionsInfoViewExample example);

    int deleteByExample(FunctionsInfoViewExample example);

    int insert(FunctionsInfoView record);

    int insertSelective(FunctionsInfoView record);

    List<FunctionsInfoView> selectByExample(FunctionsInfoViewExample example);

    int updateByExampleSelective(@Param("record") FunctionsInfoView record, @Param("example") FunctionsInfoViewExample example);

    int updateByExample(@Param("record") FunctionsInfoView record, @Param("example") FunctionsInfoViewExample example);
}