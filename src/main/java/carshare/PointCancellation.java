package carshare;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PointCancellation_table")
public class PointCancellation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer orderId;
    private Long point;
    private String status;

    @PostPersist
    public void onPostPersist(){
        PointCanceled pointCanceled = new PointCanceled();
        BeanUtils.copyProperties(this, pointCanceled);
        pointCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
