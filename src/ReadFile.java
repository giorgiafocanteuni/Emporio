import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ReadFile {
	
	public static void ReadingFile(){
		try {
			
			FileReader fr = new FileReader("EMPORIO.txt");
			BufferedReader br = new BufferedReader(fr);
		
			String line = null;
			boolean codiceUguale = false;
		
			while((line = br.readLine()) != null) {
			
				List<String> parameters = Arrays.asList(line.split(";"));
			
			
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
					
			}
				br.close();
			}
			catch(IOException e){
			}
			catch(IllegalArgumentException e){
				elementsNotRecognized++;
			}
			catch(ArrayIndexOutOfBoundsException e){
				elementsNotRecognized++;
			}	
	}
}
