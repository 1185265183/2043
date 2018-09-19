package cn.web.security.mapper;

import cn.web.security.pojo.ClassmentInfoView;
import cn.web.security.pojo.ClassmentInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassmentInfoViewMapper {
    long countByExample(ClassmentInfoViewExample example);

    int deleteByExample(ClassmentInfoViewExample example);

    int insert(ClassmentInfoView record);

    int insertSelective(ClassmentInfoView record);

    List<ClassmentInfoView> selectByExample(ClassmentInfoViewExample example);

    int updateByExampleSelective(@Param("record") ClassmentInfoView record, @Param("example") ClassmentInfoViewExample example);

    int updateByExample(@Param("record") ClassmentInfoView record, @Param("example") ClassmentInfoViewExample example);
}