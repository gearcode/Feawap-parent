package com.gearcode.feawap.persistence;

import com.gearcode.feawap.domain.UserFavorite;
import com.gearcode.feawap.domain.UserFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserFavoriteMapper {
    int countByExample(UserFavoriteExample example);

    int deleteByExample(UserFavoriteExample example);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    List<UserFavorite> selectByExampleWithRowbounds(UserFavoriteExample example, RowBounds rowBounds);

    List<UserFavorite> selectByExample(UserFavoriteExample example);

    int updateByExampleSelective(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    int updateByExample(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);
}