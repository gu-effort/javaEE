package cdu.gu.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {
    Date now = new Date();

    // 格式化日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = sdf.format(now);
    //写入文件地址
    String filePath = "F:\\javaEE\\springshiyan4\\记录操作.txt"; // 文件路径
    public void xieru(String data){
        try {
            // 创建 FileWriter 对象，用于向文件中写入数据
            // 第二个参数为 true，表示在文件末尾追加写入
            FileWriter fw = new FileWriter(filePath, true);
            // 创建 BufferedWriter 对象，用于缓冲写入的数据
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine(); // 写入换行符
            // 关闭 BufferedWriter 和 FileWriter 对象
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterReturning("execution(* cdu.gu.service.EmployeeService.add(..))")
    public void add(JoinPoint joinPoint) {
        //获取连接点的对应参数
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  增加员工。"+"员工参数"+Arrays.toString(args);
        xieru(data);
    }
    @After("execution(* cdu.gu.service.EmployeeService.mod(..))")
    public void update(JoinPoint joinPoint) {
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  修改员工。"+"员工参数"+Arrays.toString(args);
      xieru(data);
    }
    @After("execution(* cdu.gu.service.EmployeeService.del(int))")
    public void del(JoinPoint joinPoint) {
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  删除id为"+Arrays.toString(args)+"的员工";
       xieru(data);
    }
    @After("execution(* cdu.gu.service.DepartmentService.add(..))")
    public void depadd(JoinPoint joinPoint) {
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  增加部门。"+"部门参数为"+Arrays.toString(args);
      xieru(data);
    }
    @After("execution(* cdu.gu.service.DepartmentService.mod(..))")
    public void depupdate(JoinPoint joinPoint) {
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  修改部门。"+"部门参数为"+Arrays.toString(args);
        xieru(data);
    }
    @After("execution(* cdu.gu.service.DepartmentService.del(int))")
    public void depdel(JoinPoint joinPoint) {
        Object[] args=joinPoint.getArgs();
        String data=formattedDate+"  删除id为"+Arrays.toString(args)+"的部门";
        xieru(data);
    }

}

