package carshare;

public class PointCanceled extends AbstractEvent {

    private Long id;
    private Integer orderId;
    private Long point;
    private String status;

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