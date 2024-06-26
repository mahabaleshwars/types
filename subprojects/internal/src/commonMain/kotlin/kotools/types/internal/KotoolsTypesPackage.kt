package kotools.types.internal

/** Represents a package of Kotools Types. */
public enum class KotoolsTypesPackage {
    Experimental, Number, Text;

    /** Returns the string representation of this package. */
    override fun toString(): String = "kotools.types.${this.name.lowercase()}"
}
