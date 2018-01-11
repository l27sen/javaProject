package com.sen.springboot.processor;

 import org.apache.commons.io.IOUtils;
 import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by seli on 2017-12-29.
 */
@Component
public class ScriptCaller {

    public String invokeScriptByParameters(Map<String, String> paramMap) {
        paramMap.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));
        return "invoked script";
    }


    public String invokeScriptByFile(File file, String scriptName) throws Exception{
       return executeCommand("/tmp/"+scriptName+" " + file.getAbsolutePath());

    }
    private static String executeCommand(String command) {
        String output = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            output = IOUtils .toString(reader);
            if (StringUtils.isEmpty(output)) {
                reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                output = IOUtils.toString(reader);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
         }
        return output;
    }
}
