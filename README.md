# gmal0105本地修改版本

# gmall-user用户服务8080

gmall-user-service用户服务的service层8070
gmall-user-web用户服务的web层8080

gmall-manage-service用户服务的service层8071
gmall-manage-web用户服务的web层8081

gmall-item-service前台的商品详情服务 8072
gmall-item-web前台的商品详情展示 8082

dubbo启动：service dubbo-admin start
访问地址：http://192.168.136.131:8080/dubbo

zookeeper启动：service zookeeper start

nginx启动：进入nginx的sbin目录，./nginx

后台管理页面启动（前后端分离）：进入 F:\谷粒商城\gmall-admin\gmall-admin cmd 打开输入 npm run dev 
启动前端服务 地址：http://127.0.0.1:8888/#/login?redirect=%2Fdashboard