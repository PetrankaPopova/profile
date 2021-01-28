package bg.codexio.profile.kafka.config;

import bg.codexio.profile.kafka.payload.RegisterDetails;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class Config {

    @Bean
    public ConsumerFactory<String, RegisterDetails> consumerFactory() {
        var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");


        var keyDeserializer = new StringDeserializer();


        var valueDeserializer = new JsonDeserializer<>(
                RegisterDetails.class,
                false
        );
        valueDeserializer.addTrustedPackages("*");


        return new DefaultKafkaConsumerFactory<>(
                configs,
                keyDeserializer,
                valueDeserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RegisterDetails> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RegisterDetails>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setMissingTopicsFatal(false);

        return factory;
    }
}