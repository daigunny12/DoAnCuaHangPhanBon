package Control;
import Object.NhanVienObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NhanVienCtrl {

    public boolean logIn(NhanVienObj s){
        Connection conn = KetNoiCSDL.KetNoiCSDL();
        String sql = "select MaNV, MatKhau from NhanVien where MaNV=? and MatKhau =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaNV());
            ps.setString(2, s.getMatKhau());

           return ps.executeUpdate()>=0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
