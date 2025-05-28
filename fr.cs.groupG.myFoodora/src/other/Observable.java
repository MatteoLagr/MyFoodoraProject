package other;

public interface Observable {
	
	public void registerObserver(Observer obs);
	public void removeObserver(Observer obs);
	public void notifyObserver(Observer obs);
	
	// j'ai pas mis qui l'implémente parce que tu m'as dit que t'étais plus sûr
}
