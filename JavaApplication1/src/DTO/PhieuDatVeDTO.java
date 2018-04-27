/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class PhieuDatVeDTO {
     public String getMAVE() {
        return MAVE;
    }
    public void setMAVE(String MAVE) {
        this.MAVE = MAVE;
    }
    public Date getNGAYCHIEU() {
        return NGAYCHIEU;
    }

    public void setNGAYCHIEU(Date NGAYCHIEU) {
        this.NGAYCHIEU = NGAYCHIEU;
    }
    
    public String getTENCC() {
        return TENCC;
    }
    public void setTENCC(String TENCC) {
        this.TENCC = TENCC;
    }
    public String getTENKH() {
        return TENKH;
    }
    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }
    
    public String getTENNV() {
        return TENNV;
    }
    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }
    
    public String getTENPHIM() {
        return TENPHIM;
    }
    public void setTENPHIM(String TENPHIM) {
        this.TENPHIM = TENPHIM;
    }
    
    public String getTENGHE() {
        return TENGHE;
    }
    public void setTENGHE(String TENGHE) {
        this.TENGHE = TENGHE;
    }
    public String getTENPC() {
        return TENPC;
    }
    public void setTENPC(String TENPC) {
        this.TENPC = TENPC;
    }
    public String MAVE;
    public Date NGAYCHIEU;
    public String TENCC;
    public String TENKH;
    public String TENNV;
    public String TENPC;
    public String TENPHIM;
    public String TENGHE;


}
