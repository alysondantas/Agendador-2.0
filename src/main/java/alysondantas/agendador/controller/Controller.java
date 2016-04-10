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
	String horario = "";
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
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String horario = sdf.format(new Date());
		this.horario=horario;
		JOptionPane.showMessageDialog(null, horario);
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
	
	public boolean anular() throws IOException, SONaoIdentificadoException{
		boolean verifica = agendar.anular(so);
		return verifica;
	}
}
