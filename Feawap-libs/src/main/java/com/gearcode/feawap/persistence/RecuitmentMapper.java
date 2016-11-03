package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Recuitment;
import com.gearcode.feawap.domain.RecuitmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RecuitmentMapper {
    int countByExample(RecuitmentExample example);

    int deleteByExample(RecuitmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recuitment record);

    int insertSelective(Recuitment record);

    List<Recuitment> selectByExampleWithBLOBsWithRowbounds(RecuitmentExample example, RowBounds rowBounds);

    List<Recuitment> selectByExampleWithBLOBs(RecuitmentExample example);

    List<Recuitment> selectByExampleWithRowbounds(RecuitmentExample example, RowBounds rowBounds);

    List<Recuitment> selectByExample(RecuitmentExample example);

    Recuitment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recuitment record, @Param("example") RecuitmentExample example);

    int updateByExampleWithBLOBs(@Param("record") Recuitment record, @Param("example") RecuitmentExample example);

    int updateByExample(@Param("record") Recuitment record, @Param("example") RecuitmentExample example);

    int updateByPrimaryKeySelective(Recuitment record);

    int updateByPrimaryKeyWithBLOBs(Recuitment record);

    int updateByPrimaryKey(Recuitment record);
}