package Day2;

public class JsonValue {
private String str;
private JsonObject jObj;
private JsonValue[] jArray;
/* Implement 3 constructors each of which takes one of
String, JsonObject or array of JsonValues as argument, and
assigns it to the appropriate field. Only one of these three
fields should be non-null */
// ... the constructors
// we will need 3 different methods for accessing theappropriate fields.
// Note that this helps with strong-typing
String getString() {
	return str;
}
JsonObject getObj() {
	return jObj;
}
JsonValue[] getArray() {
	return jArray;
}
}
