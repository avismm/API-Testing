package utils;

//import APISteps.APIWorkflowSteps;
import org.json.JSONObject;

public class APIPayloads {

    public static String generateTokenPayload(){
      String generateToken =  "{\n" +
              "  \"email\": \"avism@batch17.com\",\n" +
              "  \"password\": \"Test@123\"\n" +
              "}";
      return generateToken;
    }

    public static String createEmployeePayload(){
      String createEmployee =  "{\n" +
                "  \"emp_firstname\": \"hind\",\n" +
                "  \"emp_lastname\": \"pak\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2002-11-25\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"qa\"\n" +
                "}";
      return createEmployee;
    }

public static String createEmployeeJsonPayload(){
    JSONObject obj =new JSONObject();
    obj.put("emp_firstname","hind");
    obj.put("emp_lastname","pak");
    obj.put("emp_middle_name","ms");
    obj.put("emp_gender","M");
    obj.put("emp_birthday","2002-11-25");
    obj.put("emp_status","confirmed");
    obj.put("emp_job_title","qa");

    return obj.toString();
}

public static String payloadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name,
                                    String emp_gender, String emp_birthday, String emp_status,String emp_job_title){
    JSONObject obj =new JSONObject();
    obj.put("emp_firstname",emp_firstname);
    obj.put("emp_lastname",emp_lastname);
    obj.put("emp_middle_name",emp_middle_name);
    obj.put("emp_gender",emp_gender);
    obj.put("emp_birthday",emp_birthday);
    obj.put("emp_status",emp_status);
    obj.put("emp_job_title",emp_job_title);

    return obj.toString();
}

public static String updateEmployeePayload(){
        JSONObject obj=new JSONObject();
        //obj.put("employee_id", APIWorkflowSteps.employee_id);
     //   obj.put("employee_id", "");
        obj.put("emp_firstname","hind");
        obj.put("emp_lastname","pak");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2002-11-25");
        obj.put("emp_status","suspended");
        obj.put("emp_job_title","qa");

        return obj.toString();
}


}
