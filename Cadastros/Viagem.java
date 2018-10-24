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
	Viagem v = new Viagem(hora, minutos);
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
	return new DuracaoHoras(this, horaTermino, horaInicio, duracaoHoras, minutosTermino, minutosInicio).computar();
    }

    public int getDuracaoMinutos() {
	return new DuracaoMinutos(this, minutosTermino, minutosInicio, duracaoMinutos).computar();
    }

    public int getDuracaoTotalMinutos() {
	duracaoTotalMinutos = getDuracaoHoras() * 60 + getDuracaoMinutos();
	return duracaoTotalMinutos;
    }

}
