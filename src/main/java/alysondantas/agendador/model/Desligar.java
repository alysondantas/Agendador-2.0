package main.java.alysondantas.agendador.model;

import java.io.IOException;

import main.java.alysondantas.agendador.exceptions.*;

public class Desligar {
	public Desligar(){

	}
	public boolean deligarPorTempoRestante(int hora, int so, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		if(hora<=0){
			throw new HoraInvalidaException();
		}
		/*
		 * escolha == 1 / horas
		 * escolha == 2 / minutos
		 * escolha !=1 && !=2 / segundos
		 */
		/*
		 * so == 0 / windows
		 * so == 1 / linux
		 */
		String comandoWin = "shutdown -s -t ";
		String comandoLinux = "shutdown -h ";
		String comando = "";
		int tempo = hora;

		switch (so){
		case 0:
			if(escolha == 1){
				tempo = tempo * 60;
				tempo = tempo * 60;
			}else if(escolha == 2){
				tempo = tempo * 60;
			}

			comando = comandoWin + tempo;
			break;
		case 1:
			if(escolha == 1){
				tempo = tempo * 60;
			}else if(escolha !=2){
				tempo = tempo / 60;
			}
			comando = comandoLinux + tempo;
			break;
		default:
			throw new SONaoIdentificadoException();
		}
		Runtime.getRuntime().exec(comando);
		return true;
	}

	public boolean reiniciarPorTempoRestante(int hora, int so, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		if(hora<=0){
			throw new HoraInvalidaException();
		}
		/*
		 * escolha == 1 / horas
		 * escolha == 2 / minutos
		 * escolha !=1 && !=2 / segundos
		 */
		/*
		 * so == 0 / windows
		 * so == 1 / linux
		 */
		String comandoWin = "shutdown -r -t ";
		String comandoLinux = "shutdown -r ";
		String comando = "";
		int tempo = hora;

		switch (so){
		case 0:
			if(escolha == 1){
				tempo = tempo * 60;
				tempo = tempo * 60;
			}else if(escolha == 2){
				tempo = tempo * 60;
			}

			comando = comandoWin + tempo;
			break;
		case 1:
			if(escolha == 1){
				tempo = tempo * 60;
			}else if(escolha !=2){
				tempo = tempo / 60;
			}
			comando = comandoLinux + tempo;
			break;
		default:
			throw new SONaoIdentificadoException();
		}
		Runtime.getRuntime().exec(comando);
		return true;
	}

	public boolean anular(int so) throws IOException, SONaoIdentificadoException{
		switch (so){
		case 0:
			Runtime.getRuntime().exec("shutdown -a");
			break;
		case 1:
			Runtime.getRuntime().exec("sudo shutdown -c");
			break;
		default:
			throw new SONaoIdentificadoException();
		}

		return true;
	}
}
