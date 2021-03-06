/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tebeshir.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yetkin.timocin
 */
public class FollowPostDAO {

    private CallableStatement callStmt;

    public int followPost(int postID, int studentID) throws InstantiationException, IllegalAccessException, SQLException {
        int result = -1;
        ResultSet rs = null;
        Connection dbConn = PostgresConnection.getConnection();
        try {
            dbConn.setAutoCommit(false);
            callStmt = dbConn.prepareCall("{? = call behati.pkgPostOperations.followPost(?, ?)}");
            callStmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            callStmt.setInt(2, postID);
            callStmt.setInt(3, studentID);
            callStmt.execute();
            result = callStmt.getBigDecimal(1).intValue();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } finally {
            PostgresConnection.closeResultSet(rs);
            PostgresConnection.closeStatement(callStmt);
            PostgresConnection.commit(dbConn);
            PostgresConnection.closeConnection(dbConn);
        }
        return result;
    }

    public int unfollowPost(int postID, int studentID) throws InstantiationException, IllegalAccessException, SQLException {
        int result = -1;
        ResultSet rs = null;
        Connection dbConn = PostgresConnection.getConnection();
        try {
            dbConn.setAutoCommit(false);
            callStmt = dbConn.prepareCall("{? = call behati.pkgPostOperations.unfollowPost(?, ?)}");
            callStmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            callStmt.setInt(2, postID);
            callStmt.setInt(3, studentID);
            callStmt.execute();
            result = callStmt.getBigDecimal(1).intValue();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } finally {
            PostgresConnection.closeResultSet(rs);
            PostgresConnection.closeStatement(callStmt);
            PostgresConnection.commit(dbConn);
            PostgresConnection.closeConnection(dbConn);
        }
        return result;
    }
}
