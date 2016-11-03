package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Applicant;
import com.gearcode.feawap.domain.ApplicantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicantMapper {
    int countByExample(ApplicantExample example);

    int deleteByExample(ApplicantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Applicant record);

    int insertSelective(Applicant record);

    List<Applicant> selectByExampleWithRowbounds(ApplicantExample example, RowBounds rowBounds);

    List<Applicant> selectByExample(ApplicantExample example);

    Applicant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Applicant record, @Param("example") ApplicantExample example);

    int updateByExample(@Param("record") Applicant record, @Param("example") ApplicantExample example);

    int updateByPrimaryKeySelective(Applicant record);

    int updateByPrimaryKey(Applicant record);
}