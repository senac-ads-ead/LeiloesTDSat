import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends JFrame {

    private final JTable listaVendas = new JTable();

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 330);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Produtos Vendidos", SwingConstants.CENTER);
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(event -> dispose());

        setLayout(new BorderLayout(10, 10));
        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(listaVendas), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rodape.add(btnVoltar);
        add(rodape, BorderLayout.SOUTH);

        listarProdutosVendidos();
    }

    private void listarProdutosVendidos() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {}, new String[] {"ID", "Nome", "Valor", "Status"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        listaVendas.setModel(model);

        try {
            ArrayList<ProdutosDTO> produtos = new ProdutosDAO().listarProdutosVendidos();
            for (ProdutosDTO produto : produtos) {
                model.addRow(new Object[] {
                    produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                    this, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
