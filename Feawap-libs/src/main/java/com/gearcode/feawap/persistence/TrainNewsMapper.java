package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.TrainNews;
import com.gearcode.feawap.domain.TrainNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TrainNewsMapper {
    int countByExample(TrainNewsExample example);

    int deleteByExample(TrainNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainNews record);

    int insertSelective(TrainNews record);

    List<TrainNews> selectByExampleWithBLOBsWithRowbounds(TrainNewsExample example, RowBounds rowBounds);

    List<TrainNews> selectByExampleWithBLOBs(TrainNewsExample example);

    List<TrainNews> selectByExampleWithRowbounds(TrainNewsExample example, RowBounds rowBounds);

    List<TrainNews> selectByExample(TrainNewsExample example);

    TrainNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainNews record, @Param("example") TrainNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") TrainNews record, @Param("example") TrainNewsExample example);

    int updateByExample(@Param("record") TrainNews record, @Param("example") TrainNewsExample example);

    int updateByPrimaryKeySelective(TrainNews record);

    int updateByPrimaryKeyWithBLOBs(TrainNews record);

    int updateByPrimaryKey(TrainNews record);
}