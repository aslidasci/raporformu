package com.iati.rapor.jdbc;

import java.sql.SQLException;

public interface IProcedureExecutor {

	Object execProc(ProcedureDefinition definition, Object[] args) throws SQLException;

}
