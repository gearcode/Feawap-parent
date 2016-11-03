package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Consultation;
import com.gearcode.feawap.domain.ConsultationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ConsultationMapper {
    int countByExample(ConsultationExample example);

    int deleteByExample(ConsultationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Consultation record);

    int insertSelective(Consultation record);

    List<Consultation> selectByExampleWithBLOBsWithRowbounds(ConsultationExample example, RowBounds rowBounds);

    List<Consultation> selectByExampleWithBLOBs(ConsultationExample example);

    List<Consultation> selectByExampleWithRowbounds(ConsultationExample example, RowBounds rowBounds);

    List<Consultation> selectByExample(ConsultationExample example);

    Consultation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consultation record, @Param("example") ConsultationExample example);

    int updateByExampleWithBLOBs(@Param("record") Consultation record, @Param("example") ConsultationExample example);

    int updateByExample(@Param("record") Consultation record, @Param("example") ConsultationExample example);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKeyWithBLOBs(Consultation record);

    int updateByPrimaryKey(Consultation record);
}