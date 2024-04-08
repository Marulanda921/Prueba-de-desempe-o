package Database;

import java.util.List;

public interface CRUD {

    Object insert(Object object);

    List<Object> findAll();

    boolean delete(Object object);

    boolean update(Object object);
}
