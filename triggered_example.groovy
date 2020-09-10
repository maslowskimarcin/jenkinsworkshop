@Library('workshop@library')_

pipeline {
   agent {
       label 'master'
   }
   stages {
       stage("Check trigger"){
           when { triggeredBy 'Branch indexing' }
           steps {
               error('Aborting the build caused by: TimerTrigger')
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