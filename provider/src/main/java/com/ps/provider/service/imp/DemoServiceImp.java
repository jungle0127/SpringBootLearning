package com.ps.provider.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ps.provider.spi.DemoService;

@Service(interfaceClass=DemoService.class)
@Component
public class DemoServiceImp implements DemoService {

	@Override
	public List<String> getPermissions(Long id) {
		List<String> demo = new ArrayList<String>();
		demo.add(String.format("Permission_%d", id - 1));
		demo.add(String.format("Permission_%d", id));
		demo.add(String.format("Permission_%d", id + 1));
		return demo;
	}

}
