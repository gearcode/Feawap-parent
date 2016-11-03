package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.Config;
import com.gearcode.feawap.domain.ConfigExample;
import com.gearcode.feawap.domain.ConfigWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ConfigMapper {
    int countByExample(ConfigExample example);

    int deleteByExample(ConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigWithBLOBs record);

    int insertSelective(ConfigWithBLOBs record);

    List<ConfigWithBLOBs> selectByExampleWithBLOBsWithRowbounds(ConfigExample example, RowBounds rowBounds);

    List<ConfigWithBLOBs> selectByExampleWithBLOBs(ConfigExample example);

    List<Config> selectByExampleWithRowbounds(ConfigExample example, RowBounds rowBounds);

    List<Config> selectByExample(ConfigExample example);

    ConfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigWithBLOBs record, @Param("example") ConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") ConfigWithBLOBs record, @Param("example") ConfigExample example);

    int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByPrimaryKeySelective(ConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConfigWithBLOBs record);

    int updateByPrimaryKey(Config record);
}