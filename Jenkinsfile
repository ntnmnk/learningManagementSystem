pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clone the repository into the local directory
                    bat 'cd C:\\deploy && git clone https://github.com/ntnmnk/learningManagementSystem.git'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Navigate to the cloned repository and run Gradle build, skipping tests
                    bat 'cd C:\\deploy\\learningManagementSystem && gradle clean build -x test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Assuming the JAR name will follow the pattern 'learningManagementSystem-0.0.1-SNAPSHOT.jar'
                    def jarName = 'learning-management-system-0.0.1-SNAPSHOT.jar'

                    // Verify the JAR exists
                    bat "cd C:\\deploy\\learningManagementSystem\\build\\libs && if not exist ${jarName} exit 1"
                    echo "Found JAR: ${jarName}"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy the application by running the JAR file
                    def jarName = 'learningManagementSystem-0.0.1-SNAPSHOT.jar'

                    // Run the JAR using java -jar
                    bat "cd C:\\deploy\\learningManagementSystem\\build\\libs && java -jar ${jarName}"
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Deploy succeeded!'
        }
        failure {
            echo 'Build or Deploy failed!'
        }
    }
}
