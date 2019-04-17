package philosophe;

import java.util.concurrent.locks.*;

public class moniteur extends Thread{
	private int numero_philo; 
	
	private final Lock verrou=new ReentrantLock();
	private final Condition File_attente[]=new Condition[5];

	
	public enum Etat{
		pense,
		afaim,
		mange;
	}
	
	Etat Etatphilo[]=new Etat[5]; 
	
	public moniteur(){
		for(int i=0; i<5; i++) {
			File_attente[i] = verrou.newCondition();
		}
	}
	
	public int voisin_gauche(int numero){
		return (numero+5-1);
	}
	
	public int voisin_droite(int numero){
		return (numero+1)%5;
	}

	public void Prendre_bag(int Philo){
		System.out.println("Le philosophe prend les baguettes!"+this.numero_philo);
		try{
			Etatphilo[numero_philo]=Etat.afaim;
			Thread.sleep(200);
			if((Etatphilo[voisin_droite(numero_philo)]==Etat.afaim) || (Etatphilo[voisin_gauche(numero_philo)]==Etat.afaim)){
				.await();
			Etatphilo[numero_philo]=Etat.mange;
			}
		}
		catch(InterruptedException ex){}
	}
	

public void libere_bag(int Philo){
	System.out.println("Le philosophe libere les baguettes!"+this.numero_philo);
	try{
		Etatphilo[numero_philo]=Etat.mange;
		Thread.sleep(200);
		if((Etatphilo[voisin_droite(numero_philo)]==Etat.mange) || (Etatphilo[voisin_gauche(numero_philo)]==Etat.mange)){
			.signal();
		Etatphilo[numero_philo]=Etat.pense;
		}
	catch(InterruptedException ex){}
}

			public void run() {
			// boucle tant que la durée de vie du Thread est < à 5 secondes
			while(true) {
			Pense();
			Afaim();
			Mange();
			}
		}
}	
