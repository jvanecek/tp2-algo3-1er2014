package Ejercicio1.model;

class Jugada {
	private int desde;
	private int cartas;

	private static final int IZQUIERDA = 1;
	private static final int DERECHA = 2;

	@Override
	public String toString() {
		return (desde == IZQUIERDA ? "izq" : "der") + " " + String.valueOf( cartas );
	}
	
	/**
	 * @return Indica si la jugada es desde la izquierda.
	 */
	public boolean desdeIzquierda() {
		return desde == IZQUIERDA;
	}

	/**
	 * @return Indica si la jugada es desde la derecha.
	 */
	public boolean desdeDerecha() {
		return desde == DERECHA;
	}

	/**
	 * Establece una jugada desde la izquierda.
	 * @param cartas La cantidad de cartas tomadas desde la izquierda.
	 */
	public void desdeIzquierda( int cartas ) {
		desde = IZQUIERDA;
		this.cartas = cartas;
	}

	/**
	 * Establece una jugada desde la derecha.
	 * @param cartas La cantidad de cartas tomadas desde la derecha.
	 */
	public void desdeDerecha( int cartas ) {
		desde = DERECHA;
		this.cartas = cartas;
	}
	
	/**
	 * @return Devuelve la cantidad de cartas tomadas en esta jugada.
	 */
	public int cartas() {
		return cartas;
	}
}