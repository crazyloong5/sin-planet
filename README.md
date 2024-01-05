# sin-planet

## 介绍

[后端开发文档](#back)
[前端开发文档](#front)

## 软件架构



## 安装教程



## 使用说明



## 后端开发文档 <a id="back"></a>

### 构建项目

使用idea创建maven项目，分为四个基本模块

### 配置多元数据库，整合druid数据源

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>dynamic-datasource-spring-boot3-starter</artifactId>
    <version>4.2.0</version>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-3-starter</artifactId>
    <version>1.2.21</version>
</dependency>
```

```yaml
spring:
  datasource:
    # 设置动态数据源
    dynamic:
      # 设置默认的数据源或者数据源组
      primary: master
      # 严格匹配数据源,默认false. true未匹配到指定数据源时抛异常,false使用默认数据源
      strict: false
      datasource:
        # 主数据源
        master:
          # 数据库驱动完整类名
          driver-class-name: com.mysql.cj.jdbc.Driver
          # 数据库连接url
          url: jdbc:mysql://localhost:3306/myproject?characterEncoding=utf-8&serverTimezone=UTC
          # 数据库用户名
          username: root
          # 数据库密码
          password: 123456
        # 从数据源
        slave:
          # 数据库驱动完整类名
          driver-class-name: com.mysql.cj.jdbc.Driver
          # 数据库连接url
          url: jdbc:mysql://110.42.229.67:3306/myproject?characterEncoding=utf-8&serverTimezone=UTC
          # 数据库用户名
          username: root
          # 数据库密码
          password: sinlovehutao520

    # druid 连接池管理
    druid:
      filter:
        config:
          # 开启密钥加密
          enabled: true
        stat:
          enabled: true
      # 配置默认的监控统计拦截的Filter
      # 不配置则监控页面中的SQL无法统计
      # stat - SQL监控配置
      # wall - SQL防火墙配置
      # slf4j - Druid日志配置
      filters: stat,wall,slf4j
      # 初始化连接池大小
      initial-size: 5
      # 连接池最大连接数
      max-active: 20
      # 每个连接上PSCache的最大值
      # 如果大于0，pool-prepared-statements自动开启
      max-pool-prepared-statement-per-connection-size: -1
      # 连接时最大等待时间（单位：毫秒）
      max-wait: 60000
      # 保持空闲连接不被关闭的最小生存时间（单位：毫秒）
      min-evictable-idle-time-millis: 300000
      # 连接池最小空闲数
      min-idle: 5
      # 是否开启PSCache，即是否缓存preparedStatement（提升写入、查询效率）
      # 建议在支持游标的数据库开启，例如：Oracle
      pool-prepared-statements: false
      # 检测获取连接时的有效性
      # 开启后会影响性能
      test-on-borrow: false
      # 检测归还连接时的有效性
      # 开启后会影响性能
      test-on-return: false
      # 检测空闲连接
      # 不影响性能，建议开启
      test-while-idle: true
      # 检测关闭空闲连接的时间间隔（单位：毫秒）
      time-between-eviction-runs-millis: 60000
      # 检测连接有效的SQL
      # 为空则test-while-idle、test-on-borrow、test-on-return配置失效
      validation-query: SELECT 1
      # 检测连接是否有效的超时时间
      validation-query-timeout: 1
      stat-view-servlet:
        # 访问白名单
        allow: 127.0.0.1
        # 配置统计页面
        enabled: true
        # 访问用户名
        login-username: root
        # 访问密码
        login-password: 123456
        # 允许重置监控数据
        reset-enable: true
      web-stat-filter:
        # 配置统计页面过滤
        enabled: true
        # 排除路径
        exclusions: .js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*
        # 开启session统计
        session-stat-enable: true
        # session统计的最大个数
        session-stat-max-count: 100
        # 过滤路径
        url-pattern: /*
```



### 整合Mybatis-Plus

```xml
<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.3.1</version>
</dependency>

<!--mybatis-plus代码生成器（可以不使用）-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.3.1</version>
</dependency>
```

```yaml
mybatis-plus:
  global-config:
    # banner图
    banner: off
    db-config:
      # 主键类型：自增
      id-type: auto
  type-aliases-package: classpath*:com.sin.**.mapper
  # mapper.xml文件路径
  mapper-locations: classpath*:/mapper/**/*.xml
```



### 整合Knife4j Api文档

```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
    <version>4.1.0</version>
</dependency>
```

```yaml
springdoc:
  swagger-ui:
    path: /swagger-ui.html
    tags-sorter: alpha
    operations-sorter: alpha
  api-docs:
    path: /v3/api-docs
  group-configs:
    - group: 'test'
      paths-to-match: '/**'
      packages-to-scan: com.sin.web.test
    - group: 'admin'
      paths-to-match: '/**'
      packages-to-scan: com.sin.web.admin
    - group: 'user'
      paths-to-match: '/**'
      packages-to-scan: com.sin.web.user

knife4j:
  enable: true
  setting:
    language: zh_cn
```





## 前端开发文档 <a id="front"></a>

### 构建项目

使用npm创建vue项目



## 参与贡献

