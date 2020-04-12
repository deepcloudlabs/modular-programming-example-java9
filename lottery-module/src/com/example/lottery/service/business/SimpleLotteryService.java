package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;

public class SimpleLotteryService implements LotteryService {
    private RandomNumberService randomNumberService;

    @Override
    public void setRandomNumberService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @Override
    public List<Integer> draw() {
        return IntStream.generate(() -> randomNumberService.generate(1, 50))
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<List<Integer>> draw(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> this.draw())
                .collect(Collectors.toList());
    }

}
