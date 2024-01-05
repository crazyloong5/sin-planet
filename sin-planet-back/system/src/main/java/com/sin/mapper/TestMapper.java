package com.sin.mapper;

import com.sin.domain.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 26033
* @description 针对表【test】的数据库操作Mapper
* @createDate 2024-01-05 15:02:57
* @Entity com.sin.domain.Test
*/
@Mapper
public interface TestMapper extends BaseMapper<Test> {

}




