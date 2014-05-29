package Ejercicio3.model;

/**
 * Created by juan on 29/05/14.
 */
public class Nodo{
	private int fila;
	private int col;
	private int k;

	public Nodo(int i, int j, int k){
		fila = i; col = j; this.k = k;
	}

	public int getFila(){ return fila; }
	public int getCol(){ return col; }
	public int getK(){ return k; }

	public boolean equals(Nodo otro){
		return getFila() == otro.getFila() &&
				getCol() == otro.getCol();
	}
}
