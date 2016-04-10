package main.java.alysondantas.agendador.controller;

import java.io.IOException;

import main.java.alysondantas.agendador.exceptions.HoraInvalidaException;
import main.java.alysondantas.agendador.exceptions.SONaoIdentificadoException;
import main.java.alysondantas.agendador.model.Desligar;

public class Controller {
	int so = 2;
	Desligar agendar = new Desligar();
	public Controller(){
		String nome = System.getProperty("os.name");
		System.out.println(nome);
		if(nome.substring(0, 7).equals("Windows")){
			so = 0;
		}else if(nome.substring(0, 5).equals("Linux")){
			so = 1;
		}
	}
	
	public boolean agendarTempoHora(int hora) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		boolean verifica = agendar.deligarPorTempoRestante(hora, this.so, 1);
		return verifica;
	}
	
	public boolean agendarTempoMin(int minutos) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		boolean verifica = agendar.deligarPorTempoRestante(minutos, this.so, 2);
		return verifica;
	}
	
	public boolean agendarTempoSeg(int segundos) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		boolean verifica = agendar.deligarPorTempoRestante(segundos, this.so, 3);
		return verifica;
	}
	
	public boolean anular() throws IOException, SONaoIdentificadoException{
		boolean verifica = agendar.anular(this.so);
		return verifica;
	}
}
