package Shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class RunShell {
    private static final String DIR = "F:/demo";

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb =
                //参数是需要程序和参数
                new ProcessBuilder(DIR + "/" + "demo.sh", DIR, "demo1231");
        Process ps = pb.start();
        System.out.println("开始执行脚本文件....");
        try {
            ps.waitFor(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("执行脚本超时100秒....");
        }
        //获取输出
        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        ps.destroyForcibly();
    }

/*    public static void main(String[] args){
        try {
            String shpath="F:/demo/demo.sh";
            Process ps = Runtime.getRuntime().exec(shpath);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
