package Ejercicio3.model;

import java.util.Collections;
import java.util.Vector;
import java.util.List;

public class Tablero {
	private int n;
	private int[][] potencias;
	private boolean[][] recorridos;
	private Nodo src;
	private Nodo dst;
	private List<Nodo> solucion;

	public Tablero(int n, int k, int f0, int c0, int fn, int cn, int[][] potencias){
		this.n = n;
		this.src = new Nodo(f0, c0, k);
		this.dst = new Nodo(fn, cn, k);
		this.potencias = new int[n][n];
		this.recorridos = new boolean[n][n];
		for( int i = 0; i < n; i++ )
		for( int j = 0; j < n; j++ ) {
			this.recorridos[i][j] = false;
			this.potencias[i][j] = potencias[i][j];
		}
		solucion = new Vector<Nodo>();
	}

	public int resolver(){
		List<Nodo> nodos = new Vector<Nodo>();

		nodos.add(src);

		return bfs(nodos, 1);
	}

	public int bfs(List<Nodo> nodos, int nivel){
		if( nodos.isEmpty() ) {
			System.out.println("No se encontro el nodo!");    // No se encontro el nodo dst
			return -1;
		}

		List<Nodo> nodos_siguientes = new Vector<Nodo>();

		for( Nodo v : nodos ){
			if( !fueRecorrido(v) ){
				if( v.equals(dst) ){
					construirSolucion(v);
					return nivel;
				}else{
					marcarComoRecorrido(v);

					nodos_siguientes.addAll( getAdyacentes(v) );
				}
			}
		}

		return bfs(nodos_siguientes, nivel+1);
	}

	public void construirSolucion(Nodo dst){
		dst.setPoderesUsados(0);
		int poderesDisponiblesSig = dst.getPoderesDisponibles();
		solucion.add(dst);

		while( dst.getParent() != null ){
			dst = dst.getParent();
			dst.setPoderesUsados( dst.getPoderesDisponibles() - poderesDisponiblesSig);
			poderesDisponiblesSig = dst.getPoderesDisponibles();
			solucion.add(0, dst);
		}
	}

	public boolean fueRecorrido(Nodo i){
		return recorridos[i.getFila()-1][i.getCol()-1];
	}

	public void marcarComoRecorrido(Nodo i){
		recorridos[i.getFila()-1][i.getCol()-1] = true;
	}

	public List<Nodo> getAdyacentes(Nodo v){
		List<Nodo> adyacentes = new Vector<Nodo>();

		int p = getPotencia(v);
		int k = v.getPoderesDisponibles();
		int f = v.getFila();
		int c = v.getCol();

		// agrego todos los vecinos a los que llego con la potencia
		for( int i = 1; i <= p; i++ ){
			if( estaEnTablero(f-i,c) ) adyacentes.add( new Nodo(f-i,c,k,v) ); // abajo
			if( estaEnTablero(f+i,c) ) adyacentes.add( new Nodo(f+i,c,k,v) ); // arriba
			if( estaEnTablero(f,c-i) ) adyacentes.add( new Nodo(f,c-i,k,v) ); // a la izq
			if( estaEnTablero(f,c+i) ) adyacentes.add( new Nodo(f,c+i,k,v) ); // a la der
		}

		// agrego todos los vecinos a los que llego con la potencia extra
		for( int i = 1; i <= k; i++ ){
			if( estaEnTablero(f-(p+i),c) ) adyacentes.add( new Nodo(f-(p+i),c,k-i,v) );	// abajo;
			if( estaEnTablero(f+(p+i),c) ) adyacentes.add( new Nodo(f+(p+i),c,k-i,v) );	// arriba
			if( estaEnTablero(f,c-(p+i)) ) adyacentes.add( new Nodo(f,c-(p+i),k-i,v) );	// a la izq
			if( estaEnTablero(f,c+(p+i)) ) adyacentes.add( new Nodo(f,c+(p+i),k-i,v) );	// a la der
		}
		return adyacentes;
	}

	public boolean estaEnTablero( int fila, int col ){
		return fila >= 1 && col >= 1 &&
			   fila <= n && col <= n;
	}

	public int getPotencia(Nodo v){
		return potencias[v.getFila()-1][v.getCol()-1];
	}

	public List<Nodo> getSolucion(){ return this.solucion; }
}
