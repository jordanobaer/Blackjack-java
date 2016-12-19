//Jordano Baer

import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		String repeat;
		do{
		 
		Cards c = new Cards();
		Dealer d = new Dealer();
		c.setCards();
		int j = 1;
		int[] p_total= new int [5];
		String[] name= new String [5];
		int p_number = 5;
		Players[] p0= new Players[p_number];
		boolean p_blackjack=false;
		
		Scanner input = new Scanner(System.in);
		
		boolean[] over21=new boolean[6];
		 
		System.out.println("Starting Blackjack");
		
		
		//Get names
		 for(int i=0;i<p_number;i++){
			 p0[i]=new Players();
			 System.out.println("What's your name?");
				name[i]=input.nextLine();
				p0[i].setName(name[i]);
		 }
		 
		 //First round
			
		
			//Players cards
			
			for(int i=0;i<p_number;i++){
			p0[i].Play();
			System.out.println(p0[i].getName()+ "'s first card:"+p0[i].getNext(0)+" "+p0[i].getCardName(0));
			Thread.sleep(1000);
			}
				//Dealer 1st card
			System.out.println("The Dealer's first card is "+d.getFirst()+" "+d.getCardName(0));
			Thread.sleep(1000);
			
			
			//Second Cards
			for(int i=0;i<p_number;i++){
			if((p0[i].getNext(0)==1 && p0[i].getNext(1)==10)||(p0[i].getNext(0)==10 && p0[i].getNext(1)==1)){
				System.out.println(p0[i].getName()+"'s second card: "+p0[i].getNext(1)+" "+p0[i].getCardName(1));
				System.out.println(p0[i].getName()+" Got an ace and a 10, Blackjack!");
				System.out.println("Proceeding to blackjack rules after every player gets 2 cards");
				p_total[i]=21;
				p_blackjack=true;
				Thread.sleep(1000);
			}else{
				System.out.println(p0[i].getName()+"'s second card: "+p0[i].getNext(1)+" "+p0[i].getCardName(1)+", Total of "+p0[i].getTotal());
				p_total[i]=p0[i].getTotal();
				Thread.sleep(1000);
			}
		}
			System.out.println("The dealer gets a second card, but it's hidden");
			Thread.sleep(1000);
			
			String choice;
			
			
			//players hit or stand?
			//Check for blackjack first
			if(p_blackjack==false){
			for(int i=0;i<p_number;i++){
			if(p_total[i]!=21){
			System.out.println(p0[i].getName()+", Do you want to stand or hit?");
			
			
			choice = input.nextLine();
			choice = choice.toLowerCase();
			while (choice.equals("hit")){
				j++;
				p0[i].Hit();
				System.out.println(p0[i].getName()+" Got "+p0[i].getNext(j)+" "+p0[i].getCardName(j)+", Total of "+p0[i].getTotal());
				p_total[i]=p0[i].getTotal();
				if(p_total[i]<21){
					System.out.println("Do you want to hit or stand?");
					choice = input.nextLine();
					choice = choice.toLowerCase();
				}else if (p_total[i]==21){
					
					System.out.println("Blackjack!");
					break;
				}else{
					 
					System.out.println("Over 21, bust");
					over21[i]=true;
					break;
				}
				
			}
			j=1;
		}
	}
			
 }
			boolean d_blackjack=false;
			//Dealer's cards
			if((d.getFirst()==1 && d.getSecond()==10)||(d.getFirst()==10 && d.getSecond()==11)){
				System.out.println("Dealer got an ace and a 10, Blackjack!");
				
				d_blackjack=true;
				 
				if(p_blackjack==true){
					System.out.println("Push");
				}else{
					System.out.println("The dealer wins");
				}
				
			}
			else {
			System.out.println("The dealer's second card is "+d.getSecond()+" "+d.getCardName(1)+", Total of "+d.getTotal());
			 if (p_blackjack==true && d_blackjack==false){
				System.out.println("The players win with a blackjack");
				
			}else{ 
			
			if(d.getTotal()<17){
				 d.DealerHit();
				 if(d.getTotal()==21){
					 System.out.println("Blackjack!");
				 }
				 if(d.getTotal()>21){
					 over21[5]=true;
				 }
			 }
			
			 
			 
			 //Results
			
			 //Dealer over 21
			 if (d.getTotal()>21){
				 System.out.println("The dealer passed 21, everyone under 21 wins");
			 }
			 
			 //Dealer below 21
			 boolean p_win=false;
			 if(d.getTotal()<=21){
			 for(int i=0;i<5;i++){
				 if(p_total[i]>d.getTotal()&& p_total[i]<=21){
					 System.out.println(name[i]+" Wins");
					 p_win=true;
				 }else if(p_total[i]==d.getTotal()&& p_total[i]<=21){
					 System.out.println(name[i]+ " Tied");
					 p_win=true;
				 }else if (p_total[i]<d.getTotal()){
					 System.out.println(name[i]+ " Lost");
				 }
			 }
			 if(p_win == false){
				 System.out.println("The dealer wins");
			 }
		}
			 
			 
			 //Players over 21
			 for(int i=0;i<5;i++){
				 if (over21[i]){
					 System.out.println(name[i]+" Lost, over 21");
				 }
			 }
			}
			}
			 
			//Restart 
		System.out.println("Do you want to play again?(yes or no)");
		repeat=input.nextLine();
		repeat = repeat.toLowerCase();
		}while(repeat.equals("yes"));
			
			
			
			
 }
}
		