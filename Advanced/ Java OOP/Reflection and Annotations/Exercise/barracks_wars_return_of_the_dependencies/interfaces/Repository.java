package barracks_wars_return_of_the_dependencies.interfaces;

public interface Repository {

	void addUnit( Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
