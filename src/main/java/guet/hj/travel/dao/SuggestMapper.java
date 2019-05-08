package guet.hj.travel.dao;

import guet.hj.travel.entity.Suggest;
import guet.hj.travel.entity.SuggestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggestMapper {
    int countByExample(SuggestExample example);

    int deleteByExample(SuggestExample example);

    int deleteByPrimaryKey(Long suggestId);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    List<Suggest> selectByExample(SuggestExample example);

    Suggest selectByPrimaryKey(Long suggestId);

    int updateByExampleSelective(@Param("record") Suggest record, @Param("example") SuggestExample example);

    int updateByExample(@Param("record") Suggest record, @Param("example") SuggestExample example);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);
}