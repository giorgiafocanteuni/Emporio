import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) {
		ReadFile f = new ReadFile();
		f.ReadingFile();
		
		
		System.out.print("\nSeleziona un'azione:\n" +
	    		"1) calcolo del valore totale del magazzino\n" +
	    		"2) vendita di un prodotto\n" + 
	    		"3) inserimento di un prodotto\n" + 
	    		"4) ricerca di un prodotto mediante codice univoco\n" +
	    		"5) stampa il numero di righe non riconosciute\n" +
	    		"6) terminare il programma\n");
	    
		BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
		
		int inputNumb;
		
	    do {
	    	System.out.print("\nInserisci il numero dell'azione da eseguire: ");
	    	inputNumb = 0;
	    	
	    	try{
		    	inputNumb = Integer.parseInt(brInput.readLine());
				//controllo inputNumb 
		    }
	    	catch(IOException e) {
	    	}
		    catch(NumberFormatException e){
		    }
		    catch(IllegalArgumentException e){		    	
		        continue;
		    }
		    
	    	Magazzino m = new Magazzino();
		    switch(inputNumb) {
		    
		    	case 0: 
		    		break;
		    		
		    	case 1:
		    	     
		    		m.CalcoloValoreMagazzino();
		    		
		    		break;
		    		
		    	case 2:
		    		
		    		m.VenditaArticolo();
		    		
		    		break;
		    		
		    	case 3:
		    		
		    		m.InserimentoArticolo();
		    		
		    		break;
		    		
		    	case 4:
		    		
		    		m.RicercaArticolo();
		    		
		    		break;

		    	case 5:
		    		m.MessaggiNonRiconosciuti();
		    		break;
		    		
		    	case 6:
		    		break;
		    }
	    }while(inputNumb != 6);		
		
	}

}
