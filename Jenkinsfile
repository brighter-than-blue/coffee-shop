pipeline {
    environment {
        SONAR_LOGIN = credentials('sonar')
        SONAR_HOST_URL = "http://192.168.1.145:9000"
    }
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Sonar') { 
            steps {
                sh 'mvn -Dsonar.login=$SONAR_LOGIN -Dsonar.host.url=$SONAR_HOST_URL sonar:sonar'
            }
        }
/*
        stage('Sonar using docker') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2 --name $JOB_NAME -v $WORKSPACE:/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8'
                }
            }
            steps {
                sh "mvn -Dsonar.login=$SONAR_LOGIN -Dsonar.host.url=$SONAR_HOST_URL sonar:sonar"

            }
        }
*/
    }
}
