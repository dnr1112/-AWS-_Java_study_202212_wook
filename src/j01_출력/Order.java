//package j01_출력;
//
//public class Order{
//	private int orderId;
//	private String productName;
//	private String consumerName;
//	private int price;
//	private int stock;
//	
//	private Order(OrderBuilder builder) {
//		this.orderId = orderId;
//		this.productName = productName;
//		this.consumerName = consumerName;
//		this.price = price;
//		this.stock = stock;
//	}
//	
//	public static class OrderBuilder {
//		private int orderId;
//		private String productName;
//		private String consumerName;
//		private int price;
//		private int stock;		
//	}
//	
//	public Order setOrderId(int orderId) {
//		this.orderId = orderId;
//		return this;
//	}
//	
//	public Order build() {
//		return new Order(this);
//	}
//	
//	
//	
//	public void showOrderInfo() {
//		
//	}
//}