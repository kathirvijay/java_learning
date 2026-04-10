# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER lqx
# VOLUME 指定临时文件目录为/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名
ADD ${rootArtifactId}-1.0.0.jar ${rootArtifactId}.jar
# 运行jar包
RUN bash -c 'touch /${rootArtifactId}.jar'
ENTRYPOINT ["java","-jar","/${rootArtifactId}.jar"]
#暴露端口作为微服务端口
EXPOSE 8087
