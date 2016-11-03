package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.FeedbackCourseInterest;
import com.gearcode.feawap.domain.FeedbackCourseInterestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FeedbackCourseInterestMapper {
    int countByExample(FeedbackCourseInterestExample example);

    int deleteByExample(FeedbackCourseInterestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackCourseInterest record);

    int insertSelective(FeedbackCourseInterest record);

    List<FeedbackCourseInterest> selectByExampleWithRowbounds(FeedbackCourseInterestExample example, RowBounds rowBounds);

    List<FeedbackCourseInterest> selectByExample(FeedbackCourseInterestExample example);

    FeedbackCourseInterest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackCourseInterest record, @Param("example") FeedbackCourseInterestExample example);

    int updateByExample(@Param("record") FeedbackCourseInterest record, @Param("example") FeedbackCourseInterestExample example);

    int updateByPrimaryKeySelective(FeedbackCourseInterest record);

    int updateByPrimaryKey(FeedbackCourseInterest record);
}