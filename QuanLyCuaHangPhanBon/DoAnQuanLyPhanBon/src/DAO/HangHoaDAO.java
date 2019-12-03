
package DAO;
import java.util.List;
import Object.HangHoaObj;

public interface HangHoaDAO {
    public List<HangHoaObj> getList();
    
    public boolean UpdateTable(HangHoaObj hangHoaObj);
    
    public boolean AddTable(HangHoaObj hangHoaObj);
}
