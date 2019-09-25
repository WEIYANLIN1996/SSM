package com.wyl.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.INEG;
import com.wyl.com.maindom.Student;
import com.wyl.ssm.Dao.FirstMapper;

@Service
public class DemoService {
    @Resource
    private FirstMapper demoMapper;
    public Student findAllDemo(){
    	
        return demoMapper.findAllDemo();
    }
}
