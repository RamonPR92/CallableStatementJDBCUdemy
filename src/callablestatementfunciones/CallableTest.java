/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callablestatementfunciones;

import datos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author rperez
 */
public class CallableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int empleadoId = 100;
        try {
            Connection connection = Conexion.getConnection();
            CallableStatement callableStatement = null;
            double salarioMensual;
            callableStatement = connection.prepareCall("{ ? = call get_employee_salary(?) }");
            callableStatement.registerOutParameter(1,java.sql.Types.INTEGER);
            callableStatement.setInt(2, empleadoId);
            callableStatement.execute();
            salarioMensual = callableStatement.getDouble(1);
            callableStatement.close();
            System.out.println("Empleado con id: " + empleadoId);
            System.out.println("Salario $ " + salarioMensual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
