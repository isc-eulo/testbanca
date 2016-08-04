package Junit.mvc.modelo;



import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, id extends Serializable> {

	List buscarTodos();

	boolean insertar(T objeto);

	boolean salvar(T objeto);

	T buscarPorClave(id id);

	boolean borrar(T objeto);

}