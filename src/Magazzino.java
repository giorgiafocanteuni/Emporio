import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Magazzino {
	
	public void CalcoloValoreMagazzino() {
		int valoreMagazzino=0;
		for(int i=0;i<listaOggetti.size();i++) {
			valoreMagazzino += listaOggetti.get(i).getPrezzo*listaOggetti.get(i).getQuantita;
		}
		System.out.println("Il valore totale del magazzino è "+valoreMagazzino);
	}
	
	
	
	
	
	
	public void VenditaArticolo() {
		System.out.println("Inserire il codice del prodotto che si vuole acquistare:");
		BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
		String codiceInserito = new String();
		try {
			codiceInserito=brInput.readLine();
		}
    	catch(IOException e) {
    	}
	    catch(NumberFormatException e){
	    }
	    catch(IllegalArgumentException e){
	    }
		for(int i=0;i<listaOggetti.size();i++) {
			if(codiceInserito.equals(listaOggetti.get(i).getCodice)) {
				if(quantita<=1) {
					listaOggetti.remove(i);
				}
				else {
					listaOggetti.get(i).setQuantita((listaOggetti.get(i).getQuantita)-1);
					break;
				}
			}
		}
	}
	
	
	
	
	
	
	public void InserimentoArticolo() {
		
		System.out.println("Inserire un nuovo prodotto separando ogni dato (reparto, misura, quantita', prezzo, codice, nome:");

			try {
				FileWriter fw = new FileWriter("Emporio.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
				String oggettoInserito = new String();
				oggettoInserito=brInput.readLine();
				
				
				List<String> parameters = Arrays.asList(oggettoInserito.split(";"));
			
			
				char reparto;
				char misura;
				double quantita;
				double prezzo = Double.parseDouble(parameters.get(3));
				String codice;
				String nome = parameters.get(5);
				String descrizione = parameters.get(6);
				
			if(parameters.get(0).length()==1){
				reparto = parameters.get(0).charAt(0);
			}
	
			if(Integer.parseInt(parameters.get(2))>=0){
				quantita=Double.parseDouble(parameters.get(2));
			}
			else{
				elementsNotRecognized++;
				continue;
			}
			
			for(int i=0;i<listaOggetti.size();i++) {
				if(parameters.get(4).equals(listaOggetti.get(i).getCodice)) {
					System.out.println("E' stato riscontrato un errore: sono presenti due articoli con stesso codice");
					elementsNotRecognized++;
					codiceUguale = true;
				}
			}
			if(codiceUguale) continue;
			
			listaOggetti.add(new Oggetto(reparto,misura,quantita,prezzo,codice,nome,descrizione));
			
			bw.write("\n"+oggettoInserito);
		}
		catch(IOException e){
		}
		catch(IllegalArgumentException e){
			elementsNotRecognized++;
		}
		catch(ArrayIndexOutOfBoundsException e){
			elementsNotRecognized++;
		}
		finally {
			
			try {
				if (bw != null)
						bw.close();

				if (fw != null)
						fw.close();

				}
				catch (IOException ex) {
				}
		}
	
}
	
	
	
	
	
	public void RicercaArticolo() {
		System.out.println("Inserire il codice del prodotto che si vuole acquistare:");
		BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
		String codiceInserito = new String();
		try {
			codiceInserito=brInput.readLine();
		}
    	catch(IOException e) {
    	}
	    catch(NumberFormatException e){
	    }
	    catch(IllegalArgumentException e){
	    }
		for(int i=0;i<listaOggetti.size();i++) {
			if(codiceInserito.equals(listaOggetti.get(i).getCodice)) {
				System.out.print(listaOggetti.get(i).getReparto+"\n"+
							listaOggetti.get(i).getMisura+"\n"+
							listaOggetti.get(i).getQuantita+"\n"+
							listaOggetti.get(i).getPrezzo+"\n"+
							listaOggetti.get(i).getCodice+"\n"+
							listaOggetti.get(i).getNome+"\n"+
							listaOggetti.get(i).getDescrizione+"\n");
				break;
			}
		}
	}
	
	
	
	
	
	public void MessaggiNonRiconosciuti() {
		System.out.println("Non sono stati riconosciuti "+elementsNotRecognized+" messaggi.");
	}
}
