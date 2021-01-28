package bg.codexio.profile.kafka.consumer;

import bg.codexio.profile.entity.User;
import bg.codexio.profile.kafka.payload.RegisterDetails;
import bg.codexio.profile.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public Consumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "register")
    public void registerInDb(RegisterDetails registerDetails){
        long id = registerDetails.getId();
        User user = new User();
        user.setId(id);
        userRepository.save(user);
        logger.info("Successfully register!");
    }
}
