//package philosopher;
import java.util.concurrent.Semaphore;

public class main_Sem { 
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		Semaphore baguette[]=new Semaphore[5];
		philosopher ph[]= new philosopher [5];
		for(int i=0; i<5; i++) {
			baguette[i]=new Semaphore(1);
		}
		for(int j=0; j<5; j++) {
			ph[j] = new philosopher(j,baguette[j],baguette[(j+1)%5]);
			System.out.println("Le philosophe "+j+" a rejoint la table." );
			ph[j].start();
		}
	}
}
