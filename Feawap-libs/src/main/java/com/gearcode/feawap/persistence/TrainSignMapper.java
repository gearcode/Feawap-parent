package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.TrainSign;
import com.gearcode.feawap.domain.TrainSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TrainSignMapper {
    int countByExample(TrainSignExample example);

    int deleteByExample(TrainSignExample example);

    int insert(TrainSign record);

    int insertSelective(TrainSign record);

    List<TrainSign> selectByExampleWithRowbounds(TrainSignExample example, RowBounds rowBounds);

    List<TrainSign> selectByExample(TrainSignExample example);

    int updateByExampleSelective(@Param("record") TrainSign record, @Param("example") TrainSignExample example);

    int updateByExample(@Param("record") TrainSign record, @Param("example") TrainSignExample example);
}