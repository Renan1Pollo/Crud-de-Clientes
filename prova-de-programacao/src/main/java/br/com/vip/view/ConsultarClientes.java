package br.com.vip.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.vip.dao.EnderecoDao;
import br.com.vip.model.Endereco;
import br.com.vip.util.JPAUtil;

public class ConsultarClientes {

	private JFrame frmConsultaDeClientes;
	private JTextField txtCodigoBusca;
	private JTable jTableClientes;

	public void run() {
		try {
			ConsultarClientes window = new ConsultarClientes();
			window.frmConsultaDeClientes.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConsultarClientes() {
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
		lblCodReq.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCodReq.setBounds(20, 11, 110, 20);
		frmConsultaDeClientes.getContentPane().add(lblCodReq);

		txtCodigoBusca = new JTextField();
		txtCodigoBusca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCodigoBusca.setBounds(20, 33, 121, 25);
		frmConsultaDeClientes.getContentPane().add(txtCodigoBusca);
		txtCodigoBusca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.control);
		btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnBuscar.setBounds(165, 11, 89, 25);
		frmConsultaDeClientes.getContentPane().add(btnBuscar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.control);
		btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnCancelar.setBounds(165, 45, 89, 25);
		frmConsultaDeClientes.getContentPane().add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 564, 319);
		frmConsultaDeClientes.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 564, 319);
		panel.add(scrollPane);

		jTableClientes = new JTable();
		scrollPane.setViewportView(jTableClientes);
		jTableClientes.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Codigo Endereco", "Endereco", "Cidade", "Codigo Cliente", "Nome" }));
		frmConsultaDeClientes.setLocationRelativeTo(null);

		btnBuscar.addActionListener(this::buscar);
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
			EntityManager em = JPAUtil.getEntityManager();
			EnderecoDao enderecoDao = new EnderecoDao(em);
			List<Endereco> enderecos = enderecoDao.buscarTodos();

			for (Endereco endereco : enderecos) {
				Object[] dados = { endereco.getId(), endereco.getRua(), endereco.getCidade(),
						endereco.getCliente().getId(), endereco.getCliente().getNome() };
				model.addRow(dados);
			}

		}
	}

	public void cancelar(ActionEvent e) {
		frmConsultaDeClientes.dispose();
	}
}
