/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Thanh
 */
public class HangHoaIT {

    public HangHoaIT() {
    }

    @Test
    public void testHangHoaHopLe() {
        System.out.println("constructor hop le");
        HangHoa hh = new HangHoa("hh01", "Kem danh rang", "my tho", 5, 3, "1/1/2023");
//        System.out.println(hh.toString());
        String expResult = "HangHoa{ma=hh01, ten=Kem danh rang, noisx=my tho, gia=5, soluong=3, ngaySX=1/1/2023, ThanhTien=15}";
        String result = hh.toString();
        Assert.assertEquals(expResult, result);
    }
    @Test
    public void testHangHoaKhongHopLe() {
        System.out.println("constructor khong hop le");
        HangHoa hh1 = new HangHoa("hh001", "may say toc", "Long an", 300000, 100, "20/2/2023");
        String expResult = "HangHoa{ma=hh01, ten=may say toc, noisx=Long an, gia=300000, soluong=100, ngaySX=20/2/2023, ThanhTien=30000000}";
        String result = hh1.toString();
        Assert.assertNotEquals(expResult, result);
    }
}
