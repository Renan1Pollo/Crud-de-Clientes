package br.com.vip.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.vip.dao.ClienteDao;
import br.com.vip.dao.EnderecoDao;
import br.com.vip.model.Endereco;
import br.com.vip.util.JPAUtil;

public class ExcluirClientes {

	private JFrame frmConsultaDeClientes;
	private JTextField txtCodigoBusca;
	private JTable jTableClientes;

	public void run() {
		try {
			ExcluirClientes window = new ExcluirClientes();
			window.frmConsultaDeClientes.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ExcluirClientes() {
		initialize();
	}

	private void initialize() {
		frmConsultaDeClientes = new JFrame();
		frmConsultaDeClientes.getContentPane().setBackground(SystemColor.control);
		frmConsultaDeClientes.setTitle("Consulta de Clientes");
		frmConsultaDeClientes.setBounds(100, 100, 600, 450);
		frmConsultaDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeClientes.getContentPane().setLayout(null);

		JLabel lblCodReq = new JLabel("Codigo do Cliente");
		lblCodReq.setBounds(10, 13, 110, 20);
		lblCodReq.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frmConsultaDeClientes.getContentPane().add(lblCodReq);

		txtCodigoBusca = new JTextField();
		txtCodigoBusca.setBounds(10, 34, 121, 25);
		txtCodigoBusca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frmConsultaDeClientes.getContentPane().add(txtCodigoBusca);
		txtCodigoBusca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(154, 11, 89, 25);
		btnBuscar.setBackground(SystemColor.control);
		btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frmConsultaDeClientes.getContentPane().add(btnBuscar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(154, 45, 89, 25);
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		frmConsultaDeClientes.getContentPane().add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 564, 280);
		frmConsultaDeClientes.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 564, 280);
		panel.add(scrollPane);

		jTableClientes = new JTable();
		scrollPane.setViewportView(jTableClientes);
		jTableClientes.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Codigo Endereco", "Endereco", "Cidade", "Codigo Cliente", "Nome" }));

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnExcluir.setBackground(SystemColor.control);
		btnExcluir.setBounds(485, 375, 89, 25);
		frmConsultaDeClientes.getContentPane().add(btnExcluir);
		frmConsultaDeClientes.setLocationRelativeTo(null);

		btnBuscar.addActionListener(this::buscar);
		btnExcluir.addActionListener(this::excluir);
		btnCancelar.addActionListener(this::cancelar);
	}

	public void buscar(ActionEvent e) {

		if (!txtCodigoBusca.getText().isEmpty()) {
			DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
			model.setRowCount(0);
			EntityManager em = JPAUtil.getEntityManager();
			EnderecoDao enderecoDao = new EnderecoDao(em);
			List<Endereco> enderecos = enderecoDao.buscarPorId(Integer.parseInt(txtCodigoBusca.getText()));

			for (Endereco endereco : enderecos) {
				Object[] dados = { endereco.getId(), endereco.getRua(), endereco.getCidade(),
						endereco.getCliente().getId(), endereco.getCliente().getNome() };
				model.addRow(dados);
			}

		} else {
			DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
			model.setRowCount(0);
			JOptionPane.showMessageDialog(null, "Informe um codigo valido!", "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void excluir(ActionEvent e) {
		int codigoExclusao = Integer.parseInt(txtCodigoBusca.getText());
		EntityManager em = JPAUtil.getEntityManager();

		EnderecoDao enderecoDao = new EnderecoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		enderecoDao.excluir(codigoExclusao);
		clienteDao.excluir(codigoExclusao);
		DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
		model.setRowCount(0);
	}

	public void cancelar(ActionEvent e) {
		frmConsultaDeClientes.dispose();
	}

}
