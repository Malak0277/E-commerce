package application;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
	 private List<Order> orderHistory;

	    public OrderHistory() {
	        this.orderHistory = new ArrayList<>();
	    }
	    public int getOrdersHistorysize() {
	        return orderHistory.size();
	    }
}
