package guet.hj.travel.dao;

import guet.hj.travel.entity.NewsLabel;
import guet.hj.travel.entity.NewsLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsLabelMapper {
    int countByExample(NewsLabelExample example);

    int deleteByExample(NewsLabelExample example);

    int deleteByPrimaryKey(Integer labelId);

    int insert(NewsLabel record);

    int insertSelective(NewsLabel record);

    List<NewsLabel> selectByExample(NewsLabelExample example);

    NewsLabel selectByPrimaryKey(Integer labelId);

    int updateByExampleSelective(@Param("record") NewsLabel record, @Param("example") NewsLabelExample example);

    int updateByExample(@Param("record") NewsLabel record, @Param("example") NewsLabelExample example);

    int updateByPrimaryKeySelective(NewsLabel record);

    int updateByPrimaryKey(NewsLabel record);
}