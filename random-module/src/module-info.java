module com.example.random {
    exports com.example.random.service;
    provides com.example.random.service.RandomNumberService with com.example.random.service.business.SimpleRandomNumberService, com.example.random.service.business.SecureRandomNumberService;
}