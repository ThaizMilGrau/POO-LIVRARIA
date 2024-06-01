public class Ebook extends Produto{
    private double tamanhoDoArquivo;
    private String formatoDoArquivo;

    public Ebook(String titulo, String autor, double preco, double tamanhoDoArquivo, String formatoDoArquivo) {
        super(titulo, autor, preco);
        this.tamanhoDoArquivo = tamanhoDoArquivo;
        this.formatoDoArquivo = formatoDoArquivo;
    }

    public double getTamanhoDoArquivo() {
        return tamanhoDoArquivo;
    }

    public void setTamanhoDoArquivo (double tamanhoDoArquivo) {
        this.tamanhoDoArquivo = tamanhoDoArquivo;
    }

    public String getFormatoDoArquivo () {
        return formatoDoArquivo;
    }

    public void setFormatoDoArquivo (String formatoDoArquivo) {
        this.formatoDoArquivo = formatoDoArquivo;
    }

    @Override
    public String toString() {
    return super.toString() + ", tamanhoDoArquivo=" + tamanhoDoArquivo + ", formatoDoArquivo=" + formatoDoArquivo + "]";
}
}
