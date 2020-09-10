pipeline {
   agent any
   stage('Stage') {
       stage('Build') {
           options {
               retry(2)
           }
           steps {
               retry(3) {
                   echo "Error 1"
                   error("error1")
               }
               echo "Error 2"
               error("error2")
           }
       }
   }
}