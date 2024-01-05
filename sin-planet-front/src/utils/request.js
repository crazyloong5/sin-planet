// 封装axios，做请求处理

//导入axios
import router from "@/router";
import axios from "axios";
import { ElMessage } from "element-plus";
//获取token
import { getToken } from "./token/index.js";

//创建axios
const request = axios.create({
  //根请求地址
  baseURL: "http://localhost:8888",
  //配置请求接口跨域时是否需要凭证
  withCredentials: false,
  //超时时间，单位毫秒
  timeout: 30000,
});

//配置请求头的参数类型
axios.defaults.headers["Content-Type"] = "application/json?charset=utf-8";

//配置请求的拦截器
request.interceptors.request.use(
  (config) => {
    // 在请求头中添加token，判断是否需要发送token
    var tmp = getToken("Hutaotoken");
    if (tmp) {
      config.headers["Sin-Authorization"] = tmp;
    }
    return config;
  },
  (error) => {
    //发生异常
    console.log("请求异常--->", error);
    return Promise.reject(error);
  }
);

//配置响应拦截器
request.interceptors.response.use(
  (response) => {
    //判断响应码后返回数据
    let { code, msg } = response.data;
    if (code == null) {
      return response;
    } else if (code === 200) {
      return response;
    } else if (code === 500) {
      ElMessage.error("服务端异常");
    } else if (code === 403) {
      ElMessage.error("无操作权限");
    } else if (code === 401) {
      ElMessage.error("需要登陆后操作");
      //跳转到登录页面，清除pinla中的数据（sessonStorage中）
      window.sessionStorage.clear();
      router.push("/login");
    }
    return Promise.reject(msg);
  },
  (error) => {
    //出现异常
    ElMessage.error("error---->", error);
    window.sessionStorage.clear();
    router.push("/login");
    return Promise.reject(error);
  }
);

//导出
export default request;
