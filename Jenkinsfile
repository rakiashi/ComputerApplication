pipeline {
  agent any 
  stages {
    stage('SCM Checkouts') {
      steps {
        git 'https://github.com/rakiashi/ComputerApplication.git'
      }
    }
    stage('Testing') {
      steps {
           sh "mvn clean install |  tee output.log"

            sh '! grep "ERROR" output.log'

            script {
               BUILD_COMPLETE = true
            }
      }
    }
  }
}
