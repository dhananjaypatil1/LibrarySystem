package javax.servlet.jsp.jstl.sql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.re
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/*
 * Copyright 1999-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

/**
 * <p>Supports the creation of a javax.servlet.jsp.jstl.sql.Result object 
 * from a source java.sql.ResultSet object. A Result object makes it much 
 * easier for page authors to access and manipulate the data resulting 
 * from a SQL query.</p>
 *
 * @author Justyna Horwat
 *
 */
public class ResultSupport {


    /**
     * Converts a <code>ResultSet</code> object to a <code>Result</code> object.
     *
     * @param rs the <code>ResultSet</code> object
     *
     * @return The <code>Result</code> object created from the <code>ResultSet</code>
     */
    public static ResultImpl toResult(ResultSet rs) {
        try {
            return new ResultImpl(rs, -1, -1);
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Converts <code>maxRows</code> of a <code>ResultSet</code> object to a 
     * <code>Result</code> object.
     *
     * @param rs the <code>ResultSet</code> object
     * @param maxRows the maximum number of rows to be cached into the <code>Result</code> object.
     *
     * @return The <code>Result</code> object created from the <code>ResultSet</code>,
     * limited by <code>maxRows</code>
     */
    public static ResultImpl toResult(ResultSet rs, int maxRows) {
        try {
            return  new ResultImpl(rs, -1, maxRows);
        } catch (SQLException ex) {
            return null;
        }
    }

}
