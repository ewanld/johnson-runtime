package com.github.johnson.codegen;

import com.github.johnson.codegen.types.ArrayType;
import com.github.johnson.codegen.types.BooleanType;
import com.github.johnson.codegen.types.DecimalType;
import com.github.johnson.codegen.types.DoubleType;
import com.github.johnson.codegen.types.IntType;
import com.github.johnson.codegen.types.JohnsonType;
import com.github.johnson.codegen.types.LongType;
import com.github.johnson.codegen.types.MapType;
import com.github.johnson.codegen.types.ObjectType;
import com.github.johnson.codegen.types.RawType;
import com.github.johnson.codegen.types.RefType;
import com.github.johnson.codegen.types.StringType;

/**
 * Hierarchical visitor of a JohnsonType object.
 */
public abstract class JohnsonTypeVisitor {
	public void visitBool(BooleanType type) {
	}

	public void visitDecimal(DecimalType type) {

	}

	public void visitDouble(DoubleType type) {

	}

	public void visitInt(IntType type) {

	}

	public void visitLong(LongType type) {

	}

	public void visitString(StringType type) {

	}

	public void visitRef(RefType ref) {
	}

	/**
	 * Implementors must return true if the children must be visited, false otherwise.
	 */
	public boolean enterObject(ObjectType type) {
		return true;
	}

	public void exitObject(ObjectType type) {
	}

	/**
	 * Implementors must return true if the children must be visited, false otherwise.
	 */
	public boolean enterRef(RefType type) {
		return true;
	}

	public void exitRef(RefType type) {
	}

	/**
	 * Implementors must return true if the child type must be visited, false otherwise.
	 */
	public boolean enterMap(MapType type) {
		return true;
	}

	public void exitMap(MapType type) {
	}

	/**
	 * Implementors must return true if the child type must be visited, false otherwise.
	 */
	public boolean enterArray(ArrayType type) {
		return true;
	}

	public void exitArray(ArrayType type) {
	}

	public void visitRaw(RawType type) {

	}

	public boolean enterObjectProp(ObjectProp objectProp) {
		return true;
	}

	public void exitObjectProp(ObjectProp objectProp) {

	}

	public final void acceptAny(JohnsonType type) {
		if (type == null) return;

		if (type instanceof BooleanType) {
			((BooleanType) type).accept(this);
		} else if (type instanceof DecimalType) {
			((DecimalType) type).accept(this);
		} else if (type instanceof DoubleType) {
			((DoubleType) type).accept(this);
		} else if (type instanceof IntType) {
			((IntType) type).accept(this);
		} else if (type instanceof LongType) {
			((LongType) type).accept(this);
		} else if (type instanceof StringType) {
			((StringType) type).accept(this);
		} else if (type instanceof ArrayType) {
			((ArrayType) type).accept(this);
		} else if (type instanceof ObjectType) {
			((ObjectType) type).accept(this);
		} else if (type instanceof RefType) {
			((RefType) type).accept(this);
		} else if (type instanceof MapType) {
			((MapType) type).accept(this);
		} else if (type instanceof RawType) {
			((RawType) type).accept(this);
		} else {
			throw new RuntimeException(String.format("Unknown type: %s!", type.getClass().getName()));
		}
	}
}