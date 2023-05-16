package br.com.vip.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import br.com.vip.controller.ConsultarCep;
import br.com.vip.dao.ClienteDao;
import br.com.vip.dao.EnderecoDao;
import br.com.vip.model.Cliente;
import br.com.vip.model.Endereco;
import br.com.vip.util.JPAUtil;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ConsultarCep consultarCep = new ConsultarCep();
	private JTextField txtNome;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblRg;
	private JTextField txtRg;
	private JTextField txtCep;
	private JTextField txtRua;
	private JLabel lblRua;
	private JTextField txtComplemento;
	private JLabel lblComplemento;
	private JTextField txtNumero;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblEstado;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JTextField txtEstado;
	private JLabel lblEndereoAdicional;
	private JTextField txtCodigoCliente;
	private JTextField txtCodigoEndereco;
	private JTextField txtCepAdc;
	private JTextField txtRuaAdc;
	private JTextField txtComplementoAdc;
	private JTextField txtNumeroAdc;
	private JTextField txtBairroAdc;
	private JTextField txtCidadeAdc;
	private JTextField txtCodigoEnderecoAdc;
	private JTextField txtEstadoAdc;

	public void run() {
		try {
			TelaPrincipal window = new TelaPrincipal();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TelaPrincipal() {
		getContentPane().setBackground(SystemColor.control);
		initialize();
	}

	private void initialize() {
		setFont(new Font("SansSerif", Font.BOLD, 14));
		setBackground(new Color(211, 209, 252));
		setBounds(100, 100, 830, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Clientes");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTitulo.setBounds(22, 11, 177, 24);
		getContentPane().add(lblTitulo);

		JLabel lblLinha = new JLabel(
				"_______________________________________________________________________________________________");
		lblLinha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblLinha.setBounds(-21, 23, 955, 24);
		getContentPane().add(lblLinha);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNome.setBounds(148, 58, 55, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNome.setBounds(142, 83, 282, 25);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		lblCpf = new JLabel("CPF *");
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCpf.setBounds(440, 58, 37, 14);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCpf.setColumns(10);
		txtCpf.setBounds(437, 83, 170, 25);
		getContentPane().add(txtCpf);

		lblRg = new JLabel("RG");
		lblRg.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRg.setBounds(620, 58, 37, 14);
		getContentPane().add(lblRg);

		txtRg = new JTextField();
		txtRg.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtRg.setColumns(10);
		txtRg.setBounds(620, 83, 170, 25);
		getContentPane().add(txtRg);

		JLabel lblCadastroDeClientes = new JLabel("Endereço");
		lblCadastroDeClientes.setBackground(new Color(192, 192, 192));
		lblCadastroDeClientes.setVerticalAlignment(SwingConstants.TOP);
		lblCadastroDeClientes.setBounds(22, 119, 77, 24);
		getContentPane().add(lblCadastroDeClientes);
		lblCadastroDeClientes.setFont(new Font("SansSerif", Font.BOLD, 14));

		JPanel enderecoMain = new JPanel();
		enderecoMain.setToolTipText("");
		enderecoMain.setForeground(new Color(192, 192, 192));
		enderecoMain.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), null));
		enderecoMain.setBackground(SystemColor.controlHighlight);
		enderecoMain.setBounds(22, 138, 768, 130);
		getContentPane().add(enderecoMain);
		enderecoMain.setLayout(null);

		txtCep = new JTextField();
		txtCep.setBounds(10, 24, 110, 25);
		txtCep.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCep.setColumns(10);
		enderecoMain.add(txtCep);

		JLabel lblCep = new JLabel("CEP *");
		lblCep.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCep.setBounds(10, 7, 37, 14);
		enderecoMain.add(lblCep);

		txtRua = new JTextField();
		txtRua.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtRua.setColumns(10);
		txtRua.setBounds(243, 24, 233, 25);
		enderecoMain.add(txtRua);

		lblRua = new JLabel("Endereco *");
		lblRua.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRua.setBounds(246, 7, 83, 14);
		enderecoMain.add(lblRua);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(490, 24, 250, 25);
		enderecoMain.add(txtComplemento);

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblComplemento.setBounds(490, 7, 112, 14);
		enderecoMain.add(lblComplemento);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNumero.setColumns(10);
		txtNumero.setBounds(10, 80, 100, 25);
		enderecoMain.add(txtNumero);

		lblNumero = new JLabel("Numero *");
		lblNumero.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNumero.setBounds(10, 60, 83, 14);
		enderecoMain.add(lblNumero);

		lblBairro = new JLabel("Bairro *");
		lblBairro.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBairro.setBounds(120, 60, 83, 14);
		enderecoMain.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(120, 80, 250, 25);
		enderecoMain.add(txtBairro);

		lblCidade = new JLabel("Cidade *");
		lblCidade.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCidade.setBounds(380, 60, 83, 14);
		enderecoMain.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(380, 80, 250, 25);
		enderecoMain.add(txtCidade);

		lblEstado = new JLabel("Estado (UF)");
		lblEstado.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEstado.setBounds(640, 60, 83, 14);
		enderecoMain.add(lblEstado);

		txtCodigoEndereco = new JTextField();
		txtCodigoEndereco.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCodigoEndereco.setColumns(10);
		txtCodigoEndereco.setBounds(133, 24, 100, 25);
		enderecoMain.add(txtCodigoEndereco);

		JLabel lblCodigoEndereco = new JLabel("Codigo");
		lblCodigoEndereco.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCodigoEndereco.setBounds(133, 7, 83, 14);
		enderecoMain.add(lblCodigoEndereco);

		txtEstado = new JTextField();
		txtEstado.setBounds(638, 80, 120, 25);
		enderecoMain.add(txtEstado);
		txtEstado.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtEstado.setColumns(10);

		lblEndereoAdicional = new JLabel("Endereço Adicional");
		lblEndereoAdicional.setBounds(22, 279, 221, 24);
		getContentPane().add(lblEndereoAdicional);
		lblEndereoAdicional.setVerticalAlignment(SwingConstants.TOP);
		lblEndereoAdicional.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEndereoAdicional.setBackground(Color.LIGHT_GRAY);

		JButton btnSalvar = new JButton("Inserir");
		btnSalvar.setForeground(SystemColor.textText);
		btnSalvar.setBackground(SystemColor.control);
		btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalvar.setBounds(22, 498, 101, 30);
		getContentPane().add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(SystemColor.textText);
		btnExcluir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnExcluir.setBackground(SystemColor.control);
		btnExcluir.setBounds(359, 498, 101, 30);
		getContentPane().add(btnExcluir);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setBounds(22, 83, 110, 25);
		getContentPane().add(txtCodigoCliente);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(SystemColor.textText);
		btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsultar.setBackground(SystemColor.control);
		btnConsultar.setBounds(133, 498, 105, 30);
		getContentPane().add(btnConsultar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAtualizar.setBackground(SystemColor.menu);
		btnAtualizar.setBounds(248, 498, 101, 30);
		getContentPane().add(btnAtualizar);

		JLabel lblCodigoCliente = new JLabel("Codigo");
		lblCodigoCliente.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCodigoCliente.setBounds(22, 52, 55, 26);
		getContentPane().add(lblCodigoCliente);

		JPanel enderecoAdc = new JPanel();
		enderecoAdc.setLayout(null);
		enderecoAdc.setToolTipText("");
		enderecoAdc.setForeground(Color.LIGHT_GRAY);
		enderecoAdc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), null));
		enderecoAdc.setBackground(SystemColor.controlHighlight);
		enderecoAdc.setBounds(22, 302, 768, 130);
		getContentPane().add(enderecoAdc);

		txtCepAdc = new JTextField();
		txtCepAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCepAdc.setColumns(10);
		txtCepAdc.setBounds(10, 24, 110, 25);
		enderecoAdc.add(txtCepAdc);

		JLabel lblCepAdc = new JLabel("CEP *");
		lblCepAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCepAdc.setBounds(10, 7, 37, 14);
		enderecoAdc.add(lblCepAdc);

		txtRuaAdc = new JTextField();
		txtRuaAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtRuaAdc.setColumns(10);
		txtRuaAdc.setBounds(243, 24, 233, 25);
		enderecoAdc.add(txtRuaAdc);

		JLabel lblRuaAdc = new JLabel("Endereco *");
		lblRuaAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRuaAdc.setBounds(246, 7, 83, 14);
		enderecoAdc.add(lblRuaAdc);

		txtComplementoAdc = new JTextField();
		txtComplementoAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtComplementoAdc.setColumns(10);
		txtComplementoAdc.setBounds(490, 24, 250, 25);
		enderecoAdc.add(txtComplementoAdc);

		JLabel lblComplementoAdc = new JLabel("Complemento");
		lblComplementoAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblComplementoAdc.setBounds(490, 7, 112, 14);
		enderecoAdc.add(lblComplementoAdc);

		txtNumeroAdc = new JTextField();
		txtNumeroAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNumeroAdc.setColumns(10);
		txtNumeroAdc.setBounds(10, 80, 100, 25);
		enderecoAdc.add(txtNumeroAdc);

		JLabel lblNumeroAdc = new JLabel("Numero *");
		lblNumeroAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNumeroAdc.setBounds(10, 60, 83, 14);
		enderecoAdc.add(lblNumeroAdc);

		JLabel lblBairroAdc = new JLabel("Bairro *");
		lblBairroAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBairroAdc.setBounds(120, 60, 83, 14);
		enderecoAdc.add(lblBairroAdc);

		txtBairroAdc = new JTextField();
		txtBairroAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtBairroAdc.setColumns(10);
		txtBairroAdc.setBounds(120, 80, 250, 25);
		enderecoAdc.add(txtBairroAdc);

		JLabel lblCidadeAdc = new JLabel("Cidade *");
		lblCidadeAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCidadeAdc.setBounds(380, 60, 83, 14);
		enderecoAdc.add(lblCidadeAdc);

		txtCidadeAdc = new JTextField();
		txtCidadeAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCidadeAdc.setColumns(10);
		txtCidadeAdc.setBounds(380, 80, 250, 25);
		enderecoAdc.add(txtCidadeAdc);

		JLabel lblEstadoAdc = new JLabel("Estado (UF)");
		lblEstadoAdc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEstadoAdc.setBounds(640, 60, 83, 14);
		enderecoAdc.add(lblEstadoAdc);

		txtCodigoEnderecoAdc = new JTextField();
		txtCodigoEnderecoAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCodigoEnderecoAdc.setColumns(10);
		txtCodigoEnderecoAdc.setBounds(133, 24, 100, 25);
		enderecoAdc.add(txtCodigoEnderecoAdc);

		JLabel lblCodigoEndereco_1 = new JLabel("Codigo");
		lblCodigoEndereco_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCodigoEndereco_1.setBounds(133, 7, 83, 14);
		enderecoAdc.add(lblCodigoEndereco_1);

		txtEstadoAdc = new JTextField();
		txtEstadoAdc.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtEstadoAdc.setColumns(10);
		txtEstadoAdc.setBounds(638, 80, 120, 25);
		enderecoAdc.add(txtEstadoAdc);

		txtCep.addActionListener(this);
		txtCepAdc.addActionListener(this);
		btnSalvar.addActionListener(this::salvar);
		btnConsultar.addActionListener(this::consulta);
		btnAtualizar.addActionListener(this::atualizar);
		btnExcluir.addActionListener(this::excluirCliente);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtCep) {
			Endereco endereco = consultarCep.buscarEndereco(txtCep.getText());

			txtRua.setText(endereco.getRua());
			txtBairro.setText(endereco.getBairro());
			txtCidade.setText(endereco.getCidade());
			txtEstado.setText(endereco.getEstado());
		} else if (e.getSource() == txtCepAdc) {
			Endereco endereco = consultarCep.buscarEndereco(txtCepAdc.getText());

			txtRuaAdc.setText(endereco.getRua());
			txtBairroAdc.setText(endereco.getBairro());
			txtCidadeAdc.setText(endereco.getCidade());
			txtEstadoAdc.setText(endereco.getEstado());
		}
	}

	public void salvar(ActionEvent E) {

		if (!txtCodigoCliente.getText().isEmpty() && !txtNome.getText().isEmpty() && !txtCpf.getText().isEmpty()
				&& !txtCep.getText().isEmpty() && !txtCodigoEndereco.getText().isEmpty()
				&& !txtNumero.getText().isEmpty() && !txtRua.getText().isEmpty()) {

			Cliente cliente = new Cliente(Integer.parseInt(txtCodigoCliente.getText()), txtNome.getText(),
					txtCpf.getText(), txtRg.getText());
			Endereco endereco = new Endereco(Integer.parseInt(txtCodigoEndereco.getText()), txtRua.getText(),
					txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), txtCidade.getText(),
					txtEstado.getText(), cliente);

			if (!txtCodigoEndereco.getText().isEmpty() && !txtRuaAdc.getText().isEmpty()
					&& !txtNumeroAdc.getText().isEmpty() && !txtBairroAdc.getText().isEmpty()) {

				Endereco enderecoAdc = new Endereco(Integer.parseInt(txtCodigoEnderecoAdc.getText()),
						txtRuaAdc.getText(), txtNumeroAdc.getText(), txtComplementoAdc.getText(),
						txtBairroAdc.getText(), txtCidadeAdc.getText(), txtEstado.getText(), cliente);

				try {
					EntityManager em = JPAUtil.getEntityManager();
					ClienteDao clienteDao = new ClienteDao(em);
					EnderecoDao enderecoDao = new EnderecoDao(em);

					em.getTransaction().begin();

					enderecoDao.cadastrar(endereco);
					enderecoDao.cadastrar(enderecoAdc);
					clienteDao.cadastrar(cliente);

					em.getTransaction().commit();
					em.close();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cliente Cadastrado",
							JOptionPane.WARNING_MESSAGE);
					redefinir();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar o cliente: " + e.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				EntityManager em = JPAUtil.getEntityManager();
				ClienteDao clienteDao = new ClienteDao(em);
				EnderecoDao enderecoDao = new EnderecoDao(em);

				em.getTransaction().begin();

				enderecoDao.cadastrar(endereco);
				clienteDao.cadastrar(cliente);

				em.getTransaction().commit();
				em.close();
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cliente Cadastrado",
						JOptionPane.WARNING_MESSAGE);
				redefinir();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void consulta(ActionEvent e) {
		ConsultarClientes consultar = new ConsultarClientes();
		consultar.run();
	}

	public void excluirCliente(ActionEvent e) {
		ExcluirClientes excluir = new ExcluirClientes();
		excluir.run();
	}

	public void atualizar(ActionEvent e) {
		if (!txtCodigoCliente.getText().isEmpty() && !txtNome.getText().isEmpty() && !txtCpf.getText().isEmpty()
				&& !txtCep.getText().isEmpty() && !txtCodigoEndereco.getText().isEmpty()
				&& !txtNumero.getText().isEmpty() && !txtRua.getText().isEmpty()) {

			Cliente cliente = new Cliente(Integer.parseInt(txtCodigoCliente.getText()), txtNome.getText(),
					txtCpf.getText(), txtRg.getText());
			Endereco endereco = new Endereco(Integer.parseInt(txtCodigoEndereco.getText()), txtRua.getText(),
					txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), txtCidade.getText(),
					txtEstado.getText(), cliente);

			if (!txtCodigoEndereco.getText().isEmpty() && !txtRuaAdc.getText().isEmpty()
					&& !txtNumeroAdc.getText().isEmpty() && !txtBairroAdc.getText().isEmpty()) {

				Endereco enderecoAdc = new Endereco(Integer.parseInt(txtCodigoEnderecoAdc.getText()),
						txtRuaAdc.getText(), txtNumeroAdc.getText(), txtComplementoAdc.getText(),
						txtBairroAdc.getText(), txtCidadeAdc.getText(), txtEstado.getText(), cliente);
				try {
					EntityManager em = JPAUtil.getEntityManager();
					ClienteDao clienteDao = new ClienteDao(em);
					EnderecoDao enderecoDao = new EnderecoDao(em);

					em.getTransaction().begin();

					enderecoDao.atualizar(endereco);
					enderecoDao.atualizar(enderecoAdc);
					clienteDao.atualizar(cliente);

					em.getTransaction().commit();
					em.close();
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Cliente Atualizado",
							JOptionPane.WARNING_MESSAGE);
					redefinir();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o cliente: " + ex.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				EntityManager em = JPAUtil.getEntityManager();
				ClienteDao clienteDao = new ClienteDao(em);
				EnderecoDao enderecoDao = new EnderecoDao(em);

				em.getTransaction().begin();

				enderecoDao.atualizar(endereco);
				clienteDao.atualizar(cliente);

				em.getTransaction().commit();
				em.close();
				JOptionPane.showMessageDialog(null, "Cliente Atualizado com sucesso", "Cliente Cadastrado",
						JOptionPane.WARNING_MESSAGE);
				redefinir();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void redefinir() {
		txtCodigoCliente.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtRg.setText("");

		txtCodigoEndereco.setText("");
		txtCep.setText("");
		txtRua.setText("");
		txtComplemento.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEstado.setText("");

		txtCodigoEnderecoAdc.setText("");
		txtCepAdc.setText("");
		txtRuaAdc.setText("");
		txtComplementoAdc.setText("");
		txtNumeroAdc.setText("");
		txtBairroAdc.setText("");
		txtCidadeAdc.setText("");
		txtEstadoAdc.setText("");
	}
}
