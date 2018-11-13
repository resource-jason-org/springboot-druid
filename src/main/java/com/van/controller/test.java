package com.van.controller;

import com.van.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test/")
public class test {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate rep1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate rep2;

    @Autowired
    @Qualifier("tertiaryJdbcTemplate")
    private JdbcTemplate rep3;

    @Autowired
    @Qualifier("quaternaryJdbcTemplate")
    private JdbcTemplate rep4;

    @RequestMapping(value = "test")
    public String create() {
        String result = null;

        String sql = "select * FROM aci_admin";
        //rep4.query("select 1");
        List list = rep4.queryForList(sql);

//        Admin a = rep4.queryForObject(sql,Admin.class);


       // System.out.println(a);

        System.out.println(list);


        List adminList = new ArrayList();


        for(Iterator iterators = list.iterator(); iterators.hasNext();){

            Admin admin = new Admin();
            Map map = (Map) iterators.next();
            System.out.println( map.get("id"));
            admin.setId(map.get("id").toString());
            adminList.add(admin);

/*
            for(String it : iterators ){

            }
*/

        }

        return result;
    }


}
