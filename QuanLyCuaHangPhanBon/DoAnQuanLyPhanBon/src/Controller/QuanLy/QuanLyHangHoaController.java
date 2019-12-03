package Controller.QuanLy;

import Model.QuanLyHangHoaMod;
import Service.HangHoaService;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import Service.HangHoaServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Menu.QuanLyView.JFame.HangHoaJFame;
import Object.HangHoaObj;
import RendenrerInJTable.AlignRenderer;
import RendenrerInJTable.CurrencyRenderer;
import javax.swing.table.TableCellRenderer;
import view.Menu.QuanLyView.HangHoaJPanel;

public class QuanLyHangHoaController {

    private JPanel pnView;
    private JButton btnAdd;
    private JTextField txtSearch;

    private HangHoaService hangHoaService = null;

    private String[] listColumn = {"STT", "Mã sp", "Tên sản phẩm", "Đơn vị tính", "Giá bán lẻ", "Giá bán sỉ", "Giá mua", "SL", "Ghi chú"};

    private TableRowSorter<TableModel> rowSorter = null;

    public TableCellRenderer centerAlight = new AlignRenderer();

    public TableCellRenderer centerAlight2 = new CurrencyRenderer();
    
    public QuanLyHangHoaController(JPanel pnView, JButton btnAdd, JTextField txtSearch) {
        this.pnView = pnView;
        this.btnAdd = btnAdd;
        this.txtSearch = txtSearch;

        this.hangHoaService = new HangHoaServiceImpl();
    }

    public void setDateToTable() {
        List<HangHoaObj> listItem = hangHoaService.getList();

        DefaultTableModel model = new QuanLyHangHoaMod().setTableHangHoa(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        table.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JTable tbl = (JTable) e.getSource();
                AlignRenderer.currentRow = tbl.rowAtPoint(e.getPoint());
                CurrencyRenderer.currentRow = tbl.rowAtPoint(e.getPoint());
                tbl.repaint();
            }
        });

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRowIndex = table.getSelectedRow();
                selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    HangHoaObj hangHoaObj = new HangHoaObj();
                    hangHoaObj.setMaHH((int) model.getValueAt(selectedRowIndex, 1));
                    hangHoaObj.setTeHH(model.getValueAt(selectedRowIndex, 2).toString());
                    hangHoaObj.setDonViTinh(model.getValueAt(selectedRowIndex, 3).toString());
                    hangHoaObj.setGiaBanLe((float) model.getValueAt(selectedRowIndex, 4));
                    hangHoaObj.setGiaBanSi((float) model.getValueAt(selectedRowIndex, 5));
                    hangHoaObj.setGiaMua((float) model.getValueAt(selectedRowIndex, 6));
                    hangHoaObj.setSl((int) model.getValueAt(selectedRowIndex, 7));
                    hangHoaObj.setGhiChu(model.getValueAt(selectedRowIndex, 8).toString());

                    HangHoaJFame hangHoaJFame = new HangHoaJFame(hangHoaObj, HangHoaJPanel.it);
                    hangHoaJFame.setTitle("Thông tin nhà cung cấp");
                    hangHoaJFame.setResizable(false);
                    hangHoaJFame.setVisible(true);
                    hangHoaJFame.setLocationRelativeTo(null);
                }
            }

        });

        for (int i = 0; i < 9; i++) {
            if (i == 4 || i == 5 || i == 6) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerAlight2);
            } else {
                table.getColumnModel().getColumn(i).setCellRenderer(centerAlight);
            }
        }
        // table.getColumnModel().getColumn(6).setCellRenderer(centerAlight2);
        //  CountryCellRenderer countryCellRenderer = new CountryCellRenderer();
        //  table.setDefaultRenderer(Object.class,countryCellRenderer );

        table.getColumnModel().getColumn(0).setMinWidth(60);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);

        table.getColumnModel().getColumn(1).setMinWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setPreferredWidth(0);

        table.getTableHeader().setBackground(new Color(102, 255, 255));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        pnView.removeAll();
        pnView.setLayout(new BorderLayout());
        pnView.add(scrollPane);
        pnView.validate();
        pnView.repaint();
    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HangHoaJFame hangHoaJFame = new HangHoaJFame(new HangHoaObj(), HangHoaJPanel.it);
                hangHoaJFame.setTitle("Thông tin hang hóa");
                hangHoaJFame.setResizable(false);
                hangHoaJFame.setVisible(true);
                hangHoaJFame.setLocationRelativeTo(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                btnAdd.setBackground(new Color(0, 153, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 153, 0));
            }

        });
    }
}
