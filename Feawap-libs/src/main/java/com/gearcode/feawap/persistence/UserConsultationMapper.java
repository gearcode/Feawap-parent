package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.UserConsultation;
import com.gearcode.feawap.domain.UserConsultationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserConsultationMapper {
    int countByExample(UserConsultationExample example);

    int deleteByExample(UserConsultationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserConsultation record);

    int insertSelective(UserConsultation record);

    List<UserConsultation> selectByExampleWithBLOBsWithRowbounds(UserConsultationExample example, RowBounds rowBounds);

    List<UserConsultation> selectByExampleWithBLOBs(UserConsultationExample example);

    List<UserConsultation> selectByExampleWithRowbounds(UserConsultationExample example, RowBounds rowBounds);

    List<UserConsultation> selectByExample(UserConsultationExample example);

    UserConsultation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserConsultation record, @Param("example") UserConsultationExample example);

    int updateByExampleWithBLOBs(@Param("record") UserConsultation record, @Param("example") UserConsultationExample example);

    int updateByExample(@Param("record") UserConsultation record, @Param("example") UserConsultationExample example);

    int updateByPrimaryKeySelective(UserConsultation record);

    int updateByPrimaryKeyWithBLOBs(UserConsultation record);

    int updateByPrimaryKey(UserConsultation record);
}