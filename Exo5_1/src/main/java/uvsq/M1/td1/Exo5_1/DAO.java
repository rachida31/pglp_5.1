package uvsq.M1.td1.Exo5_1;

import java.util.List;
import java.util.Optional;

public interface DAO {
	
	
	
	
	Optional<Personnel> get(long id);

    List<Personnel> getAll();

    void save(Personnel t);

    void update(Personnel t, String[]params);

    void delete(Personnel t);
	

}
