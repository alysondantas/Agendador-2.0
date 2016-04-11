package main.java.alysondantas.agendador.model;

import java.io.IOException;

import main.java.alysondantas.agendador.exceptions.*;

public class Desligar {
	public Desligar(){

	}
	public boolean deligarPorTempoRestante(int hora, int so, int tipo, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		if(hora<=0){
			throw new HoraInvalidaException();
		}
		/*
		 * tipo == 1 / horas
		 * tipo == 2 / minutos
		 * tipo == 3 / segundos
		 */
		/*
		 * so == 0 / windows
		 * so == 1 / linux
		 */
		/*
		 * escolha == 1 / deligar
		 * escolha == 2 / reiniciar
		 */
		
		String comandoDWin = "shutdown -s -t ";
		String comandoRWin = "shutdown -r -t ";
		String comandoDLinux = "sudo shutdown -h +";
		String comandoRLinux = "sudo shutdown -r +";
		String comando = "";
		int tempo = hora;

		switch (so){
		case 0:
			if(tipo == 1){
				tempo = tempo * 60;
				tempo = tempo * 60;
			}else if(tipo == 2){
				tempo = tempo * 60;
			}
			if(escolha == 1){
				comando = comandoDWin + tempo;
			}else if(escolha == 2){
				comando = comandoRWin + tempo;
			}

			break;
		case 1:
			if(tipo == 1){
				tempo = tempo * 60;
			}else if(tipo == 3){
				tempo = tempo / 60;
			}
			if(escolha == 1){
				comando = comandoDLinux + tempo;
			}else if(escolha == 2){
				comando = comandoRLinux + tempo;
			}

			break;
		default:
			throw new SONaoIdentificadoException();
		}
		Runtime.getRuntime().exec(comando);
		return true;
	}
	public boolean deligarPorHora(int hora, int minuto, int segundo, int so, int escolha) throws HoraInvalidaException, IOException, SONaoIdentificadoException{
		if(hora<0 || minuto<0 || segundo<0){
			throw new HoraInvalidaException();
		}
		/*
		 * tipo == 1 / horas
		 * tipo == 2 / minutos
		 * tipo == 3 / segundos
		 */
		/*
		 * so == 0 / windows
		 * so == 1 / linux
		 */
		/*
		 * escolha == 1 / deligar
		 * escolha == 2 / reiniciar
		 */
		
		String comandoDWin = "shutdown -s -t ";
		String comandoRWin = "shutdown -r -t ";
		String comandoDLinux = "sudo shutdown -h +";
		String comandoRLinux = "sudo shutdown -r +";
		String comando = "";

		switch (so){
		case 0:
				hora = hora * 60;
				hora = hora * 60;
				minuto = minuto * 60;
				int tempo = hora + minuto + segundo;
			if(escolha == 1){
				comando = comandoDWin + tempo;
			}else if(escolha == 2){
				comando = comandoRWin + tempo;
			}

			break;
		case 1:
				hora = hora * 60;
				segundo = segundo / 60;
				tempo = hora + minuto + segundo;
			if(escolha == 1){
				comando = comandoDLinux + tempo;
			}else if(escolha == 2){
				comando = comandoRLinux + tempo;
			}

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
