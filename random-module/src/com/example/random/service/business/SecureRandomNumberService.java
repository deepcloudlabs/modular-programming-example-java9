package com.example.random.service.business;

import java.security.SecureRandom;
import java.util.Random;

import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@Quality(QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {
	private Random rand = new SecureRandom();

	public SecureRandomNumberService() {
		System.err.println("SecureRandomNumberService is created!");
	}

	@Override
	public int generate(int min, int max) {
		System.err.println("SECURE implementation is used!");
		return rand.nextInt(max - min) + min;
	}

}
