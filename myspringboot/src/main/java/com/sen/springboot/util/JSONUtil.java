package com.sen.springboot.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Contains methods to process JSON requests and generate JSON responses.
 */
public final class JSONUtil {

    public static final String JSON_SEP = "###";
    public static final String DOMAINFIELD = "domainFields";

    public static Map<String, String> dbMapping = new HashMap<>();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        dbMapping.put("mediaGuid", "guid");
        dbMapping.put("clientId", "client-id");
        dbMapping.put("userId", "user-id");
        dbMapping.put("fileUrl", "file-url");
        dbMapping.put("fileName", "file-name");
        dbMapping.put("active", "active");
        dbMapping.put("domain", "domain");
        dbMapping.put("domainId", "domain-id");
        dbMapping.put("domainDerivativeCategory", "derivative-category");
        dbMapping.put("domainProvider", "provider");
        dbMapping.put("domainFields", "domain-fields");
        dbMapping.put("width", "width");
        dbMapping.put("height", "height");
        dbMapping.put("fileSize", "file-size");
        dbMapping.put("derivatives", "derivatives");
        dbMapping.put("hidden", "hidden");
        dbMapping.put("comment", "comments");
        dbMapping.put("sourceUrl", "source-url");
        dbMapping.put("rotation", "rotation");
        dbMapping.put("providedName", "provided-name");
    }

    private JSONUtil() {
    }

    /**
     * Converts json message to java map object
     *
     * @param jsonMessage input json format message
     * @return Map map object that contain json message value.
     */
    public static Map buildMapFromJson(String jsonMessage) {
        try {
            return OBJECT_MAPPER.readValue(jsonMessage, Map.class);
        } catch (IOException ex) {
            final String errorMsg = MessageFormat.format("Error parsing/converting Json message: {0}", jsonMessage);
        }
        return null;
    }



    /**
     * merge subJson avro message to ImageMessage.
     * @param joinJson
     * @return
     */
    public static String mergeToImageMessage(String joinJson) {
        final String[] arrays = joinJson.split(JSON_SEP);
        final Map<String, Object> mergedMap = new HashMap<>();
        for (int i = 0; i < arrays.length; i++) {
            final Map jsonMap = buildMapFromJson(arrays[i]);
            if (jsonMap.get(DOMAINFIELD) != null && jsonMap.get(DOMAINFIELD) instanceof Map) {
                final Map domainFieldMap = (Map) jsonMap.get(DOMAINFIELD);
                removeNullPropertyFromMap(domainFieldMap);
                jsonMap.put(DOMAINFIELD, domainFieldMap);
            }
            //after avro conversion, domainField is string
            if (jsonMap.get(DOMAINFIELD) != null && jsonMap.get(DOMAINFIELD) instanceof String) {
                String domainFieldString = (String) jsonMap.get(DOMAINFIELD);
                final Map domainMap = buildMapFromJson(domainFieldString);
                removeNullPropertyFromMap(domainMap);
                jsonMap.put(DOMAINFIELD, generateJsonByMap(domainMap));
            }
            mergedMap.putAll(jsonMap);
            if (jsonMap.get("workUrl") != null) {
                mergedMap.put("sourceUrl", jsonMap.get("workUrl"));
            }
        }
        return generateJsonByMap(mergedMap);
    }

    /**
     * remove null property from domainField like ""domainFields":"{\"subcategoryId\":null,\"propertyHero\":\"false\",\"rooms\":null}",
     * or else big sproc mediaAddAll will have error.
     *
     * @param map
     */
    private static void removeNullPropertyFromMap(Map<String, Object> map) {
        for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = it.next();
            if (entry.getValue() == null) {
                it.remove();
            }
        }
    }

    /**
     * generate JSON string based on Map
     *
     * @param map
     * @return
     */
    public static String generateJsonByMap(Map<String, Object> map) {
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }




}
