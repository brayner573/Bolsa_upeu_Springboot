pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Clone') {
            steps {
                timeout(time: 2, unit: 'MINUTES'){
                    git branch: 'main', credentialsId: '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', url: 'https://github.com/GaryFernandoYM/Bolsa_upeu_Springboot.git'
                }
            }
        }
        stage('Build') {
            steps {
                timeout(time: 8, unit: 'MINUTES'){
                    sh "mvn -DskipTests clean package -f bolsa-laboral/pom.xml"
                }
            }
        }
        stage('Test') {
            steps {
                timeout(time: 8, unit: 'MINUTES'){
                    sh "mvn clean install -f bolsa-laboral/pom.xml"
                }
            }
        }
        stage('Sonar') {
            steps {
                timeout(time: 4, unit: 'MINUTES'){
                    withSonarQubeEnv('sonarqube'){
                        sh "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar -Pcoverage -f bolsa-laboral/pom.xml"
                    }
                }
            }
        }
        stage('Quality gate') {
            steps {
                sleep(10) // seconds

                script {
                    try {
                        timeout(time: 3, unit: 'MINUTES') {
                            waitForQualityGate() // Sin abortPipeline para que no falle automáticamente
                        }
                    } catch (e) {
                        echo "Timeout o fallo del Quality Gate: ${e.getMessage()}, pero el pipeline continúa."
                        //ﬁﬁﬁ Si quieres marcar el stage como fallido pero continuar, puedes usar un buildResult
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "mvn spring-boot:run -f bolsa-laboral/pom.xml"
            }
        }
    }
}
