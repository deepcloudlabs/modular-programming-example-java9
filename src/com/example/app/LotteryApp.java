package com.example.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.function.Consumer;


import com.example.lottery.service.LotteryService;
import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		QualityLevel level = QualityLevel.valueOf(props.getProperty("random.number.service.level"));
		LotteryService sls = ServiceLoader.load(LotteryService.class).findFirst().get();
		sls.setRandomNumberService(extractService(level));
		Consumer<List<Integer>> println = System.err::println;
		sls.draw(10).forEach(println);
	}

	private static RandomNumberService extractService(QualityLevel level) {
		ServiceLoader<RandomNumberService> loader = ServiceLoader.load(RandomNumberService.class);
		RandomNumberService randomNumberService = null;
		for (RandomNumberService rns : loader) {
			Class<?> clazz = rns.getClass();
			if(clazz.isAnnotationPresent(Quality.class)) {
				Quality quality = clazz.getAnnotation(Quality.class);
				if (quality.value() == level) {
					randomNumberService = rns;
					break;
				}
			}
		}
		return randomNumberService;
	}

}
