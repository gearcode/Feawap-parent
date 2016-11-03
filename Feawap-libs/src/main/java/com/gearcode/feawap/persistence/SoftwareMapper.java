package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Software;
import com.gearcode.feawap.domain.SoftwareExample;
import com.gearcode.feawap.domain.SoftwareWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SoftwareMapper {
    int countByExample(SoftwareExample example);

    int deleteByExample(SoftwareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SoftwareWithBLOBs record);

    int insertSelective(SoftwareWithBLOBs record);

    List<SoftwareWithBLOBs> selectByExampleWithBLOBsWithRowbounds(SoftwareExample example, RowBounds rowBounds);

    List<SoftwareWithBLOBs> selectByExampleWithBLOBs(SoftwareExample example);

    List<Software> selectByExampleWithRowbounds(SoftwareExample example, RowBounds rowBounds);

    List<Software> selectByExample(SoftwareExample example);

    SoftwareWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SoftwareWithBLOBs record, @Param("example") SoftwareExample example);

    int updateByExampleWithBLOBs(@Param("record") SoftwareWithBLOBs record, @Param("example") SoftwareExample example);

    int updateByExample(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByPrimaryKeySelective(SoftwareWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SoftwareWithBLOBs record);

    int updateByPrimaryKey(Software record);
}