package AuxClass;
/**
 *
 * @author Angelo
 * @param <T>
 */
public class Set<T> {

    private List list;
    
    public Set() {
        this.list = new List("lista-1");
    }

    public void insertar(T info) {
        if (!contiene(info)) {
            list.append(info);
        }
    }

    public boolean contiene(T info) {
        Node<T> nodo = list.getSpecificNode(info);
        return nodo != null;
    }

    public List<T> getLista() {
        return list;
    }

    public void setLista(List<T> lista) {
        this.list = lista;
    }

}