//package philosopher;
import java.util.concurrent.Semaphore;

	public class philosopher  extends Thread {
		private Semaphore baguetteD, baguetteG;
		private int numb_ph;
	
		public philosopher (int numb,Semaphore Bag1,Semaphore Bag2 ){
			this.numb_ph=numb;
			this.baguetteD=Bag1;
			this.baguetteG=Bag2;
		}
	
	
	public void Pense(){ //he thinks
		System.out.println("Le philosophe "+this.numb_ph+" pense.");
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){}
	}

	
	public void Afaim(){ //he's hungry
		System.out.println("Le philosophe "+this.numb_ph+" a faim");
		try{
			baguetteG.acquire();
			baguetteD.acquire();
		}
		catch(InterruptedException excep){}
	}
	
	
	public void Mange(){ //he eats
		System.out.println("Le philosophe "+this.numb_ph+" mange");
		try{
			Thread.sleep(1000);
			baguetteG.release();
			baguetteD.release();
		}
		catch(InterruptedException excep){}
	}
	
	
	public void run() {
		while(true) {
		Pense();
		Afaim();
		Mange();
		}
	}
}
