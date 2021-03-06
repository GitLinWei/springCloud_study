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
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
public class CommonResult<T>{
   private Integer code;   //状态码
   private String message; //自定义信息
   private T      data;      //接收数据

   public CommonResult(Integer code, String message){//无参data
      this(code,message,null);
     /* this.code=code;
      this.message=message;*/

   }
}
