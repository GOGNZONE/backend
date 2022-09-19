#!/bin/bash
REPOSITORY=/home/ubuntu/backend/zip
PROJECT_NAME=gongzone

echo "> Build 파일 복사"
mkdir /home/ubuntu/file
cp $REPOSITORY/*.jar /home/ubuntu/file/


echo "> 현재 구동중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -fl jar | awk '{print $1}')https://github.com/GOGNZONE/backend/blob/develop/scripts/deploy.sh
echo "현재 구동중인 어플리케이션 pid: $CURRENT_PID" 
if [ -z "$CURRENT_PID" ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -9 $CURRENT_PID"
    sudo kill -9 $CURRENT_PID
    sleep 5
fi

echo "> 새 어플리케이션 배포"
JAR_NAME=$(ls -tr /home/ubuntu/file/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

sudo chmod 755 $REPOSITORY

echo "> $JAR_NAME 실행"
echo "> cicd test"

sudo nohup java -jar $JAR_NAME& 
