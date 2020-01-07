package daos;

import models.Assignment;

public interface AssignmentDao {
	AssignmentDao currentImplementation = new AssignmentDaoImpl();

	void createAssignment(Assignment assignment);

}
