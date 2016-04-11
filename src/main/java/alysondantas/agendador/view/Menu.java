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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private Controller controller = new Controller();
	private JPanel contentPane;
	private JTextField tfTempo;
	private final ButtonGroup tipo = new ButtonGroup();
	private JRadioButton rdHora;
	private JRadioButton rdMinuto;
	private JRadioButton rdSegundo;
	private JTextField txtHora;
	private final ButtonGroup escolha = new ButtonGroup();
	private JRadioButton rdDesligar;
	private JRadioButton rdReiniciar;
	private JTextField textMinuto;
	private JLabel label_1;
	private JTextField textSegundo;

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
		rdHora.setBounds(10, 63, 86, 23);
		contentPane.add(rdHora);

		rdMinuto = new JRadioButton("Minuto");
		tipo.add(rdMinuto);
		rdMinuto.setBounds(98, 63, 86, 23);
		contentPane.add(rdMinuto);

		rdSegundo = new JRadioButton("Segundo");
		tipo.add(rdSegundo);
		rdSegundo.setBounds(186, 63, 109, 23);
		contentPane.add(rdSegundo);

		JLabel lblNewLabel_1 = new JLabel("Agendar por horario:");
		lblNewLabel_1.setBounds(10, 93, 229, 14);
		contentPane.add(lblNewLabel_1);

		txtHora = new JTextField();
		txtHora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHora.setText("");
			}
		});
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		txtHora.setText(sdf.format(new Date()));
		txtHora.setBounds(10, 118, 21, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		textMinuto = new JTextField();
		SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
		textMinuto.setText(sdf2.format(new Date()));
		textMinuto.setBounds(41, 118, 21, 20);
		contentPane.add(textMinuto);
		textMinuto.setColumns(10);

		textSegundo = new JTextField();
		SimpleDateFormat sdf3 = new SimpleDateFormat("ss");
		textSegundo.setText(sdf3.format(new Date()));
		textSegundo.setBounds(72, 118, 21, 20);
		contentPane.add(textSegundo);
		textSegundo.setColumns(10);

		JButton btnAgendar = new JButton("Agendar!");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendarHora();
			}
		});
		btnAgendar.setBounds(106, 118, 89, 23);
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
		rdDesligar.setBounds(297, 35, 90, 23);
		contentPane.add(rdDesligar);

		rdReiniciar = new JRadioButton("Reiniciar");
		escolha.add(rdReiniciar);
		rdReiniciar.setBounds(297, 63, 80, 23);
		contentPane.add(rdReiniciar);

		JLabel lblEscolha = new JLabel("Escolha:");
		lblEscolha.setBounds(297, 11, 46, 14);
		contentPane.add(lblEscolha);

		JLabel label = new JLabel(":");
		label.setBounds(35, 121, 4, 14);
		contentPane.add(label);

		label_1 = new JLabel(":");
		label_1.setBounds(65, 121, 4, 14);
		contentPane.add(label_1);


	}

	private void agendarTempoRestante(){
		JOptionPane.showMessageDialog(null, "Ainda não testado em linux!");
		boolean verificador = false;
		try{
			String teste = tfTempo.getText();
			if(teste == null || teste.equals("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo de tempo!");
			}else{
				int hora=-1;
				try {
					hora = Integer.parseInt(teste) ;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Apenas numeros!");
				}
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
			}
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
		JOptionPane.showMessageDialog(null, "Começando a testar!");
		JOptionPane.showMessageDialog(null, "Ainda não testado em linux!");
		boolean verificador = false;
		try{
			String horaS = txtHora.getText();
			String minutoS = textMinuto.getText();
			String segundoS = textSegundo.getText();
			if(horaS == null || horaS.equals("") || minutoS == null || minutoS.equals("") || segundoS == null || segundoS.equals("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo de tempo!");
			}else{
				int hora=-1;
				int minuto=-1;
				int segundo=-1;
				try {
					hora = Integer.parseInt(horaS);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Apenas numeros!");
				}
				try {
					minuto = Integer.parseInt(minutoS);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Apenas numeros!");
				}
				try {
					segundo = Integer.parseInt(segundoS);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Apenas numeros!");
				}
				int escolha = 0;
				if(rdDesligar.isSelected()){
					escolha = 1;
				}else if(rdReiniciar.isSelected()){
					escolha = 2;
				}
				verificador = controller.agendarHora(hora, minuto, segundo, escolha);
			}
		}catch(HoraInvalidaException e){
			JOptionPane.showMessageDialog(null, "Hora Invalida!");
			e.printStackTrace();
		}catch(SONaoIdentificadoException e){
			JOptionPane.showMessageDialog(null, "Erro ao identificar SO!");
			e.printStackTrace();
		}catch(TipoInvalidoException e){
			JOptionPane.showMessageDialog(null, "Tipo Selecionado invalido!");
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(verificador == false){
			JOptionPane.showMessageDialog(null, "Erro ao agendar!");
		}
	}

	private void anular(){
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
