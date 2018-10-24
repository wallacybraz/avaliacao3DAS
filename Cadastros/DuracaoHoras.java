package Cadastros;

public class DuracaoHoras {

    private final Viagem _viagem;
    private int horaTermino;
    private int horaInicio;
    private int duracaoHoras;
    private int minutosTermino;
    private int minutosInicio;

    public DuracaoHoras(Viagem _viagem, int _horaTermino, int _horaInicio, int _duracaoHoras, int _minutosTermino,
	    int _minutosInicio) {
	super();
	this._viagem = _viagem;
	this.horaTermino = _horaTermino;
	this.horaInicio = _horaInicio;
	this.duracaoHoras = _duracaoHoras;
	this.minutosTermino = _minutosTermino;
	this.minutosInicio = _minutosInicio;
    }

    public int computar() {
	if (horaTermino == horaInicio)
	    duracaoHoras = 0;
	if (horaTermino > horaInicio) // varias possibilidades...
	    if (horaTermino == horaInicio + 1) {
		if (minutosTermino < minutosInicio) // nao chegou a uma hora
		    duracaoHoras = 0;
		else // durou pelo menos uma hora
		    duracaoHoras = 1;
	    } else { // possivelmente ultrapassou duas horas
		if (horaTermino - horaInicio > 2) //
		    duracaoHoras = horaTermino - horaInicio;
		else if (horaTermino - horaInicio == 2 && // certamente menos de duas horas
			minutosTermino < minutosInicio) // e mais de uma hora
		    duracaoHoras = 1;
		else // duracao de duas horas, certamente
		    duracaoHoras = 2;

	    }
	if (horaTermino < horaInicio)
	    duracaoHoras = -1; // para casos em que a hora de termino nao foi registrada
	return duracaoHoras;

    }

}