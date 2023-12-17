pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clonar el repositorio
                git 'https://github.com/SebastianJimenez2/Grupo3_GR2SW_Tarea3.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Usar Maven para construir y ejecutar las pruebas
                sh 'mvn clean install'
            }
        }

        stage('Deploy') {
            steps {
                // Despliegue o ejecución adicional según tus necesidades
                sh 'java -jar target/tu-proyecto.jar'
            }
        }
    }

    post {
        // Acciones posteriores
        success {
            echo '¡Construcción exitosa! Puedes agregar acciones adicionales aquí.'
        }
        failure {
            echo '¡La construcción falló! Puedes agregar acciones adicionales aquí.'
        }
    }
}
