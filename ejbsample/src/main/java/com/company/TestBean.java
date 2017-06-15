package com.company;

import javax.sql.DataSource;

/**
 * Created by efabapo on 1/25/17.
 */
public class TestBean implements TestLocal{

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    @Override
    public String test(String test) {
        return test;
    }

    public void testSchedule() {
        System.out.print("XXXXXXXXXXX ------- DD Testbean");
    }

    public void testSingleAction(){
        System.out.print("XXXXXXXXXXX---------- DD Single action");
    }

}
