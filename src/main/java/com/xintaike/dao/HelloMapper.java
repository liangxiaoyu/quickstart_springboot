package com.xintaike.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by jay on 2020/3/25.
 */
@Mapper
public interface HelloMapper {

//    Map<String, Object> getMsg(@Param("userName")String userName
//            , @Param("password")String password);
    Map<String, Object> Hello();

    List<Map<String,Object>> find();
}
