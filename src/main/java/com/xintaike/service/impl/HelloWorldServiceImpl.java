package com.xintaike.service.impl;

import com.github.pagehelper.PageHelper;
import com.xintaike.dao.HelloMapper;
import com.xintaike.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by jay on 2020/4/1.
 */
@Service
@Transactional
public class HelloWorldServiceImpl implements HelloWorldService{

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public List<Map<String, Object>> find() {
        PageHelper.startPage(1,10);
        return helloMapper.find();
    }
}
