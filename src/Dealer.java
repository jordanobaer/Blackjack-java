
public class Dealer {
	Cards c = new Cards();
	
	int j = 0;
	int[] d_cards= new int[10];
	String[] n=new String [10];
	int d_total;
	
	public int getFirst(){
	c.setCards();
	 
	
	
	//Dealer
	//Loop to determine if the card has already been used
	do{ 
	d_cards[j]=c.getCards();
	n[j]=c.getName();
	j++;
	d_cards[j]=c.getCards();
	n[j]=c.getName();
	d_total=d_cards[0]+d_cards[1];
	}while(d_cards[0]==0||d_cards[1]==0);
	//System.out.println("Dealer got cards: "+n1[0]+" "+p1[0]);
	return d_cards[0];
	}
	
	public String getCardName(int j){
		
		return n[j];
		
	}
	
	
	public int getSecond(){
		
		return d_cards[1];
	}
	
	public int DealerHit(){
	while(d_total<17){
	do{
		j++;
		d_cards[j]=c.getCards();
		n[j]=c.getName();
		}while (d_cards[j]==0);
		d_total+=d_cards[j];
		System.out.println("Dealer got "+d_cards[j]+" "+n[j]+", Total of "+d_total);
	}
	
	return d_total;
	}
	
	public int getTotal(){
		return d_total;
	}
	
	
	
}