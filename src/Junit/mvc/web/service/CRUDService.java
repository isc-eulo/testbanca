package Junit.mvc.web.service;

import java.util.List;

public interface CRUDService<T> {
List<T> todos();
T buscarPorID(int id);
boolean nuevoElemento(T t);
boolean eliminarElemento(Integer id);
boolean actulizar (T t);
}
