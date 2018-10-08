package shopdb;
import java.util.Hashtable;

public class CartMgr {

	private Hashtable hcart=new Hashtable();
	
	public CartMgr(){
		
	}
	
	public void addCart(OrderDto orderDto){
		
		int pro_no=orderDto.getPro_no();
		String q=orderDto.getQuantity();
		int quantity=Integer.parseInt(q);
		
		if(quantity>0){//주문 수량이 있으면
			if(hcart.containsKey(pro_no)){//추가주문
				OrderDto tempOrder=(OrderDto)hcart.get(pro_no);
				quantity += Integer.parseInt(tempOrder.getQuantity());
				tempOrder.setQuantity(quantity+"");
				hcart.put(pro_no, tempOrder);
			}else{//pro_no 없는 경우 : 이 상품을 처음 사는 경우
				hcart.put(pro_no, orderDto);
			}//else end
		}//if
	}//addCart()
	
	//cart 내용 리턴
	public Hashtable getCartList(){
		return hcart;	
	}//getCartList()
	
	//cart 내용 수정
	public void updateCart(OrderDto order){
		int pro_no=order.getPro_no();
		hcart.put(pro_no, order);
	}//updateCart)
	
	//cart 내용 제거
	public void deleteCart(OrderDto order){
		int pro_no=order.getPro_no();
		hcart.remove(pro_no);
	}//deleteCart()
}//class
