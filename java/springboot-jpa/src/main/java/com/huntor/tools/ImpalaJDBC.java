package com.huntor.tools;

/**
 * Created by liuyang on 2017/8/2.
 */
import com.huntor.demo.entity.TagLifeCycleLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpalaJDBC {
    private static final String SQL_STATEMENT = "SELECT * FROM customer_attr_info limit 10";
    private static final String IMPALAD_HOST = "192.168.100.123";
    private static final String IMPALAD_JDBC_PORT = "21050";
    private static final String CONNECTION_URL = "jdbc:hive2://" + IMPALAD_HOST + ':' + IMPALAD_JDBC_PORT + "/huntor_sit_life;auth=noSasl";

    private static final String JDBC_DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";

    public TagLifeCycleLog findLog(String string) {
        System.out.println("Cloudera Impala JDBC Example");
        System.out.println("Using Connection URL: " + CONNECTION_URL);
        System.out.println("Running Query: " + string);
        TagLifeCycleLog TagLifeCycleLog =new TagLifeCycleLog();
        Connection con = null;
        try {

            Class.forName(JDBC_DRIVER_NAME);
            con = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(string);
            System.out.println("Begin Query Results");
            while (rs.next()) {
                TagLifeCycleLog.setCalculationTime(rs.getInt("calculation_time"));
                TagLifeCycleLog.setCalculationType(rs.getString("calculation_type"));
                TagLifeCycleLog.setInNumber(rs.getInt("in_number"));
                TagLifeCycleLog.setOutNumber(rs.getInt("out_number"));
                TagLifeCycleLog.setIsSuccees(rs.getString("is_succees"));
                TagLifeCycleLog.setCreateTime(rs.getTimestamp("create_time"));
                System.out.println(TagLifeCycleLog.toString());
            }

            System.out.println("End Query Results");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return TagLifeCycleLog;
    }

    public List<Integer> findTrans(String string) {
        System.out.println("Cloudera Impala JDBC Example");
        System.out.println("Using Connection URL: " + CONNECTION_URL);
        System.out.println("Running Query: " + string);
        Connection con = null;
//        List<TagLifeCycleTrans> customerLifeCycleTranses=new ArrayList<>();
        List<Integer> list=new ArrayList<Integer>();
        try {

            Class.forName(JDBC_DRIVER_NAME);
            con = DriverManager.getConnection(CONNECTION_URL);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(string);
            System.out.println("Begin Query Results");
            while (rs.next()) {
                    Integer conut=rs.getInt(1);
                    list.add(conut);
//                TagLifeCycleTrans customerLifeCycleTrans=new TagLifeCycleTrans();
//                customerLifeCycleTrans.setId(rs.getInt("id"));
//                customerLifeCycleTrans.setCreateTime(rs.getTimestamp("create_time"));
//                customerLifeCycleTrans.setCustomerId(rs.getString("customer_id"));
//                customerLifeCycleTrans.setLastdayLifeCycleAttributeDefinition_id(rs.getInt("lastDay_life_cycle_attribute_definition_id"));
//                customerLifeCycleTrans.setLifeCycleAttributeDefinitionId(rs.getInt(rs.getInt("life_cycle_attribute_definition_id")));
//                customerLifeCycleTranses.add(customerLifeCycleTrans);
                System.out.println(conut.toString());
            }
            System.out.println("End Query Results");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

//    public Integer findCount(String string) {
//        System.out.println("Cloudera Impala JDBC Example");
//        System.out.println("Using Connection URL: " + CONNECTION_URL);
//        System.out.println("Running Query: " + string);
//        List<CustormerAttrInfo> resList=new ArrayList<>();
//        Connection con = null;
//        try {
//
//            Class.forName(JDBC_DRIVER_NAME);
//            con = DriverManager.getConnection(CONNECTION_URL);
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(string);
//            System.out.println("Begin Query Results");
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (Exception e) {
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args){
//        System.out.println("Cloudera Impala JDBC Example");
//        System.out.println("Using Connection URL: " + CONNECTION_URL);
//        System.out.println("Running Query: " + SQL_STATEMENT);
//        List<CustormerAttrInfo> resList=new ArrayList<>();
//        Connection con = null;
//        try {
//
//            Class.forName(JDBC_DRIVER_NAME);
//            con = DriverManager.getConnection(CONNECTION_URL);
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(SQL_STATEMENT);
//            System.out.println("Begin Query Results");
//            while (rs.next()) {
//                CustormerAttrInfo custormerAttrInfo=new CustormerAttrInfo();
//                custormerAttrInfo.setCustomerId(rs.getString(1));
//                custormerAttrInfo.setBasicName(rs.getString(2));
//                custormerAttrInfo.setBasicMobile(rs.getString(3));
//                custormerAttrInfo.setBasicCustomerStatus(rs.getString(4));
//                custormerAttrInfo.setBehaviourPubMessages(rs.getLong(5));
//                custormerAttrInfo.setBehaviourPubEvent(rs.getLong(6));
//                custormerAttrInfo.setBehaviourPubClick(rs.getLong(7));
//                custormerAttrInfo.setBehaviourPubInteracted(rs.getLong(8));
//                custormerAttrInfo.setBehaviourSocMessages(rs.getLong(9));
//                custormerAttrInfo.setBehaviourLatestPurchaseTime(rs.getDate(10));
//                custormerAttrInfo.setTopBasic(rs.getDouble(11));
//                custormerAttrInfo.setTopBehavior(rs.getDouble(12));
//                custormerAttrInfo.setTopDemand(rs.getDouble(13));
//                custormerAttrInfo.setSecBasicDemography(rs.getDouble(14));
//                custormerAttrInfo.setSecBasicIdentification(rs.getDouble(15));
//                custormerAttrInfo.setSecBasicFiancredit(rs.getDouble(16));
//                custormerAttrInfo.setSecBasicPreference(rs.getDouble(17));
//                custormerAttrInfo.setSecBehBrand(rs.getDouble(18));
//                custormerAttrInfo.setSecBehConsumption(rs.getDouble(19));
//                custormerAttrInfo.setSecBehService(rs.getDouble(20));
//                custormerAttrInfo.setSecBehMember(rs.getDouble(21));
//                custormerAttrInfo.setSecBehIndependentonline(rs.getDouble(22));
//                custormerAttrInfo.setSecBehIndependentoffline(rs.getDouble(23));
//                custormerAttrInfo.setSecDemandCommodity(rs.getDouble(24));
//                custormerAttrInfo.setSecDemandRelationship(rs.getDouble(25));
//                custormerAttrInfo.setSecDemandNewcost(rs.getDouble(26));
//                custormerAttrInfo.setSecDemandOperatcosts(rs.getDouble(27));
//                custormerAttrInfo.setSecDemandConsumcapacity(rs.getDouble(28));
//                resList.add(custormerAttrInfo);
//                System.out.println(custormerAttrInfo.toString());
//            }
//
//            System.out.println("End Query Results");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (Exception e) {
//            }
//        }
//    }

}
