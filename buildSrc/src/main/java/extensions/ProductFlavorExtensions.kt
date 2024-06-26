package extensions

import com.android.build.api.dsl.ProductFlavor

/**
 * Extension to adds a new long field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the long value of the field
 */
fun ProductFlavor.buildConfigLongField(name: String, value: String) {
    this.buildConfigField("Long", name, value)
}

/**
 * Extension to adds a new string field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the string value of the field
 */
fun ProductFlavor.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

/**
 * Extension to adds a new integer field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the int value of the field
 */
fun ProductFlavor.buildConfigIntField(name: String, value: Int) {
    this.buildConfigField("int", name, value.toString())
}

/**
 * Extension to adds a new boolean field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the boolean value of the field
 */
fun ProductFlavor.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, value.toString())
}