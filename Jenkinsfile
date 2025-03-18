pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/prasannac-ai/hash-app.git'
            }
        }

        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }

        stage('Build') {
            steps {
                sh "mvn install"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('Report') {
            steps {
                sh "mvn surefire-report:report"
            }
        }
    }

    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}