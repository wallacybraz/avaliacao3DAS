package Cadastros;

public class DuracaoMinutos {

    private final Viagem _viagem;
    private int minutosTermino;
    private int minutosInicio;
    private int duracaoMinutos;

    public DuracaoMinutos(Viagem _viagem, int _minutosTermino, int _minutosInicio, int _duracaoMinutos) {
	super();
	this._viagem = _viagem;
	this.minutosTermino = _minutosTermino;
	this.minutosInicio = _minutosInicio;
	this.duracaoMinutos = _duracaoMinutos;
    }

    public int computar() {
	if (minutosTermino > minutosInicio)
	    duracaoMinutos = minutosTermino - minutosInicio;
	else {
	    duracaoMinutos = 60 - minutosInicio + minutosTermino;
	    if (duracaoMinutos == 60) // caso especial
		duracaoMinutos = 0;
	}
	return duracaoMinutos;
    }

}
