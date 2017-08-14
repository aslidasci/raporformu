package com.iati.rapor.jdbc;

import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

public class ProcedureDefinition {
	private String schemaName;
	private String name;
	private RowMapper rowMapper;
	private int outputType = 0;
	private int[] types;
	private String mapperName[];
	private String compiledSQL;
	private boolean hasoutput = true;

	public ProcedureDefinition(String schemaName, String name, RowMapper rowMapper, Object... types) {
		this.schemaName = schemaName;
		this.name = name;
		this.rowMapper = rowMapper;
		initMappers(types);
	}

	// public ProcedureDefinition(String schemaName, String name, int
	// outputType, int... types) {
	// this.schemaName = schemaName;
	// this.name = name;
	// this.outputType = outputType;
	// this.types = types;
	// init();
	// }

	// public ProcedureDefinition(String schemaName, String name, boolean
	// hasoutput, int... types) {
	// this.schemaName = schemaName;
	// this.name = name;
	// this.types = types;
	// this.hasoutput = hasoutput;
	// init();
	// }

	public ProcedureDefinition(String schemaName, String name, boolean hasoutput, Object... types) {
		this.schemaName = schemaName;
		this.name = name;
		this.hasoutput = hasoutput;
		initMappers(types);
	}

	public ProcedureDefinition(String schemaName, String name, int outputType, Object... types) {
		this.schemaName = schemaName;
		this.name = name;
		this.outputType = outputType;
		initMappers(types);
	}

	public void initMappers(Object... types) {
		this.types = new int[types.length];
		this.mapperName = new String[types.length];

		for (int i = 0; i < types.length; i++) {
			if (types[i] instanceof String) {
				mapperName[i] = (String) types[i];
				this.types[i] = Types.STRUCT;
			} else
				this.types[i] = ((Integer) types[i]).intValue();
		}

		init();
	}

	public String getMapperName(int i) {
		if (mapperName != null && mapperName.length > i)
			return mapperName[i];

		return null;
	}

	public void init() {

		StringBuilder buf = new StringBuilder();
		buf.append("{ ");

		if (hasoutput) {
			buf.append(" ?= ");

		}

		buf.append(" call ");

		if (schemaName != null)
			buf.append(schemaName + ".");

		buf.append(name + "(");

		if (types != null) {
			for (int i = 0; i < types.length; i++) {
				buf.append("?");

				if (i + 1 < types.length)
					buf.append(",");
			}
		}

		buf.append(")}");
		compiledSQL = buf.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RowMapper getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapper rowMapper) {
		this.rowMapper = rowMapper;
	}

	public int getOutputType() {
		return outputType;
	}

	public void setOutputType(int outputType) {
		this.outputType = outputType;
	}

	public int[] getTypes() {
		return types;
	}

	public void setTypes(int[] types) {
		this.types = types;
	}

	public String getCompiledSQL() {
		return compiledSQL;
	}

	public void setCompiledSQL(String compiledSql) {
		compiledSQL = compiledSql;
	}

	public boolean isHasoutput() {
		return hasoutput;
	}

	public void setHasoutput(boolean hasoutput) {
		this.hasoutput = hasoutput;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

}
