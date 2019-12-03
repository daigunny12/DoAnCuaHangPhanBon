
package Service;
import java.util.List;
import Object.HangHoaObj;


public interface HangHoaService {
    public List<HangHoaObj> getList();
    
    public boolean UpdateTable(HangHoaObj hangHoaObj);
    
    public boolean AddTable(HangHoaObj hangHoaObj);
}
