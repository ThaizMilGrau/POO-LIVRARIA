import java.util.Date;
import java.util.List;

public class Pedido {
    private int numero;
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(int numero, Date data, Cliente cliente, List<Produto> produtos) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido [numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", produtos=" + produtos + "]";
    }
}
