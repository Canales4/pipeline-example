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
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                parallel 'Sonar Test': {
                    script {
                        withSonarQubeEnv('sonar-6'){
                            sh 'mvn sonar:sonar'
                        }
                    }
                }, 'Test': {
                      sh 'mvn verify'
                      sh 'mvn verify -Dwebdriver.type=chrome -Dwebdriver.chrome.driver=C:\\chromedriver.exe'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn cargo:deploy'
            }
        }
    }
}
