import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private static int nextId = 1;
    private Integer id;
    private String nome;
    private String tipo;
    private double valor;

    public Produto(String nome, String tipo, double valor) {
        this.id = nextId++;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Produto(String nome){
        this(nome, "", 0.0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome)&&Objects.equals(tipo, produto.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tipo);
    }

    @Override
    public int compareTo(Produto outroProduto) {
        if (this.nome == null && outroProduto.nome == null) {
            return 0;
        } else if (this.nome == null) {
            return -1;
        } else if (outroProduto.nome == null) {
            return 1;
        } else {
            return this.nome.compareTo(outroProduto.getNome());
        }
    }

    @Override
    public String toString(){
        return this.id+"\n"+this.nome+"\n"+this.tipo+"\n"+this.valor;
    }
}