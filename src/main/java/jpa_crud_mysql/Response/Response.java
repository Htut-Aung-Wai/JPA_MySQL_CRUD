package jpa_crud_mysql.Response;

public class Response {
    public String successOutput;
    public Object result;

    public Response(String successOutput, Object result) {
        this.successOutput = successOutput;
        this.result = result;
    }


}
