package main.java.alysondantas.agendador.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.alysondantas.agendador.controller.Controller;
import main.java.alysondantas.agendador.exceptions.HoraInvalidaException;
import main.java.alysondantas.agendador.exceptions.SONaoIdentificadoException;
import main.java.alysondantas.agendador.exceptions.TipoInvalidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	
	private Controller controller = new Controller();
	private JPanel contentPane;
	private JTextField tfTempo;
	private final ButtonGroup tipo = new ButtonGroup();
	private JRadioButton rdHora;
	private JRadioButton rdMinuto;
	private JRadioButton rdSegundo;
	private JTextField txtHoraminutosegundo;
	private final ButtonGroup escolha = new ButtonGroup();
	private JRadioButton rdDesligar;
	private JRadioButton rdReiniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		try { 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agendar por horas restantes:");
		lblNewLabel.setBounds(10, 11, 255, 14);
		contentPane.add(lblNewLabel);
		
		tfTempo = new JTextField();
		tfTempo.setBounds(10, 36, 86, 20);
		contentPane.add(tfTempo);
		tfTempo.setColumns(10);
		
		JButton btAgendar1 = new JButton("Agendar!");
		btAgendar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agendarTempoRestante();
			}
		});
		btAgendar1.setBounds(106, 35, 89, 23);
		contentPane.add(btAgendar1);
		
		rdHora = new JRadioButton("Hora");
		rdHora.setSelected(true);
		tipo.add(rdHora);
		rdHora.setBounds(6, 89, 86, 23);
		contentPane.add(rdHora);
		
		rdMinuto = new JRadioButton("Minuto");
		tipo.add(rdMinuto);
		rdMinuto.setBounds(94, 89, 86, 23);
		contentPane.add(rdMinuto);
		
		rdSegundo = new JRadioButton("Segundo");
		tipo.add(rdSegundo);
		rdSegundo.setBounds(182, 89, 109, 23);
		contentPane.add(rdSegundo);
		
		JLabel lblNewLabel_1 = new JLabel("Agendar por horario:");
		lblNewLabel_1.setBounds(10, 119, 229, 14);
		contentPane.add(lblNewLabel_1);
		
		txtHoraminutosegundo = new JTextField();
		txtHoraminutosegundo.setText("hh:mm:ss");
		txtHoraminutosegundo.setBounds(10, 144, 86, 20);
		contentPane.add(txtHoraminutosegundo);
		txtHoraminutosegundo.setColumns(10);
		
		JButton btnAgendar = new JButton("Agendar!");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendarHora();
			}
		});
		btnAgendar.setBounds(106, 144, 89, 23);
		contentPane.add(btnAgendar);
		
		JButton btAnular = new JButton("Anular!");
		btAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anular();
			}
		});
		btAnular.setBounds(10, 202, 89, 23);
		contentPane.add(btAnular);
		
		rdDesligar = new JRadioButton("Desligar");
		rdDesligar.setSelected(true);
		escolha.add(rdDesligar);
		rdDesligar.setBounds(6, 63, 90, 23);
		contentPane.add(rdDesligar);
		
		rdReiniciar = new JRadioButton("Reiniciar");
		escolha.add(rdReiniciar);
		rdReiniciar.setBounds(94, 63, 80, 23);
		contentPane.add(rdReiniciar);
	}
	
	private void agendarTempoRestante(){
		JOptionPane.showMessageDialog(null, "Ainda não testado em linux!");
		boolean verificador = false;
		try{
			String teste = tfTempo.getText();
			int hora = Integer.parseInt(teste) ;
			int tip=0;
			int escolha=0;
			if(rdHora.isSelected()){
				tip = 1;
			}else if(rdMinuto.isSelected()){
				tip = 2;
			}else if(rdSegundo.isSelected()){
				tip = 3;
			}
			if(rdDesligar.isSelected()){
				escolha = 1;
			}else if(rdReiniciar.isSelected()){
				escolha = 2;
			}
			
			verificador = controller.agendarTempo(hora, tip, escolha);
		}catch (IOException e) {
			e.printStackTrace();
		}catch(HoraInvalidaException e){
			JOptionPane.showMessageDialog(null, "Hora Invalida!");
			e.printStackTrace();
		}catch(SONaoIdentificadoException e){
			JOptionPane.showMessageDialog(null, "Erro ao identificar SO!");
			e.printStackTrace();
		}catch(TipoInvalidoException e){
			JOptionPane.showMessageDialog(null, "Tipo Selecionado invalido!");
			e.printStackTrace();
		}
		if(verificador == false){
			JOptionPane.showMessageDialog(null, "Erro ao agendar!");
		}
	}
	
	private void agendarHora(){
		JOptionPane.showMessageDialog(null, "Ainda não implementado!");
		
	}
	
	private void anular(){
		JOptionPane.showMessageDialog(null, "Ta quase pronto!");
		boolean verificador = false;
		try{
			verificador = controller.anular();
		}catch(IOException e){
			e.printStackTrace();
		}catch(SONaoIdentificadoException e){
			JOptionPane.showMessageDialog(null, "Erro ao identificar SO!");
			e.printStackTrace();
		}
		if(verificador == false){
			JOptionPane.showMessageDialog(null, "Erro ao anular!");
		}
	}
}
