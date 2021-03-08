package application;

import java.util.List;

public interface InsuranceDao {

	List<Insurance> getAllInsurance();
	Insurance getInsuranceByIndex(int number);
	void addNeInsurance(Insurance insurance);
	void deleteInsurance(Insurance insurance);
}
