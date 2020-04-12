import com.example.random.service.RandomNumberService;

module com.example.lottery {
	requires com.example.random;
	exports com.example.lottery.service;
	uses RandomNumberService;
	provides com.example.lottery.service.LotteryService with com.example.lottery.service.business.SimpleLotteryService;
}