package com.sen.springboot.controller;

import com.sen.springboot.processor.ScriptCaller;
import com.sen.springboot.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by seli on 2017-12-29.
 */
@RestController
public class WebController {
    private final Logger logger = LoggerFactory.getLogger(WebController.class);
    private String UPLOADED_FOLDER = "/tmp/";
    private String JSON_RES = "{  \n"
            + "  \"Fund ID\":{  \n"
            + "    \"0\":\"FTA024258\",\n"
            + "    \"1\":\"FTA024259\"\n"
            + "  },\n"
            + "  \"Bloomberg ID\":{  \n"
            + "    \"0\":\"BBG000P6XXV5\",\n"
            + "    \"1\":\"BBG000QCRGK7\"\n"
            + "  },\n"
            + "  \"NAV\":{  \n"
            + "    \"0\":70,\n"
            + "    \"1\":50\n"
            + "  },\n"
            + "  \"Regulatory_Consideration\":{  \n"
            + "    \"0\":100,\n"
            + "    \"1\":100\n"
            + "  },\n"
            + "  \"Redemption_Risk\":{  \n"
            + "    \"0\":20,\n"
            + "    \"1\":20\n"
            + "  },\n"
            + "  \"IO_IC\":{  \n"
            + "    \"0\":84,\n"
            + "    \"1\":84\n"
            + "  },\n"
            + "  \"LT_PL\":{  \n"
            + "    \"0\":86,\n"
            + "    \"1\":86\n"
            + "  },\n"
            + "  \"Weighted_Score\":{  \n"
            + "    \"0\":78.916,\n"
            + "    \"1\":72.176\n"
            + "  },\n"
            + "  \"Model IG\":{  \n"
            + "    \"0\":95,\n"
            + "    \"1\":90\n"
            + "  }\n"
            + "}";


    private String tableJSON ="[  \n"
            + "  {  \n"
            + "    \"Fund Tracker ID\":\"FTA024258\",\n"
            + "    \"Fund Name\":\"BlueBay High Yield Bond Fund\",\n"
            + "    \"Agent Tracker ID\":\"ATA000096\",\n"
            + "    \"Agent Name\":\"BlueBay Asset Management as Agent\",\n"
            + "    \"Level\":\"1\",\n"
            + "    \"Fund Type\":\"UCITS\",\n"
            + "    \"Recourse\":\"Fund\",\n"
            + "    \"Fund IG\":\"90\",\n"
            + "    \"Bloomberg ID\":\"BBG000P6XXV5\",\n"
            + "    \"NAV Date\":\"03/31/2016\",\n"
            + "    \"NAV\":\"675,560,100\",\n"
            + "    \"NAV Currency\":\"EUR\",\n"
            + "    \"FACT1\":\"1234\",\n"
            + "    \"FACT2\":\"5678\",\n"
            + "    \"Final IG\":\"90.0\"\n"
            + "  },\n"
            + "  {  \n"
            + "    \"Fund Tracker ID\":\"FTA024259\",\n"
            + "    \"Fund Name\":\"BlueBay High Yield Corporate Bond Fund\",\n"
            + "    \"Agent Tracker ID\":\"ATA000096\",\n"
            + "    \"Agent Name\":\"BlueBay Asset Management as Agent\",\n"
            + "    \"Level\":\"1\",\n"
            + "    \"Fund Type\":\"UCITS\",\n"
            + "    \"Recourse\":\"Fund\",\n"
            + "    \"Fund IG\":\"90\",\n"
            + "    \"Bloomberg ID\":\"BBG000QCRGK7\",\n"
            + "    \"NAV Date\":\"03/31/2016\",\n"
            + "    \"NAV\":\"258,876,700\",\n"
            + "    \"NAV Currency\":\"EUR\",\n"
            + "    \"FACT1\":\"1234\",\n"
            + "    \"FACT2\":\"5678\",\n"
            + "    \"Final IG\":\"92.0\"\n"
            + "  }\n"
            + "]";
    @Autowired
    ScriptCaller scriptCaller;



    @RequestMapping("/servers") String server() {
        return "server1";
    }

    @RequestMapping(value = "/loadData", method = RequestMethod.GET) String load() {
        return tableJSON;
    }

    @RequestMapping(value = "/script/json", method = RequestMethod.GET) String script() {
        System.out.println("called");
        return JSON_RES;
    }

    @RequestMapping(value = "/script/json", method = RequestMethod.POST) String scriptPost(@RequestBody String message, @RequestParam(value = "model", required = false) String modeId) throws Exception{
        System.out.println("called"+ URLDecoder.decode(message, "UTF-8"));
        System.out.println("model id:"+ modeId);

        return JSON_RES;
    }

    @RequestMapping(value = "/script/v1/call", method = RequestMethod.POST) String scriptInvoke(@RequestBody final String message) {
        Map<String, String> parameterMap = JSONUtil.buildMapFromJson(message);
        return scriptCaller.invokeScriptByParameters(parameterMap);
    }

    // test by curl -F a="b"  -F inputFile=@"file" http://localhost:8080/script/v1/callWithFile
    @RequestMapping(value = "/script/v1/callWithFile", method = RequestMethod.POST)
    public ResponseEntity<?> scriptInvokeWithFile(@RequestParam(value = "inputFile", required = false) MultipartFile uploadfile,
            @RequestParam Map<String, Object> paramMap) throws Exception {

        paramMap.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));

        //logger.info("paramMap size :" + paramMap.size());
        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        File file = null;
        try {
            file = saveUploadedFiles(Arrays.asList(uploadfile));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(" \n" + scriptCaller.invokeScriptByFile(file, findScriptName(paramMap)), HttpStatus.OK);
    }

    private String findScriptName(Map<String, Object> paramMap) {
        String script = "";
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("script")) {
                script = entry.getValue().toString();
            }

        }
        return script;
    }

    private File saveUploadedFiles(List<MultipartFile> files) throws IOException {
        Path path = null;
        File fileOut = null;
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            fileOut = new File(UPLOADED_FOLDER + file.getOriginalFilename());
        }
        return fileOut;

    }
}
