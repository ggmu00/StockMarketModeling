import java.util.*;
public class StockMarketModel {
	static int total = 0;
	
	public static void main(String[]args) {
		
		Queue<Integer> amount = new LinkedList<>();
		Queue<Integer> price = new LinkedList<>();
				
		amount.add(15);
		price.add(4);

		amount.add(4);
		price.add(12);
		System.out.println(amount);
		System.out.println(price);
		System.out.println("Total after 3 are sold: "+sellPrice(price, amount, 3));
		System.out.println("Total after 2 more are sold: "+sellPrice(price, amount, 2));

		
	}
	
	//returns the amount of money made from selling *num* amount of stocks
	public static int sellPrice(Queue<Integer> prices, Queue<Integer> amt, int num) {
		
		//while the amount of stocks being sold is more than 0
		while(num>0 && amt.isEmpty()==false && prices.isEmpty()==false) {
			//if the first value in amt is less than the amount of stocks being sold 
				//add the amount to total and subtract one from the amount being sold

			if(amt.peek()<=num) {
				total=prices.peek()*amt.peek();
				prices.remove();
				num-=amt.peek();
				amt.remove();
				
			//if the first value in amt is more than the num remove the value from amt and prices(they are linked)
			}if(amt.peek()>num&&num>0) {
				int temp = amt.peek();
				
				while(num >0 ) {
					total+=prices.peek();
					temp--;
					num--;
					if(temp==0||amt.isEmpty() ) {
						amt.remove();
						prices.remove();
						break;
					}			
				}
			}
				
		}
		return total;	
	}
}
