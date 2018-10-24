package Cadastros;

public class Viagem {

	private int horaInicio;
	private int minutosInicio;
	private int horaTermino;
	private int minutosTermino;
	private int duracaoHoras;
	private int duracaoMinutos;
	private int duracaoTotalMinutos;

	private Viagem(int hora, int minutos) {
		this.horaInicio = hora;
		this.minutosInicio = minutos;
	}

	protected static Viagem obterViagem(int hora, int minutos) {
		Viagem v = new Viagem (hora, minutos);
		return v;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public int getMinutoInicio() {
		return minutosInicio;
	}

	public void encerrarViagem(int horaTermino, int minutosTermino) {
		this.horaTermino = horaTermino;
		this.minutosTermino = minutosTermino;
	}

	public int getHoraTermino() {
		return horaTermino;
	}

	public int getMinutosTermino() {
		return minutosTermino;
	}

	public int getDuracaoHoras() {
		if (horaTermino == horaInicio)
			duracaoHoras = 0;
		if (horaTermino > horaInicio) //varias possibilidades... 
			if (horaTermino == horaInicio + 1) {  
				if (minutosTermino < minutosInicio)  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaTermino - horaInicio > 2) //
					duracaoHoras = horaTermino - horaInicio;
				else if (horaTermino - horaInicio == 2 &&   //certamente menos de duas horas  
						 minutosTermino < minutosInicio)    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (horaTermino < horaInicio) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}

	public int getDuracaoMinutos() {
		if (minutosTermino > minutosInicio) 
			duracaoMinutos = minutosTermino - minutosInicio;
		else {
			duracaoMinutos = 60 - minutosInicio + minutosTermino;
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

	public int getDuracaoTotalMinutos() {
		duracaoTotalMinutos = getDuracaoHoras() * 60 + getDuracaoMinutos();
		return duracaoTotalMinutos;
	}

}
