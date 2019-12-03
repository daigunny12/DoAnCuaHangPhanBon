package Object;

public class HoaDonBanHangObj {
    private String  khachHang, nhanVienLap, ngayLap;
    private int maHDBH;
    private boolean tinhTrang;

    public int getMaHDBH() {
        return maHDBH;
    }

    public void setMaHDBH(int maHDBH) {
        this.maHDBH = maHDBH;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(String nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
}
