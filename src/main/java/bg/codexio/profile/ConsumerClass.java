package bg.codexio.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerClass {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerClass.class);

    @KafkaListener(topics = "user")
    public void consume() {
        logger.info("******* Consumer just received the message");
    }
}
