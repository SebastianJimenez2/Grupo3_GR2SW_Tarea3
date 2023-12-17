pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/tu-usuario/tu-proyecto.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'  // o './mvnw clean package' para Maven
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'  // o './mvnw test' para Maven
            }
        }

        stage('Deploy') {
            steps {
                sh 'java -jar build/libs/tu-proyecto.jar'
            }
        }
    }
}
