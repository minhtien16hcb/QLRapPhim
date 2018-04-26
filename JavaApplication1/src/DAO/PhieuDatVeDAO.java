/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Sqlconnect;
import static DAO.PhimDAO.a;
import static DAO.PhimDAO.rs;
import static DAO.PhimDAO.sqlcn;
import DTO.PhimDTO;
import DTO.PhieuDatVeDTO;
import DTO.RapDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhieuDatVeDAO {
   public static Connection a;
   public static ResultSet rs;
   public static  Sqlconnect sqlcn;
     public List<PhimDTO> laydanhsachphim() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhimDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHIM");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach Hoc Sinh");
        try {
          
            while(rs.next())
            {
  
                  PhimDTO phim=new PhimDTO();
               phim.setMAPHIM(rs.getString("MAPHIM"));
               phim.setTENPHIM(rs.getString("TENPHIM"));
                phim.setNAMSX(rs.getInt("NAMSX"));
               phim.setHANGPHIM(rs.getString("HANGPHIM"));
                 phim.setTHOILUONG(rs.getInt("THOILUONG"));
                   phim.setMOTA(rs.getString("MOTA"));
               list.add(phim);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao hoc sinh ");
            
        }
         
        
        return list;
    }
    
   public String PhatSinhPDV() throws SQLException, ClassNotFoundException
   {
        sqlcn=new Sqlconnect();
         //Statement statement = a.createStatement();
        //ResultSet rs1=statement.executeQuery("select top 1 MaRap from RAP where MaRap = " + );
      
      
      String ma = "";
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select top 1 * from VE order by MAVE desc");
            while(rs.next())
            {
              ma = rs.getString("MAVE");
            }
            
            if(ma == "")
            {
                    ma = "V/0" +  1;
                    return ma;
            }
                 
            
            String[] split = ma.split("/");
            String  m = split[1].toString().trim();
            int n = Integer.parseInt(m);
            if(n < 9)
            {
                n = n + 1;
                ma = "V/0" +  n;
                
            }
            else
            {
                 n = n + 1;
                ma = "V/" +  n;
            }
         return  ma;
   } 
   
   
    public void themmotphieudat(PhieuDatVeDTO phieu) throws ClassNotFoundException 
    {
           sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into VE values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phieu.MAVE );
           ps.setDate(2, Date.valueOf(LocalDate.now()));
          
           ps.setString(3, phieu.TENCC);
           ps.setString(4, phieu.TENKH);
           ps.setString(5, phieu.TENPC);
           ps.setString(6, phieu.TENNV);
           ps.setString(7, phieu.TENPHIM);
           ps.setString(8, phieu.TENGHE);
           ps.executeUpdate();
           System.out.print("them phieu dat thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public List<PhieuDatVeDTO> laydanhsachphieudatve() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhieuDatVeDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from VE");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach Phieu Dat Ve");
        try {
          
            while(rs.next())
            {

                PhieuDatVeDTO phieudat=new PhieuDatVeDTO();
               phieudat.setMAVE(rs.getString("MAVE"));
                phieudat.setNGAYCHIEU(rs.getDate("NGAYCHIEU"));
                phieudat.setTENCC(rs.getString("TENCC"));
              phieudat.setTENKH(rs.getString("TENKH"));
                 phieudat.setTENPC(rs.getString("TENPC"));
                  phieudat.setTENNV(rs.getString("TENNV"));
                    phieudat.setTENPHIM(rs.getString("TENPHIM"));
                  phieudat.setTENGHE(rs.getString("TENGHE"));
               
               list.add(phieudat);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao phieu dat ve ");
            
        }
         
        
        return list;
    }
     
      public void xoaphieudat(PhieuDatVeDTO phieudatve) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();

        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE VE WHERE VE.MAVE= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phieudatve.MAVE );
           ps.executeUpdate();
           System.out.print("xoa bo phieu dat ve thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatphieudatve(PhieuDatVeDTO phieudatve) throws ClassNotFoundException 
    {
           sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            

            String sql="UPDATE PHIEUDATVE SET TENCC=?, TENKH=?, TENPC=?,TENPHIM=?,TENGHE=? WHERE MAVE =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phieudatve.getTENCC());
           ps.setString(2,phieudatve.getTENKH());
           ps.setString(3,phieudatve.getTENPC());
         
           ps.setString(4,phieudatve.getTENPHIM());
           ps.setString(5,phieudatve.getTENGHE());
           ps.setString(6,phieudatve.getMAVE());
           ps.executeUpdate();
           System.out.print("cap nhat phieu dat ve thanh cong ");
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
        public ResultSet lapbaocaophieudatve() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhieuDatVeDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from VE");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
        
         
        
        return rs;
    }
}
