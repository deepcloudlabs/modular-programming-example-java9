package com.example.lottery.service;

import com.example.random.service.RandomNumberService;

import java.util.List;

public interface LotteryService {
	List<Integer> draw();
	List<List<Integer>> draw(int n);
	void setRandomNumberService(RandomNumberService randomNumberService);
}
