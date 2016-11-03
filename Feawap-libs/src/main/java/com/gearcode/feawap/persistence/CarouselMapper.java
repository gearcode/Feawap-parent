package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Carousel;
import com.gearcode.feawap.domain.CarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CarouselMapper {
    int countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExampleWithRowbounds(CarouselExample example, RowBounds rowBounds);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}