import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaProduto {
    public static void main(String[] args) {
        Produto p1 = new Produto("TV");
        Produto p2 = new Produto("Armário");
        Produto p3 = new Produto("Lava-Louças");
        Produto p4 = new Produto("Blusa");

        List<Produto> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        Collections.sort(lista);
        for(Produto p:lista){
            System.out.println(p.getNome());
        }
    }
}
