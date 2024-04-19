
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class Order {
    private Cart cart;
    private double shippingPrice;
    private double totalPrice;
    private String status;
    private String OrderID;
    private Timer timer;
    private String Address;
    private String Phonenumber;

    public void orderRequest(String Address, String Phonenumber)
    {
        this.Address = Address;
        this.Phonenumber = Phonenumber;
    }

    public Order (Cart cart, double totPrice, String status)
    {
        this.cart = cart;
        this.totalPrice = calc_totalPrice(totPrice);
        this.status = status;
        this.OrderID = OrderIDGenerate();
        this.timer = new Timer();
        scheduleStatusUpdate();
    }

    private void scheduleStatusUpdate() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateOrderStatus();
            }
        }, 0, 120 * 1000); // 120 seconds = 2 minute
    }

    private void updateOrderStatus() {
        if (status.equals("Order_Placed")) {
            setStatus("Packed");
        } else if (status.equals("Packed")) {
            setStatus("Dispatch");
        }
        else if (status.equals("Dispatch")) {
            setStatus("Delivered");
        }
    }

    public double calc_totalPrice(double totPrice)
    {
        if(totPrice < 1000)
            shippingPrice = 100;
        
        else
            shippingPrice = 0;

        return totPrice + shippingPrice;
    }

    private String OrderIDGenerate()
    {
        String randomUUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        String orderId = "ORD-" + randomUUID;
        
        return orderId;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String newStatus){
        this.status=newStatus;
    }
    public String getOrderID(){
        return this.OrderID;
    }
    public void cancel_order() {
        setStatus("Cancelled");}
}

