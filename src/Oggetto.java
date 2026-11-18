
public class Oggetto {
	protected char _reparto;
	protected char _misura;
	protected double _quantita;
	protected double _prezzo;
	protected String _codice;
	protected String _nome;
	protected String _descrizione;
	
	public Oggetto(char reparto, char misura, double quantita, double prezzo, String codice, String nome, String descrizione) {
		_reparto=reparto;
		_misura=misura;
		_quantita=quantita;
		_prezzo=prezzo;
		_codice=codice;
		_nome=nome;
		_descrizione=descrizione;
	}
	
	
	
	public char getReparto(){
		return _reparto;
	}
	
	public char getMisura(){
		return _misura;
	}
	
	public double getQuantita() {
		return _quantita;
	}
	
	public double getPrezzo() {
		return _prezzo;
	}
	
	public String getCodice() {
		return _codice;
	}
	
	public String getNome() {
		return _nome;
	}
	
	public String getDescrizione() {
		return _descrizione;
	}	
	
	
	public void setQuantita(double _quantita){
		this._quantita=_quantita;
	}
}
