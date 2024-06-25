package extensions

import com.android.build.api.dsl.ProductFlavor


/**
 * Extension to adds a new string field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the string value of the field
 */

fun ProductFlavor.resValueString(name: String, value: String) {
    this.resValue("string", name, value)
}

/**
 * Extension to adds a new integer field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the int value of the field
 */
fun ProductFlavor.resValueInt(name: String, value: String) {
    this.resValue("integer", name, value)
}

/**
 * Extension to adds a new boolean field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the boolean value of the field
 */
fun ProductFlavor.resValueBoolean(name: String, value: String) {
    this.resValue("bool", name, value)
}

