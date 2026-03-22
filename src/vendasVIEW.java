import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends JFrame {
    private JTable tabelaVendidos;
    private JScrollPane scrollPane;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabelaVendidos = new JTable(new DefaultTableModel(
            new Object[]{"ID", "Nome", "Valor", "Status"}, 0
        ));
        scrollPane = new JScrollPane(tabelaVendidos);
        add(scrollPane);

        listarVendidos();
    }

    private void listarVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        DefaultTableModel model = (DefaultTableModel) tabelaVendidos.getModel();
        model.setRowCount(0);

        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();
        for (ProdutosDTO p : lista) {
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getValor(), p.getStatus()});
        }
    }
}