package logic;
import java.util.ArrayList;

import entities.Lagerbar;
import views.LagerbarView;

public class Verwaltung {
	private LagerbarView lagerView;
	private LagerbarBuilder lagerModel;
	
	public Verwaltung() {
		lagerView = new LagerbarView();
		lagerModel = new LagerbarBuilder();
	}
}
