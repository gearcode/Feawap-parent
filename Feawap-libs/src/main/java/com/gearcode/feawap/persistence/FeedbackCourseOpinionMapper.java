package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.FeedbackCourseOpinion;
import com.gearcode.feawap.domain.FeedbackCourseOpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FeedbackCourseOpinionMapper {
    int countByExample(FeedbackCourseOpinionExample example);

    int deleteByExample(FeedbackCourseOpinionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackCourseOpinion record);

    int insertSelective(FeedbackCourseOpinion record);

    List<FeedbackCourseOpinion> selectByExampleWithRowbounds(FeedbackCourseOpinionExample example, RowBounds rowBounds);

    List<FeedbackCourseOpinion> selectByExample(FeedbackCourseOpinionExample example);

    FeedbackCourseOpinion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackCourseOpinion record, @Param("example") FeedbackCourseOpinionExample example);

    int updateByExample(@Param("record") FeedbackCourseOpinion record, @Param("example") FeedbackCourseOpinionExample example);

    int updateByPrimaryKeySelective(FeedbackCourseOpinion record);

    int updateByPrimaryKey(FeedbackCourseOpinion record);
}