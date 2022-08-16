package br.com.jefferson.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.jefferson.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{

	private final Color COR_CINZA_ESCURO = new Color(68,68,68);
	private final Color COR_CINZA_CLARO = new Color(99,99,99);
	private final Color COR_LARANJA = new Color(242,163,60);

	// TODO: PADRÃO CALCULADORA LINUX
//	private final Color COR_CINZA_ESCURO = new Color();
//	private final Color COR_CINZA_CLARO = new Color();
//	private final Color COR_VERDE = new Color();

	
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
	
		setLayout(layout);
		
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		
//		LINHA 1
		constraints.gridwidth = 2;
		adcionarBotao("AC", COR_CINZA_ESCURO, constraints, 0, 0);
		constraints.gridwidth = 1;
		adcionarBotao("±", COR_CINZA_ESCURO, constraints, 2, 0);
		adcionarBotao("/", COR_LARANJA, constraints, 3, 0);
		
//		LINHA 2
		adcionarBotao("7", COR_CINZA_CLARO, constraints, 0, 1);
		adcionarBotao("8", COR_CINZA_CLARO, constraints, 1, 1);
		adcionarBotao("9", COR_CINZA_CLARO, constraints, 2, 1);
		adcionarBotao("*", COR_LARANJA, constraints, 3, 1);
		
//		LINHA 3
		adcionarBotao("4", COR_CINZA_CLARO, constraints, 0, 2);
		adcionarBotao("5", COR_CINZA_CLARO, constraints, 1, 2);
		adcionarBotao("6", COR_CINZA_CLARO, constraints, 2, 2);
		adcionarBotao("-", COR_LARANJA, constraints, 3, 2);
		
//		LINHA 4
		adcionarBotao("1", COR_CINZA_CLARO, constraints, 0, 3);
		adcionarBotao("2", COR_CINZA_CLARO, constraints, 1, 3);
		adcionarBotao("3", COR_CINZA_CLARO, constraints, 2, 3);
		adcionarBotao("+", COR_LARANJA, constraints, 3, 3);
		
//		LINHA 5
		constraints.gridwidth = 2;
		adcionarBotao("0", COR_CINZA_CLARO, constraints, 0, 4);
		constraints.gridwidth = 1;
		adcionarBotao(",", COR_CINZA_CLARO, constraints, 2, 4);
		adcionarBotao("=", COR_LARANJA, constraints, 3, 4);

		
	}

	private void adcionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
			
		}
		
	}
}
