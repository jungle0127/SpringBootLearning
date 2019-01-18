package com.ps.batis.procedure.runner;

import com.ps.batis.procedure.dao.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProcedureRunner implements CommandLineRunner {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public void run(String... args) throws Exception {
        String memberIds = "78be52e1-d532-4979-810b-69a8c86ed3c1,8fef8f3a-ab1b-4d1e-b094-1b260783b116**";
        String splitor = ",";

        this.userInfoRepository.test();
        System.out.println("");
    }
}
