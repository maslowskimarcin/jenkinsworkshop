@Library('workshop@library')_

pipeline {
   agent {
       label 'master'
   }
   stages {
       stage('Trigger check - indexing') {
            steps {
                script {
                    def causes = currentBuild.rawBuild.getCauses()
                    for (cause in causes) {
                        def causeDesc = cause.getShortDescription()
                        if (causeDesc.contains("Branch indexing")) {
                            currentBuild.result = 'ABORTED'
                            error('Aborting the build caused by: ' + causeDesc)
                        }
                    }
                }
            }
        }
       stage('Test') {
           steps {
               echo "test"
           }
       }
       stage('Build') {
           agent {
               label 'linux'
           }
           steps {
               sh script: 'ls -la'
               echo "build"
           }
       }
   }
}