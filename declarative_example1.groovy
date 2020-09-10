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
               echo "checkout scm"
               checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                        doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                        userRemoteConfigs: [[credentialsId: '88be31a8-fb7f-452a-88fa-dd5ef1eac6ee', url: 'https://github.com/maslowskimarcin/jenkinsworkshop.git']]])
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