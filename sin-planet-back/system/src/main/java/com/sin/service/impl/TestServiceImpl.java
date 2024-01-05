package com.sin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sin.domain.Test;
import com.sin.service.TestService;
import com.sin.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
* @author 26033
* @description 针对表【test】的数据库操作Service实现
* @createDate 2024-01-05 15:02:57
*/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test>
    implements TestService{

}




