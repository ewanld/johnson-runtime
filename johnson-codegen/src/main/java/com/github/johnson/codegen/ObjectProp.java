package com.github.johnson.codegen;

import com.github.johnson.codegen.types.JohnsonType;
import com.github.johnson.util.Maybe;

/**
 * Represent a property of a JSON Object. A property has a name, a type, and a 'required' flag.
 */
public class ObjectProp {
	public final boolean required;
	public final JohnsonType type;
	private final String name;

	public ObjectProp(String name, JohnsonType type, boolean required) {
		this.name = name;
		this.required = required;
		this.type = type;
	}

	public JohnsonType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getJavaName() {
		return CodeGenerator.toJavaFieldName(name);
	}

	public String getTypeName() {
		return required ? type.getTypeName()
				: String.format("%s<%s>", Maybe.class.getSimpleName(), type.getClassName());
	}

	public boolean isRequired() {
		return required;
	}

	public void accept(TypeVisitor visitor) {
		if (visitor.enterObjectProp(this)) {
			visitor.acceptAny(type);
		}
		visitor.exitObjectProp(this);
	}

	public String getDefaultValueExpr() {
		return required ? type.getDefaultValueExpr() : Maybe.class.getSimpleName() + ".empty()";
	}
}