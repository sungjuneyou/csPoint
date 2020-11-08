package carshare;

import carshare.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_Offer(@Payload Shipped shipped){

        if(shipped.isMe()){
            System.out.println("##### listener Offer : " + shipped.toJson());

            Point point = new Point();
            point.setOrderId(shipped.getOrderId());
            point.setPoint(100000L);
            point.setStatus("PointOffered");

            pointRepository.save(point) ;

        }
    }

}
