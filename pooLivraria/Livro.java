public class Livro extends Produto {
    private String genero;
    private String editora;
    private int numeroDePaginas;

    public Livro (String titulo, String autor, double preco, String genero, String editora, int numeroDePaginas) {
        super(titulo, autor, preco);
        this.genero = genero;
        this.editora = editora;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas (int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String toString() {
        return super.toString() + ", genero=" + genero + ", editora=" + editora + ", numeroDePaginas=" + numeroDePaginas + "]";
    }
}
