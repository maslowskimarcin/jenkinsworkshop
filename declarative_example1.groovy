@Library('workshop@library')_

pipeline {
   agent {
       label 'master'
   }
   stages {
       stage('Preparation') {
           agent {
               label 'linux'
           }
           steps {
               checkout scm
           }
       }
       stage(Build) {
           agent {
               label 'linux'
           }
           steps {
               checkout scm
               build()
           }
       }
   }
}