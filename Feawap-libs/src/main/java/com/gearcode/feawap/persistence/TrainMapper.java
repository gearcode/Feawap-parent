package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Train;
import com.gearcode.feawap.domain.TrainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TrainMapper {
    int countByExample(TrainExample example);

    int deleteByExample(TrainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Train record);

    int insertSelective(Train record);

    List<Train> selectByExampleWithBLOBsWithRowbounds(TrainExample example, RowBounds rowBounds);

    List<Train> selectByExampleWithBLOBs(TrainExample example);

    List<Train> selectByExampleWithRowbounds(TrainExample example, RowBounds rowBounds);

    List<Train> selectByExample(TrainExample example);

    Train selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Train record, @Param("example") TrainExample example);

    int updateByExampleWithBLOBs(@Param("record") Train record, @Param("example") TrainExample example);

    int updateByExample(@Param("record") Train record, @Param("example") TrainExample example);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKeyWithBLOBs(Train record);

    int updateByPrimaryKey(Train record);
}