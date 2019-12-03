
package DAO;

import Object.HangHoaObj;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HangHoaDAOImpl implements HangHoaDAO{

    @Override
    public List<HangHoaObj> getList() {
       Connection conn = new KetNoiCSDL().KetNoiCSDL();
       List<HangHoaObj> list = new ArrayList<HangHoaObj>();
       String sql= "select * from HangHoa where TinhTrang = 'True'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HangHoaObj hh = new HangHoaObj();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setTeHH(rs.getString("TenHH"));
                hh.setDonViTinh(rs.getString("DonViTinh"));
                hh.setGiaBanLe(rs.getFloat("GiaBanLe"));
                hh.setGiaBanSi(rs.getFloat("GiaBanSi"));
                hh.setGiaMua(rs.getFloat("GiaMua"));
                hh.setSl(rs.getInt("SoLuong"));
                hh.setGhiChu(rs.getString("GhiChu"));
                
                list.add(hh);
            }  
            ps.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }

    @Override
    public boolean UpdateTable(HangHoaObj hangHoaObj) {
        Connection conn = KetNoiCSDL.KetNoiCSDL();
        String sql = "update HangHoa set TenHH =? , DonViTinh = ?, GiaBanLe = ?, GiaBanSi = ?, GiaMua = ?, SoLuong = ?, GhiChu = ?, TinhTrang ='True' where MaHH =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hangHoaObj.getTeHH());
            ps.setString(2, hangHoaObj.getDonViTinh());
            ps.setFloat(3, hangHoaObj.getGiaBanLe());
            ps.setFloat(4, hangHoaObj.getGiaBanSi());
            ps.setFloat(5, hangHoaObj.getGiaMua());
            ps.setFloat(6, hangHoaObj.getSl());
            ps.setString(7, hangHoaObj.getGhiChu());
            ps.setInt(8, hangHoaObj.getMaHH());
            
            return ps.executeUpdate()>=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean AddTable(HangHoaObj hangHoaObj) {
        Connection conn = KetNoiCSDL.KetNoiCSDL();
        String sql = "insert into HangHoa(TenHH,DonViTinh,GiaBanLe,GiaBanSi,GiaMua,SoLuong,GhiChu,TinhTrang) values(?,?,?,?,?,?,?,'True')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hangHoaObj.getTeHH());
            ps.setString(2, hangHoaObj.getDonViTinh());
            ps.setFloat(3, hangHoaObj.getGiaBanLe());
            ps.setFloat(4, hangHoaObj.getGiaBanSi());
            ps.setFloat(5, hangHoaObj.getGiaMua());
            ps.setFloat(6, hangHoaObj.getSl());
            ps.setString(7, hangHoaObj.getGhiChu());
            
            return ps.executeUpdate()>=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
