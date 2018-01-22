package jsonschema;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class ValidatorUtils {

	public static final String JSON_V4_SCHEMA_IDENTIFIER = "http://json-schema.org/draft-04/schema#";
	public static final String JSON_SCHEMA_IDENTIFIER_ELEMENT = "$schema";

	public static JsonNode getJsonNode(String jsonText) throws IOException {
		return JsonLoader.fromString(jsonText);
	} // getJsonNode(text) ends

	public static JsonNode getJsonNode(File jsonFile) throws IOException {
		return JsonLoader.fromFile(jsonFile);
	} // getJsonNode(File) ends

	public static JsonSchema getSchemaNode(String schemaText)
			throws IOException, ProcessingException {
		final JsonNode schemaNode = getJsonNode(schemaText);
		return _getSchemaNode(schemaNode);
	} // getSchemaNode(text) ends

	public static JsonSchema getSchemaNode(File schemaFile)
			throws IOException, ProcessingException {
		final JsonNode schemaNode = getJsonNode(schemaFile);
		return _getSchemaNode(schemaNode);
	} // getSchemaNode(File) ends

	public static void validateJson(JsonSchema jsonSchemaNode,
			JsonNode jsonNode) throws ProcessingException {
		ProcessingReport report = jsonSchemaNode.validate(jsonNode);
		if (!report.isSuccess()) {
			for (ProcessingMessage processingMessage : report) {
				throw new ProcessingException(processingMessage);
			}
		}
	} // validateJson(Node) ends

	public static ProcessingReport isJsonValid(JsonSchema jsonSchemaNode,
			JsonNode jsonNode) throws ProcessingException {
		ProcessingReport report = jsonSchemaNode.validate(jsonNode);
		return report;
	} // validateJson(Node) ends

	public static ProcessingReport isJsonValid(String schemaText,
			String jsonText) throws ProcessingException,
			IOException {
		final JsonSchema schemaNode = getSchemaNode(schemaText);
		final JsonNode jsonNode = getJsonNode(jsonText);
		return isJsonValid(schemaNode, jsonNode);
	} // validateJson(Node) ends

	public static ProcessingReport isJsonValid(File schemaFile,
			File jsonFile) throws ProcessingException, IOException {
		final JsonSchema schemaNode = getSchemaNode(schemaFile);
		final JsonNode jsonNode = getJsonNode(jsonFile);
		return isJsonValid(schemaNode, jsonNode);
	} // validateJson(Node) ends

	private static JsonSchema _getSchemaNode(JsonNode jsonNode)
			throws ProcessingException {
		final JsonNode schemaIdentifier = jsonNode
				.get(JSON_SCHEMA_IDENTIFIER_ELEMENT);
		if (null == schemaIdentifier) {
			((ObjectNode) jsonNode).put(
					JSON_SCHEMA_IDENTIFIER_ELEMENT,
					JSON_V4_SCHEMA_IDENTIFIER);
		}

		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		return factory.getJsonSchema(jsonNode);
	} // _getSchemaNode() ends
}