package com.slk.tempService;

import org.springframework.stereotype.Service;

import com.slk.temp.Temp;

@Service
public class TempService {
	public String temp(){
		Temp temp = new Temp("aaaaa");
		return temp.getName();
	}
}
