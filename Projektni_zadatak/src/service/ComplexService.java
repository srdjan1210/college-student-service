package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkakacDAO;
import dao.SkakaonicaDAO;
import dao.SkokDAO;
import dao.impl.SkakacDAOImpl;
import dao.impl.SkakaonicaDAOImpl;
import dao.impl.SkokDAOImpl;
import model.Skakac;
import model.Skakaonica;
import model.Skok;

public class ComplexService {
	private static SkokDAO skokDAO = new SkokDAOImpl();
	private static SkakacDAO skakacDAO = new SkakacDAOImpl();
	private static SkakaonicaDAO skakaonicaDAO = new SkakaonicaDAOImpl();
		
	
	public List<Skok> getSkokFromDrzava(String idd) throws SQLException{
		List<Skakaonica> skakaoniceFromDrzava = skakaonicaDAO.findSkakaonicaByIdd(idd);
		List<Skakac> skakaciFromDrzava = skakacDAO.findSkakacByIdd(idd);
		List<Skok> skokovi = new ArrayList<Skok>();
		for(Skakaonica skakaonica : skakaoniceFromDrzava){
			for(Skakac skakac : skakaciFromDrzava){
				List<Skok> skokovi2 = skokDAO.findSkokBySkakaonicaAndSkakacId(skakaonica.getId(), skakac.getId());
				for(Skok skok:skokovi2){
					skokovi.add(skok);
				}
			}
		}
		return skokovi;
	}
	
	public boolean updatePBSCIfNeeded(String idSkok) throws SQLException{
		Skok skok = skokDAO.findById(idSkok);
		double newScore = skok.getBodoviDuzina() + skok.getBodoviStil() + skok.getBodoviVetar();
		double pbsc = skakacDAO.getPBSC(skok.getSkakacId());
		if(newScore > pbsc){
			if(skakacDAO.updatePBSC(newScore,skok.getSkakacId()) == true);
				return true;
		}
		else
			return false;
	}
}
