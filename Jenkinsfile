pipeline {
    agent any
    tools {
        maven 'maven360'
    }
    stages {
        stage('Checkout de git') {
            steps {
                git credentialsId: 'usuariogit', url: 'https://github.com/Canales4/pipeline-example.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Ejecutando test'
                sh 'mvn verify'
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn archetype:generate -DgroupId=com.baeldung -DartifactId=tomcat-war-deployment
                      -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false'
                sh 'mvn tomcat7:deploy'
            }
        }
    }
}
