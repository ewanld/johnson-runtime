package com.github.johnson.codegen.types;

import com.github.johnson.BooleanParser;
import com.github.johnson.codegen.TypeVisitor;

public class BooleanType extends PrimitiveType {

	public BooleanType(boolean nullable) {
		super(nullable);
	}

	public BooleanType() {
		this(false);
	}

	@Override
	public String getTypeName() {
		return nullable ? Boolean.class.getSimpleName() : "boolean";
	}

	@Override
	public String getClassName() {
		return Boolean.class.getSimpleName();
	}

	@Override
	public String getJacksonGetterName() {
		return "getBooleanValue";
	}

	@Override
	public String getDefaultValueExpr() {
		return nullable ? "null" : "false";
	}

	@Override
	public String getNewParserExpr() {
		return String.format("new %s(%s)", BooleanParser.class.getSimpleName(), Boolean.toString(nullable));
	}

	public void accept(TypeVisitor visitor) {
		visitor.visitBool(this);
	}
}