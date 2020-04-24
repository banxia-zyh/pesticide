# 软件缺陷管理系统(pesticide)

## 项目简介
* 该项目为web应用，使用SpringBoot+Vue的前后端分离架构进行开发。
* 具有注册、登录、修改个人信息、项目管理、人员管理、缺陷管理等功能。
* 实际开发时间约两周，从2019-10-7到2019-10-20。
* 由于本身身单力薄，时间和水平有限，项目中难免有纰漏之处，仅供学习交流，有帮助可以点个star。

## 项目启动
1. 使用IDEA打开项目根目录。

2. 项目后端在pesticide-server，修改resources/application.yml中的数据库和文件上传路径配置，创建数据库（不要创建表），点击PesticideApplication的main方法启动。

3. 项目前端在pesticide-web，点击package.json文件中的`"start": "npm run dev"`左侧的启动按钮启动，或使用命令启动：
```bash
cd pesticide-web
npm run dev
```
