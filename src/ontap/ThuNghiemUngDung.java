/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontap;

import controller.DanhSachHangHoa;
import model.HangHoa;

/**
 *
 * @author Thanh
 */
public class ThuNghiemUngDung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HangHoa hh1 = new HangHoa("hh01", "may say toc", "Long an", 300000, 100, "20/2/2023");
//        System.out.println(hh1.toString());
        DanhSachHangHoa list = new DanhSachHangHoa();
        try {
            list.Them(hh1);
            System.out.println(list.getData().size());
            list.XuatDS();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HangHoa hh2 = new HangHoa("hh02", "may giat", "Long an", 300000, 100, "20/2/2023");
        boolean checkSuaDS = list.Sua(hh2);
        if (checkSuaDS) {
            System.out.println("Sua thanh cong");
        } else {
            System.out.println("Sua khong thanh cong");
        }
        list.XuatDS();

        list.Xoa(hh1);
        System.out.println(list.getData().size());

    }

}
