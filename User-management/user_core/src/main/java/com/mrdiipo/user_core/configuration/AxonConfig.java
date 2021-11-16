//package com.mrdiipo.user_core.configuration;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
//import org.axonframework.extensions.mongo.DefaultMongoTemplate;
//import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//public class AxonConfig {
//
//    @Value("${spring.data.mongodb.host:127.0.0.1}")
//    private String mongoHost;
//
//    @Value("${spring.data.mongodb.port:27017}")
//    private int mongoPort;
//
//    @Value("${spring.data.mongodb.database:user}")
//    private  String mongoDatabase;
//
//
//    @Bean
//    public MongoClient mongoClient(){
//        return MongoClients.create(mongoHost);
//    }
//
//    @Bean
//    public MongoTemplate axonMongoTemplate(){
//        return new MongoTemplate(mongoClient(), mongoDatabase);
//    }
//
//    @Bean
//    public EventStorageEngine storageEngine(MongoClient mongoClient){
//        return MongoEventStorageEngine.builder()
//                .mongoTemplate(DefaultMongoTemplate.builder()
//                        .mongoDatabase(mongoClient).build()).build();
//    }
//}
//
//
