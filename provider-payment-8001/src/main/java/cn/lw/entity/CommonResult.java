package cn.lw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: linwei
 * @CreteTime: 2021/8/15
 * @Description:TODO
 */
@Data
@AllArgsConstructor//全参
@NoArgsConstructor//无参
public class CommonResult<T>{
   private Integer code;   //状态码
   private String message; //自定义信息
   private T      data;      //接收数据

   public CommonResult(Integer code,String message){//无参data
      //this(code,message);
      this.code=code;
      this.message=message;

   }
}
