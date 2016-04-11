package main.java.alysondantas.agendador.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import main.java.alysondantas.agendador.exceptions.HoraInvalidaException;
import main.java.alysondantas.agendador.exceptions.SONaoIdentificadoException;
import main.java.alysondantas.agendador.exceptions.TipoInvalidoException;
import main.java.alysondantas.agendador.model.Desligar;

public class Controller {
	int so = 2;
	Desligar agendar = new Desligar();
	public Controller(){
		JOptionPane.showMessageDialog(null, "Verificando SO!");
		String nome = System.getProperty("os.name");
		System.out.println(nome);
		JOptionPane.showMessageDialog(null, nome);
		if(nome.substring(0, 7).equals("Windows")){
			so = 0;
		}else if(nome.substring(0, 5).equals("Linux")){
			so = 1;
		}
	}

	public boolean agendarTempo(int hora, int tipo, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException, TipoInvalidoException{
		if(tipo>3 || tipo<1){
			throw new TipoInvalidoException();
		}else if(escolha<1 || escolha>2){
			throw new TipoInvalidoException();
		}
		boolean verifica = agendar.deligarPorTempoRestante(hora, this.so, tipo, escolha);
		return verifica;
	}

	public boolean agendarHora(int hora,int minuto, int segundo, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException, TipoInvalidoException{
		if(hora<0 || minuto<0 || segundo<0){
			throw new TipoInvalidoException();
		}else if(escolha<1 || escolha>2){
			throw new TipoInvalidoException();
		}
		if(hora>24 || minuto>60 || segundo>60){
			throw new HoraInvalidaException();
		}
		SimpleDateFormat sdfh = new SimpleDateFormat("HH");
		String horario = sdfh.format(new Date());
		int horatual = Integer.parseInt(horario);
		SimpleDateFormat sdfm = new SimpleDateFormat("mm");
		horario = sdfm.format(new Date());
		int minutoatual = Integer.parseInt(horario);
		SimpleDateFormat sdfs = new SimpleDateFormat("ss");
		horario = sdfs.format(new Date());
		int segundoatual = Integer.parseInt(horario);
		if(hora == horatual && minuto<minutoatual){
			throw new HoraInvalidaException();
		}else if(hora == horatual && minuto == minutoatual && segundo<segundoatual){
			throw new HoraInvalidaException();
		}
		if(hora<horatual){
			hora = hora+24;
		}
		hora = hora - horatual;
		minuto = minuto - minutoatual;
		segundo = segundo - segundoatual;
		if(minuto<0){
			minuto = Math.abs(minuto);
		}
		if(segundo<0){
			segundo = Math.abs(segundo);
		}

		boolean verifica = agendar.deligarPorHora(hora, minuto, segundo, this.so, escolha);
		return verifica;
	}

	public boolean anular() throws IOException, SONaoIdentificadoException{
		boolean verifica = agendar.anular(so);
		return verifica;
	}
}
