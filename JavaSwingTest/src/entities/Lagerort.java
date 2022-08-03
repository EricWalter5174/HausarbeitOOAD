/**
 * Simple Java-Klasse für Lagerorte, die vom Nutzer erstellt werden können sollen
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

public class Lagerort {
	private String name;
	public Lagerort(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
