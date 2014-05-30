package Ejercicio3.model;

/**
 * Created by juan on 29/05/14.
 */
public class Nodo{
	private int fila;
	private int col;
	private int poderes_disponibles;
	private int poderes_usados;
	private Nodo parent;

	public Nodo(int i, int j, int k){
		parent = null;
		fila = i; col = j; this.poderes_disponibles = k;
	}

	public Nodo(int i, int j, int k, Nodo v){
		this.parent = new Nodo(v);
		fila = i; col = j; this.poderes_disponibles = k;
	}

	public Nodo(Nodo otro){
		fila = otro.getFila();
		col = otro.getCol();
		poderes_disponibles = otro.getPoderesDisponibles();
		parent = otro.getParent();
	}

	public int getFila(){ return fila; }
	public int getCol(){ return col; }
	public int getPoderesDisponibles(){ return poderes_disponibles; }
	public Nodo getParent(){ return parent; }

	public void setPoderesUsados(int k){ poderes_usados = k; }

	public int getPoderesUsados(){ return poderes_usados; }

	public boolean equals(Nodo otro){
		return getFila() == otro.getFila() &&
				getCol() == otro.getCol();
	}
}
