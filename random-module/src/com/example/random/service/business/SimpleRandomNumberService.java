package com.example.random.service.business;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@Quality(QualityLevel.SIMPLE)
public class SimpleRandomNumberService implements RandomNumberService {
	private Random rand = ThreadLocalRandom.current();

	public SimpleRandomNumberService() {
		System.err.println("SimpleRandomNumberService is created!");
	}

	@Override
	public int generate(int min, int max) {
		System.err.println("CHEAP implementation is used!");
		return rand.nextInt(max - min + 1) + min;
	}

}
