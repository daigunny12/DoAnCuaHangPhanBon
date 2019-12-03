package Object;

public class HoaDonNhapHangObj {
    private String  ncc, nhanVienLap, ngayLap;
    private int maHDNH;
    private boolean tinhTrang;

    public int getMaHDNH() {
        return maHDNH;
    }

    public void setMaHDNH(int maHDNH) {
        this.maHDNH = maHDNH;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
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
