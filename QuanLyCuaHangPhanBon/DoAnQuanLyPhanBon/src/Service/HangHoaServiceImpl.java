
package Service;

import Object.HangHoaObj;
import java.util.List;
import DAO.HangHoaDAO;
import DAO.HangHoaDAOImpl;


public class HangHoaServiceImpl implements HangHoaService{

    private HangHoaDAO hangHoaDAO = null;

    public HangHoaServiceImpl() {
        this.hangHoaDAO = new HangHoaDAOImpl();
    }
    
    
    @Override
    public List<HangHoaObj> getList() {
       return  hangHoaDAO.getList();
    }

    @Override
    public boolean UpdateTable(HangHoaObj hangHoaObj) {
        return hangHoaDAO.UpdateTable(hangHoaObj);
    }

    @Override
    public boolean AddTable(HangHoaObj hangHoaObj) {
        return hangHoaDAO.AddTable(hangHoaObj);
    }
    
}
