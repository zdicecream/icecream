# icecream

>**技术选型**  

|组件名称|
|---|
|redis|
|kafka|
|redis|
|redis|
|redis|



>**文件目录**

project  
　　|--common 通用                
　　　 |--base（response controller constant(常量) enums(枚举) exception）  
　　　 |--util（excel，httpClient，responseUtil，hutool（暂定））  
　　　 |--workflow（框架 or 自己写）    
　　|--config    
　　　 |--序列化(fastJson、jackson**)        
　　　 |--日志框架（logback）         
　　　 |--全局异常       
　　　 |--swagger2 接口文档               
　　　 |--mybatis        
　　　 |--mybatis-plus    
　　　 |--连接池Config (springboot默认HiKariCP或Druid)  
　　　 |--codeGenerator 代码生成器   
　　　 |--redis   
　　　 |--kafka   
　　　 |--权限认证（sa-token）    
　　|--auth 权限  
　　　 |--controller  
　　　 |--entity  
　　　 |--service  
　　　 |--mapper      
　　|--dispatch（Quartz或者xxl-job）调度(和springBatch批量任务合并)  
　　|--business 业务模块  
　　　　|--系统管理  
　　　　　　|--字典  
　　　　　　|--日历  
　　　　　　|--基础数据管理  
　　　　　　|--通知公告  
　　　　　　|--产品类型  
　　　　|--外围通讯(communications)  
　　　　　　|--kafka    
　　　　　　|--接口注册  
　　　　　　|--报文日志查询  
　　　　　　|--通讯状态  
　　　　　　|--错误报文监控  
　　　　|--客户信息  
　　　　　　|--基本信息  
　　　　　　|--签约开通管理  
　　　　|--账务往来  
　　　　　　|--资金监控  
　　　　　　|--流水查询  
　　　　　　|--账务核对  
　　　　　　|--会记分录  
　　　　|--风险管理  
　　　　　　|--规则引擎  
　　　　　　|--校验管理  
　　　　　　|--风险预警  
　　　　　　|--授信管理  
　　　　|--报表生成  
　　　　　　|--报表  
　　　　　　|--业务跟踪  
　　　　|--审批管理  
　　　　　　|--工作流引擎  
　　　　　　|--工作流业务模块  
　　|--search 搜索  

