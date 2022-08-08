/**
 * Simple Java-Klasse für Lagerorte, die vom Nutzer erstellt werden können sollen.
 * Lagerorte werden zur Laufzeit dynamisch erzeugt, 
 * nachdem sie aus der Inputdatei eingelesen wurden.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

public class Lagerort {
	
	private String name;
	
	public Lagerort(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
