import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;

module com.example.lottery.app {
    requires com.example.lottery;
    requires com.example.random;
    uses LotteryService;
    uses RandomNumberService;
}